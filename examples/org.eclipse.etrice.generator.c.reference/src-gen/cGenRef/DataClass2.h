#ifndef _DataClass2_H_
#define _DataClass2_H_

#include "datatypes.h"

/* TODO: includes only for used DataClasses, also for other models */

		
typedef struct {
	//--------------------- attributes
	int32 Attr1;
	float32 Attr2;
	int32 Attr3;
} DataClass2;

// TODO: do we need setters and getters for C and C++ ?

//--------------------- operations
void DataClass2_Operation1 (DataClass2* self);

// deep copy
void DataClass2_deepCopy(DataClass2* source, DataClass2* target);

#endif /* _DataClass2_H_ */

