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

#include <stdio.h>

#include "test/generator/RunCGeneratorTestcases.h"
#include "test/runtime/RunCRuntimeTestcases.h"

void runTestCases(void);

#include "test/experiments/test.h"
void runROMTest(void);

int main(void){
	runTestCases();
	return 0;
}


void runTestCases(void){
	RunCGeneratorTestcases();
	RunCRuntimeTestcases();
	runROMTest();
}

void runROMTest(void){

	if (Actor1.constData == &Actor1_const){
		printf("OK\n");
	}
	if (Actor1_const.actor == &Actor1){
		printf("OK\n");
	}
}

