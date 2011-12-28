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


void RUnit_open(const char *testSuiteName) {
	RUnit_passCount = 0;
	RUnit_failCount = 0;
	printf("************* TEST START **************\n");

	if (RUnit_reportfile == NULL) {
		RUnit_reportfile = fopen("report.xml", "w+");
		if (RUnit_reportfile != NULL) {
			fprintf(
					RUnit_reportfile,
					"<testsuite name=\"%s\" tests=\"0\" failures=\"0\" errors=\"0\" time=\"0\">\n",
					testSuiteName);
		} else {
			printf("Unable to open file!");
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
		fprintf(RUnit_reportfile, "</testsuite>\n");
		fclose(RUnit_reportfile);
		RUnit_reportfile = NULL;
	}

}

void EXPECT_TRUE(const char* testcase, boool condition) {
	if (condition == FALSE) {
		RUnit_writeTestLog(testcase, FALSE, "*** FAIL: EXPECT_TRUE == FALSE");
	} else {
		RUnit_writeTestLog(testcase, TRUE, "");
	}
}

void EXPECT_FALSE(const char* testcase, boool condition) {
	if (condition == TRUE) {
		RUnit_writeTestLog(testcase, FALSE, "*** FAIL: EXPECT_FALSE == TRUE");
	} else {
		RUnit_writeTestLog(testcase, FALSE, "");
	}
}

//_________

void RUnit_buildTestLogXML(char* xml, const char *testcase, boool result, const char *resulttext, clock_t time) {
	if (result == TRUE) {
		sprintf(xml, "\t<testcase name=\"%s\" classname=\"none\" time=\"0.0000\"/>\n", testcase);
	} else {
		sprintf(xml, "\t<testcase name=\"%s\" classname=\"none\" time=\"0.0000\">\n\t\t<failure message=\"%s\" type=\"\"/>\n\t</testcase>\n", testcase, resulttext);
	}
}

void RUnit_writeTestLog(const char *testcase, boool result, const char *resulttext) {
	char writeBuffer[256]; // TODO TS: write secure buffers for string handling ...


	// counting
	if (result == TRUE) {
		RUnit_passCount++;
		printf("PASS: %s: %s\n", testcase, resulttext);
	}
	else {
		RUnit_failCount++;
		printf("FAIL: %s: %s\n", testcase, resulttext);
	}

	clock_t time = clock()-RUnit_currentTime;
	RUnit_currentTime = clock();

	// writing to file
	if (RUnit_reportfile != NULL) {
		RUnit_buildTestLogXML(writeBuffer, testcase, result, resulttext, time);
		fprintf(RUnit_reportfile, writeBuffer);
	}
}

