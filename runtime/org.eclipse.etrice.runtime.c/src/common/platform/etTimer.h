
#include "etDatatypes.h"

typedef struct etTargetTime {
       unsigned long nSec;
       unsigned long sec;
} etTargetTime_t;


void etTimer_init(void);

uint32 getNSecFromTarget(void);
uint32 getSecFromTarget(void);


void getTimeFromTarget(etTargetTime_t *t);

int isTimeGreaterThanActualTime(const etTargetTime_t *t);

etBool etTimer_executeNeeded(void);

