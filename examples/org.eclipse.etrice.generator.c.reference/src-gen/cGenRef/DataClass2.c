#include "DataClass2.h"

#include <string.h>


// TODO: do we need setters and getters for C and C++ ?

//--------------------- operations
void DataClass2_Operation1(DataClass2* self) {
	/*nothing to do*/
}

// deep copy
void DataClass2_deepCopy(DataClass2* source, DataClass2* target) {
	memcpy(target, source, sizeof(DataClass2));
}


