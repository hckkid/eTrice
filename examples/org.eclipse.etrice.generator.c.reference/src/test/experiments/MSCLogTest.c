
#include "etLogger.h"
#include "etMSCLogger.h"

void Class2_ff(void) {
	ET_MSC_LOGGER_SYNC_ENTRY("Class2", "ff")

	ET_MSC_LOGGER_SYNC_EXIT()
}

void CLass1_f(void) {
	ET_MSC_LOGGER_SYNC_ENTRY("Class1", "f")
	Class2_ff();
	ET_MSC_LOGGER_SYNC_EXIT()
}

//int main(void) {
//
//	etLogger_logInfo("***   T H E   B E G I N   ***");
//
//	ET_MSC_LOGGER_OPEN("main");
//	CLass1_f();
//	ET_MSC_LOGGER_CLOSE
//
//	etLogger_logInfo("***   T H E   E N D   ***");
//
//	return 0;
//}
