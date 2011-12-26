/*
 * RUnit.h
 *
 *  Created on: 26.12.2011
 *      Author: tschuetz
 */

#ifndef RUNIT_H_
#define RUNIT_H_

#include "datatypes.h"
#include <stdio.h>


//*** global variables
// file handling
static FILE* RUnit_reportfile = NULL;

// counters
static int32 RUnit_passCount = 0;
static int32 RUnit_failCount = 0;

// time measuring
static RUnit_startTime = 0;
static RUnit_currentTime = 0;


// forward declarations
void RUnit_open(const char *testSuiteName);
void RUnit_close(void);
void RUnit_writeTestLog(const char *testcase, boool result, const char *resulttext);


void EXPECT_TRUE(const char* testcase, boool condition);
void EXPECT_FALSE(const char* testcase, boool condition);

//void EXPECT_EQUAL(const char* testcase, int8 expected, int8 actual);
//void EXPECT_EQUAL(const char* testcase, int16 expected, int16 actual);
//void EXPECT_EQUAL(const char* testcase, int32 expected, int32 actual);
//void EXPECT_EQUAL(const char* testcase, uint8 expected, uint8 actual);
//void EXPECT_EQUAL(const char* testcase, uint16 expected, uint16 actual);
//void EXPECT_EQUAL(const char* testcase, uint32 expected, uint32 actual);


#define EXPECT_EQUAL_INT(testcase, expected, actual) \
	if (expected != actual) { \
		char testresult[256]; \
		sprintf(testresult, "expected=%ld, actual=%ld", expected, actual); \
		RUnit_writeTestLog(testcase, FALSE, testresult); \
	} \
	else { \
		RUnit_writeTestLog(testcase, TRUE, ""); \
	}

#define FLOAT_PRECISION 0.0001

#define EXPECT_EQUAL_FLOAT(testcase, expected, actual) \
	if (expected-actual < -FLOAT_PRECISION || expected-actual > FLOAT_PRECISION) { \
		char testresult[256]; \
		sprintf(testresult, "expected=%f, actual=%f", expected, actual); \
		RUnit_writeTestLog(testcase, FALSE, testresult); \
	} \
	else { \
		RUnit_writeTestLog(testcase, TRUE, ""); \
	}

#endif /* RUNIT_H_ */
