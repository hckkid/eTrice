/*******************************************************************************
 * Copyright (c) 2012 protos software gmbh (http://www.protos.de).
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * CONTRIBUTORS:
 * 		Thomas Schuetz (initial contribution)
 *
 *******************************************************************************/

#include "msp430f5438a.h"
#include "hal_MSP-EXP430F5438.h"
#include "platform/etTimer.h"


/* forward declarations */
static void prvSetupHardware(void);
void initIO(void);


/* implemenatation for eTrice interfaces*/

void etUserEntry(void){
	prvSetupHardware();
	etTimer_init();
}

void etUserPreRun(void){
	_enable_interrupt();
}

void etUserPostRun(void){ }
void etUserExit(void){ }


/* platform specific functions */

static void prvSetupHardware(void) {
	/* Convert a Hz value to a KHz value, as required by the Init_FLL_Settle()
	 function. */
	unsigned long ulCPU_Clock_KHz = (25000000UL / 1000UL );

	/* Disable the watchdog. */
	WDTCTL = WDTPW + 0x36;

	halBoardInit();

	LFXT_Start(XT1DRIVE_0);
	Init_FLL_Settle((unsigned short) ulCPU_Clock_KHz, 488);

	halButtonsInit(BUTTON_ALL);
	halButtonsInterruptEnable(BUTTON_SELECT);

	/* Initialise the LCD, but note that the backlight is not used as the
	 library function uses timer A0 to modulate the backlight, and this file
	 defines	vApplicationSetupTimerInterrupt() to also use timer A0 to generate
	 the tick interrupt.  If the backlight is required, then change either the
	 halLCD library or vApplicationSetupTimerInterrupt() to use a different
	 timer.  Timer A1 is used for the run time stats time base6. */
	halLcdInit();
	halLcdSetContrast(105);
	halLcdClearScreen();
	halLcdBackLightInit();
	halLcdSetBackLight(10);

	halLcdPrintLine(" eTrice on MSP430", 1, OVERWRITE_TEXT);

	SFRIE1 |= WDTIE;

}

