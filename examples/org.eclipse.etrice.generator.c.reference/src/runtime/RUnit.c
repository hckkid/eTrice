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

#include "RUnit.h"
#include <string.h>

/*** member variables */

/* file handling */
static FILE* RUnit_reportfile = NULL;

/* names */
static char* RUnit_TestFileName = NULL;
static char* RUnit_TestResultPath = NULL;

static char* RUnit_TestSuiteName = NULL;
static char* RUnit_TestCaseName = NULL;

/* counters */
static etInt32 RUnit_passCount = 0;
static etInt32 RUnit_failCount = 0;

static boool etUnit_testcaseSuccess = TRUE;

#define ETUNIT_FAILURE_TEXT_LEN 256

static char etUnit_failureText[ETUNIT_FAILURE_TEXT_LEN];

/* time measuring */
static clock_t RUnit_startTime = 0;
static clock_t RUnit_currentTime = 0;

/*  */

/* forward declarations of private functions */
void expect_equal_int(const char* message, etInt32 expected, etInt32 actual);
void expect_equal_uint(const char* message, etUInt32 expected, etUInt32 actual);
void expect_equal_float(const char* message, float64 expected, float64 actual, float64 precision);
void RUnit_writeTestLog(const char *testcase, boool result, const char *resulttext);
void etUnit_handleExpect(boool result, const char *resulttext);

/* public functions */

void RUnit_open(char* testResultPath, char* testFileName) {
	RUnit_passCount = 0;
	RUnit_failCount = 0;
	strcpy(etUnit_failureText,"");

	RUnit_TestFileName = testFileName;
	RUnit_TestResultPath = testResultPath;

	printf("************* TEST START (%s) **************\n", RUnit_TestFileName);

	char filename[ETUNIT_FAILURE_TEXT_LEN];
	sprintf(filename, "%s/%s.xml", RUnit_TestResultPath, RUnit_TestFileName);

	if (RUnit_reportfile == NULL) {
		RUnit_reportfile = fopen(filename, "w+");
		if (RUnit_reportfile != NULL) {
			fprintf(RUnit_reportfile, "<testsuites name=\"%s\" tests=\"0\" failures=\"0\" errors=\"0\" time=\"0\">\n",
					RUnit_TestFileName);
		} else {
			printf("Unable to open file %s/%s.xml\n", RUnit_TestResultPath, RUnit_TestFileName);
		}
	}
	// prepare time measurement
	RUnit_startTime = clock();
	RUnit_currentTime = clock();
	printf("Start Time: %ld\n", RUnit_startTime);

}

void RUnit_close(void) {
	printf("\n");
	if (RUnit_failCount > 0) {
		printf("************* TEST FAILED *************\n");
	} else {
		printf("************* TEST PASSED *************\n");
	}
	printf("Number of Tests: %ld\n", RUnit_failCount + RUnit_passCount);
	printf("Failed: %ld\n", RUnit_failCount);
	printf("Passed: %ld\n", RUnit_passCount);
	printf("Total Time: %ld\n", clock() - RUnit_startTime);
	printf("End Time: %ld, CLOCKS_PER_SEC: %ld\n", clock(), CLOCKS_PER_SEC);
	printf("***************************************\n");

	if (RUnit_reportfile != NULL) {
		fprintf(RUnit_reportfile, "</testsuites>\n");
		fclose(RUnit_reportfile);
		RUnit_reportfile = NULL;
	}
}

void RUnit_openTestSuite(char* testSuiteName) {
	RUnit_TestSuiteName = testSuiteName;
	if (RUnit_reportfile != NULL) {
		fprintf(RUnit_reportfile, "\t<testsuite name=\"%s\" tests=\"0\" failures=\"0\" errors=\"0\" time=\"0\">\n",
				RUnit_TestSuiteName);
	}
}

void RUnit_closeTestSuite(void) {
	if (RUnit_reportfile != NULL) {
		fprintf(RUnit_reportfile, "\t</testsuite>\n");
	}
}

void RUnit_openTestCase(char* testCaseName) {
	RUnit_TestCaseName = testCaseName;
	etUnit_testcaseSuccess = TRUE;
	strcpy(etUnit_failureText,"");
}

void RUnit_closeTestCase(void) {
	if (RUnit_reportfile != NULL && RUnit_TestSuiteName != NULL) {
		RUnit_writeTestLog(RUnit_TestCaseName, etUnit_testcaseSuccess, etUnit_failureText);
	}
}

void EXPECT_TRUE(const char* message, boool condition) {
	if (condition == FALSE) {
		char testresult[ETUNIT_FAILURE_TEXT_LEN];
		sprintf(testresult, "%s: *** EXPECT_TRUE == FALSE", message);
		etUnit_handleExpect(FALSE, testresult);
	} else {
		etUnit_handleExpect(TRUE, "");
	}
}

void EXPECT_FALSE(const char* message, boool condition) {
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


void EXPECT_EQUAL_FLOAT32(const char* message, float32 expected, float32 actual, float32 precision) {
	expect_equal_float(message, (float64) expected, (float64) actual, (float64) precision);
}

void EXPECT_EQUAL_FLOAT64(const char* message, float64 expected, float64 actual, float64 precision) {
	expect_equal_float(message, (float64) expected, (float64) actual, (float64) precision);
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


void expect_equal_float(const char* message, float64 expected, float64 actual, float64 precision) {
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

void etUnit_handleExpect(boool result, const char *resulttext){
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

void RUnit_buildTestLogXML(char* xml, const char *testcase, boool result, const char *resulttext, clock_t time) {
	if (result == TRUE) {
		sprintf(xml, "\t\t<testcase name=\"%s\" time=\"%ld\"/>\n", testcase, time);
	} else {
		sprintf(
				xml,
				"\t\t<testcase name=\"%s\" classname=\"none\" time=\"%ld\">\n\t\t<failure>%s</failure>\n\t</testcase>\n",
				testcase, time, resulttext);
	}
}

void RUnit_writeTestLog(const char *testcase, boool result, const char *resulttext) {
	char writeBuffer[ETUNIT_FAILURE_TEXT_LEN];

	// counting
	if (result == TRUE) {
		RUnit_passCount++;
		printf("PASS: %s: %s\n", testcase, resulttext);
	} else {
		RUnit_failCount++;
		printf("FAIL: %s: %s\n", testcase, resulttext);
	}

	clock_t time = clock() - RUnit_currentTime;
	RUnit_currentTime = clock();

	// writing to file
	if (RUnit_reportfile != NULL) {
		RUnit_buildTestLogXML(writeBuffer, testcase, result, resulttext, time);
		fprintf(RUnit_reportfile, writeBuffer);
	}
}

