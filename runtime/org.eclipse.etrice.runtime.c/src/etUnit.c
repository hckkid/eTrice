/*******************************************************************************
 * Copyright (c) 2011 protos software gmbh (http://www.protos.de).
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * CONTRIBUTORS:
 * 		Thomas Schuetz (initial contribution)
 *
 *******************************************************************************/

#include "etUnit.h"
#include <string.h>
#include <time.h>
#include "etLogger.h"


/*** member variables */

/* file handling */
static FILE* etUnit_reportfile = NULL;

/* names */
static char* etUnit_TestFileName = NULL;
static char* etUnit_TestResultPath = NULL;

static char* etUnit_TestSuiteName = NULL;
static char* etUnit_TestCaseName = NULL;

/* counters */
static etInt32 etUnit_passCount = 0;
static etInt32 etUnit_failCount = 0;
static etInt32 etUnit_passCountTotal = 0;
static etInt32 etUnit_failCountTotal = 0;

static etBool etUnit_testcaseSuccess = TRUE;

#define ETUNIT_FAILURE_TEXT_LEN 256

static char etUnit_failureText[ETUNIT_FAILURE_TEXT_LEN];

/* time measuring */
static clock_t etUnit_startTime = 0;
static clock_t etUnit_currentTime = 0;

/* forward declarations of private functions */
void expect_equal_int(const char* message, etInt32 expected, etInt32 actual);
void expect_equal_uint(const char* message, etUInt32 expected, etUInt32 actual);
void expect_equal_float(const char* message, etFloat64 expected, etFloat64 actual, etFloat64 precision);
void etUnit_writeTestLog(const char *testcase, etBool result, const char *resulttext);
void etUnit_handleExpect(etBool result, const char *resulttext);

/* public functions */

void etUnit_open(char* testResultPath, char* testFileName) {
	etUnit_passCount = 0;
	etUnit_failCount = 0;
	strcpy(etUnit_failureText,"");

	etUnit_TestFileName = testFileName;
	etUnit_TestResultPath = testResultPath;

	etLogger_logInfoF("************* TEST START (%s) **************", etUnit_TestFileName);

	char filename[ETUNIT_FAILURE_TEXT_LEN];
	sprintf(filename, "%s/%s.xml", etUnit_TestResultPath, etUnit_TestFileName);

	if (etUnit_reportfile == NULL) {
		etUnit_reportfile = etLogger_fopen(filename, "w+");
		if (etUnit_reportfile != NULL) {
			etLogger_fprintf(etUnit_reportfile, "<testsuites name=\"%s\" tests=\"0\" failures=\"0\" errors=\"0\" time=\"0\">\n", etUnit_TestFileName);
		} else {
			etLogger_logErrorF("Unable to open file %s/%s.xml", etUnit_TestResultPath, etUnit_TestFileName);
		}
	}
	/* prepare time measurement */
	etUnit_startTime = clock();
	etUnit_currentTime = clock();
	etLogger_logInfoF("Start Time: %ld", etUnit_startTime);

}

void etUnit_close(void) {
	etLogger_logInfoF("");
	if (etUnit_failCount > 0) {
		etLogger_logInfoF("************* TEST FAILED *************");
	} else {
		etLogger_logInfoF("************* TEST PASSED *************");
	}
	etLogger_logInfoF("Number of Tests: %ld", etUnit_failCount + etUnit_passCount);
	etLogger_logInfoF("Failed: %ld", etUnit_failCount);
	etLogger_logInfoF("Passed: %ld", etUnit_passCount);
	etLogger_logInfoF("Time: %ld", clock() - etUnit_startTime);
	etLogger_logInfoF("End Time: %ld[ms]", (clock() / 1000) * CLOCKS_PER_SEC );
	etLogger_logInfoF("***************************************");
	if (etUnit_failCountTotal > 0) {
		etLogger_logInfoF("   ******* %d TEST(S) FAILED *****", etUnit_failCountTotal);
	} else {
		etLogger_logInfoF("   ******* ALL TESTS PASSED ******");
	}
	etLogger_logInfoF("***************************************");

	if (etUnit_reportfile != NULL) {
		etLogger_fprintf(etUnit_reportfile, "</testsuites>\n");
		etLogger_fclose(etUnit_reportfile);
		etUnit_reportfile = NULL;
	}
}

void etUnit_openTestSuite(char* testSuiteName) {
	etUnit_TestSuiteName = testSuiteName;
	if (etUnit_reportfile != NULL) {
		etLogger_fprintf(etUnit_reportfile, "\t<testsuite name=\"%s\" tests=\"0\" failures=\"0\" errors=\"0\" time=\"0\">\n",
				etUnit_TestSuiteName);
	}
}

void etUnit_closeTestSuite(void) {
	if (etUnit_reportfile != NULL) {
		etLogger_fprintf(etUnit_reportfile, "\t</testsuite>\n");
	}
}

void etUnit_openTestCase(char* testCaseName) {
	etUnit_TestCaseName = testCaseName;
	etUnit_testcaseSuccess = TRUE;
	strcpy(etUnit_failureText,"");
}

void etUnit_closeTestCase(void) {
	if (etUnit_reportfile != NULL && etUnit_TestSuiteName != NULL) {
		etUnit_writeTestLog(etUnit_TestCaseName, etUnit_testcaseSuccess, etUnit_failureText);
	}
}

void etUnit_openAll(char* testResultPath, char* testFileName, char* testSuiteName, char* testCaseName){
	etUnit_open(testResultPath, testFileName);
	etUnit_openTestSuite(testSuiteName);
	etUnit_openTestCase(testCaseName);
}

void etUnit_closeAll(void){
	etUnit_closeTestCase();
	etUnit_closeTestSuite();
	etUnit_close();
}

void EXPECT_TRUE(const char* message, etBool condition) {
	if (condition == FALSE) {
		char testresult[ETUNIT_FAILURE_TEXT_LEN];
		sprintf(testresult, "%s: *** EXPECT_TRUE == FALSE", message);
		etUnit_handleExpect(FALSE, testresult);
	} else {
		etUnit_handleExpect(TRUE, "");
	}
}

void EXPECT_FALSE(const char* message, etBool condition) {
	if (condition == TRUE) {
		char testresult[ETUNIT_FAILURE_TEXT_LEN];
		sprintf(testresult, "%s: EXPECT_FALSE == TRUE", message);
		etUnit_handleExpect(FALSE, testresult);
	} else {
		etUnit_handleExpect(TRUE, "");
	}
}

void EXPECT_EQUAL_INT8(const char* message, etInt8 expected, etInt8 actual) {
	expect_equal_int(message, (etInt32) expected, (etInt32) actual);
}

void EXPECT_EQUAL_INT16(const char* message, etInt16 expected, etInt16 actual) {
	expect_equal_int(message, (etInt32) expected, (etInt32) actual);
}

void EXPECT_EQUAL_INT32(const char* message, etInt32 expected, etInt32 actual) {
	expect_equal_int(message, (etInt32) expected, (etInt32) actual);
}

void EXPECT_EQUAL_UINT8(const char* message, etUInt8 expected, etUInt8 actual) {
	expect_equal_uint(message, (etUInt32) expected, (etUInt32) actual);
}

void EXPECT_EQUAL_UINT16(const char* message, etUInt16 expected, etUInt16 actual) {
	expect_equal_uint(message, (etUInt32) expected, (etUInt32) actual);
}

void EXPECT_EQUAL_UINT32(const char* message, etUInt32 expected, etUInt32 actual) {
	expect_equal_uint(message, (etUInt32) expected, (etUInt32) actual);
}


void EXPECT_EQUAL_FLOAT32(const char* message, etFloat32 expected, etFloat32 actual, etFloat32 precision) {
	expect_equal_float(message, (etFloat64) expected, (etFloat64) actual, (etFloat64) precision);
}

void EXPECT_EQUAL_FLOAT64(const char* message, etFloat64 expected, etFloat64 actual, etFloat64 precision) {
	expect_equal_float(message, (etFloat64) expected, (etFloat64) actual, (etFloat64) precision);
}

/* order */
static etInt16 etUnit_orderCurrentIndex = 0;
static etInt16 etUnit_orderSize = 0;
static etInt16* etUnit_orderList = NULL;

void EXPECT_ORDER_START(etInt16* list, etInt16 size){
	etUnit_orderCurrentIndex = 0;
	etUnit_orderSize = size;
	etUnit_orderList = list;
}

void EXPECT_ORDER(const char* message, etInt16 identifier){
	if (etUnit_orderCurrentIndex < etUnit_orderSize) {
		if (etUnit_orderList[etUnit_orderCurrentIndex] != identifier){
			char testresult[ETUNIT_FAILURE_TEXT_LEN];
			sprintf(testresult, "EXPECT_ORDER %s: index=%d, expected=%d, actual=%d", message, etUnit_orderCurrentIndex, identifier, etUnit_orderList[etUnit_orderCurrentIndex]);
			etUnit_handleExpect(FALSE, testresult);
		}
		else {
			etUnit_handleExpect(TRUE, "");
			etUnit_orderCurrentIndex++;
		}
	}
	else {
		char testresult[ETUNIT_FAILURE_TEXT_LEN];
		sprintf(testresult, "EXPECT_ORDER: index(%d) is too big in %s", etUnit_orderCurrentIndex, message);
		etUnit_handleExpect(FALSE, testresult);
		etLogger_logInfoF("EXPECT_ORDER: index too big in %s", message);
	}
}

void EXPECT_ORDER_END(const char* message, etInt16 identifier){
	EXPECT_ORDER(message, identifier);
	if (etUnit_orderCurrentIndex != etUnit_orderSize){
		char testresult[ETUNIT_FAILURE_TEXT_LEN];
		sprintf(testresult, "EXPECT_ORDER_END %s: wrong index at the end: expected=%d, actual=%d", message, etUnit_orderSize, etUnit_orderCurrentIndex);
		etUnit_handleExpect(FALSE, testresult);
	}
}

/* private functions */

void expect_equal_int(const char* message, etInt32 expected, etInt32 actual) {
	if (expected != actual) {
		char testresult[ETUNIT_FAILURE_TEXT_LEN];
		sprintf(testresult, "%s: expected=%ld, actual=%ld", message, expected, actual);
		etUnit_handleExpect(FALSE, testresult);
	} else {
		etUnit_handleExpect(TRUE, "");
	}
}

void expect_equal_uint(const char* message, etUInt32 expected, etUInt32 actual) {
	if (expected != actual) {
		char testresult[ETUNIT_FAILURE_TEXT_LEN];
		sprintf(testresult, "%s: expected=%lu, actual=%lu", message, expected, actual);
		etUnit_handleExpect(FALSE, testresult);
	} else {
		etUnit_handleExpect(TRUE, "");
	}
}


void expect_equal_float(const char* message, etFloat64 expected, etFloat64 actual, etFloat64 precision) {
	if (expected - actual < -precision || expected - actual > precision) {
		char testresult[ETUNIT_FAILURE_TEXT_LEN];
		sprintf(testresult, "%s: expected=%lf, actual=%lf", message, expected, actual);
		etUnit_handleExpect(FALSE, testresult);
	} else {
		etUnit_handleExpect(TRUE, "");
	}
}

void expect_equal_void_ptr(const char* message, const void* expected, const void* actual) {
	if (expected != actual) {
		char testresult[ETUNIT_FAILURE_TEXT_LEN];
		sprintf(testresult, "%s: expected=%ld, actual=%ld", message, (etUInt32) expected, (etUInt32) actual);
		etUnit_handleExpect(FALSE, testresult);
	} else {
		etUnit_handleExpect(TRUE, "");
	}
}


//_________

void etUnit_handleExpect(etBool result, const char *resulttext){
	if (result == TRUE) {
		/* nothing to do because no failure */
	}
	else {
		if (etUnit_testcaseSuccess == TRUE){
			/* first failure will be remembered */
			etUnit_testcaseSuccess = FALSE;
			strcpy(etUnit_failureText, resulttext);
		}
		else{
			/* more than one error will be ignored */
		}
	}
}

void etUnit_buildTestLogXML(char* xml, const char *testcase, etBool result, const char *resulttext, clock_t time) {
	if (result == TRUE) {
		sprintf(xml, "\t\t<testcase name=\"%s\" time=\"%ld\"/>\n", testcase, time);
	} else {
		sprintf(
				xml,
				"\t\t<testcase name=\"%s\" classname=\"none\" time=\"%ld\">\n\t\t\t<failure>%s</failure>\n\t\t</testcase>\n",
				testcase, time, resulttext);
	}
}

void etUnit_writeTestLog(const char *testcase, etBool result, const char *resulttext) {
	char writeBuffer[ETUNIT_FAILURE_TEXT_LEN];

	// counting
	if (result == TRUE) {
		etUnit_passCount++;
		etUnit_passCountTotal++;
		etLogger_logInfoF("PASS: %s %s", testcase, resulttext);
	} else {
		etUnit_failCount++;
		etUnit_failCountTotal++;
		etLogger_logInfoF("FAIL: %s : %s", testcase, resulttext);
	}

	clock_t time = clock() - etUnit_currentTime;
	etUnit_currentTime = clock();

	// writing to file
	if (etUnit_reportfile != NULL) {
		etUnit_buildTestLogXML(writeBuffer, testcase, result, resulttext, time);
		etLogger_fprintf(etUnit_reportfile, writeBuffer);
	}
}

