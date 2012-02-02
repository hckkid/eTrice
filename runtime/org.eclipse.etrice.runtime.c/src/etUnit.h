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

#ifndef _ETUNIT_H_
#define _ETUNIT_H_

#include "etDatatypes.h"


/* open / close */
void etUnit_open(char* testResultPath, char* testFileName);
void etUnit_close(void);
void etUnit_openTestSuite(char* testSuiteName);
void etUnit_closeTestSuite(void);
void etUnit_openTestCase(char* testCaseName);
void etUnit_closeTestCase(void);

/* functions for more convenience for model and generator tests */

void etUnit_openAll(char* testResultPath, char* testFileName, char* testSuiteName, char* testCaseName);
void etUnit_closeAll(void);

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

/* more specialized functions */
void EXPECT_ORDER_START(etInt16* list, etInt16 size);
void EXPECT_ORDER(const char* message, etInt16 identifier);
void EXPECT_ORDER_END(const char* message, etInt16 identifier);


/* Helpers for adding testcases */

#define ADD_TESTCASE(testcase) \
	etUnit_openTestCase(#testcase); \
	testcase(); \
	etUnit_closeTestCase();


#endif /* _ETUNIT_H_ */
