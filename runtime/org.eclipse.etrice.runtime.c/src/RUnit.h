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

#ifndef _RUNIT_H_
#define _RUNIT_H_

#include "datatypes.h"
#include <stdio.h>
#include <time.h>


// open / close
void RUnit_open(char* testResultPath, char* testFileName);
void RUnit_close(void);
void RUnit_openTestSuite(char* testSuiteName);
void RUnit_closeTestSuite(void);
void RUnit_openTestCase(char* testCaseName);
void RUnit_closeTestCase(void);

/* boolean values */
void EXPECT_TRUE(const char* testcase, etBool condition);
void EXPECT_FALSE(const char* testcase, etBool condition);

/* signed integer values */
void EXPECT_EQUAL_INT8(const char* testcase, etInt8 expected, etInt8 actual);
void EXPECT_EQUAL_INT16(const char* testcase, etInt16 expected, etInt16 actual);
void EXPECT_EQUAL_INT32(const char* testcase, etInt32 expected, etInt32 actual);

/* unsigned integer values */
void EXPECT_EQUAL_UINT8(const char* testcase, etUInt8 expected, etUInt8 actual);
void EXPECT_EQUAL_UINT16(const char* testcase, etUInt16 expected, etUInt16 actual);
void EXPECT_EQUAL_UINT32(const char* testcase, etUInt32 expected, etUInt32 actual);

/* float values */
void EXPECT_EQUAL_FLOAT32(const char* testcase, etFloat32 expected, etFloat32 actual, etFloat32 precision);
void EXPECT_EQUAL_FLOAT64(const char* testcase, etFloat64 expected, etFloat64 actual, etFloat64 precision);

/* Pointers */
#define EXPECT_EQUAL_PTR(testcase, expected, actual) \
	expect_equal_void_ptr(testcase, (const void*) expected, (const void*) actual);

void expect_equal_void_ptr(const char* testcase, const void* expected, const void* actual);

/* Helpers for adding testcases */

#define ADD_TESTCASE(testcase) \
	RUnit_openTestCase(#testcase); \
	testcase(); \
	RUnit_closeTestCase();


#endif /* _RUNIT_H_ */
