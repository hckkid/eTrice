/*
 * SSRunner.c
 *
 *  Created on: 21.12.2011
 *      Author: tschuetz
 */

#include <stdio.h>
#include "../src-gen/cGenRef/DataClass1.h"
#include "RUnit.h"

void testDataClassDeepCopy(void);


int main(void){
	testDataClassDeepCopy();
	return 0;
}

void testDataClassDeepCopy(void){
	RUnit_open("testGeneratedDataClass");

	DataClass1 d, e;
	d.Attr1 = 123;
	d.ComplexAttr.Attr1 = 456;
	d.ComplexAttr.Attr2 = 789.123;
	d.ComplexAttr.Attr3 = 789;
	d.Attr3 = 321.123;

	DataClass1_deepCopy(&d,&e);

	EXPECT_EQUAL_INT("Attr1", 123, e.Attr1);
	EXPECT_EQUAL_INT("ComplexAttr.Attr1", 456, e.ComplexAttr.Attr1);
	EXPECT_EQUAL_FLOAT("ComplexAttr.Attr2", 789.123, e.ComplexAttr.Attr2);
	EXPECT_EQUAL_INT("ComplexAttr.Attr3", 789, e.ComplexAttr.Attr3);
	EXPECT_EQUAL_FLOAT("Attr3", 321.123, e.Attr3);

	EXPECT_EQUAL_INT("Operation DataClass1_MultiplyWithAttr1", 246, DataClass1_MultiplyWithAttr1(&d, 2));
	EXPECT_EQUAL_FLOAT("Operation DataClass1_MultiplyWithAttr3", 642.246, DataClass1_MultiplyWithAttr3(&d, 2));

	RUnit_close();
}


