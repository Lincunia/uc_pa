#ifndef TEACHER_CRAP
#define TEACHER_CRAP
/*
 * LIBRARIES FOR THE WHOLE PROGRAM
 */
#include <stdio.h>
#include <stdlib.h>
/*
 * BASIC STRUCTURES
 */
 
typedef enum {false, true} bool; // Boolean in C (IDK why this language doesn't have this)
#define SPEED 344 // Constant off light in (m/s)

/*
 * FUNCTIONS
 */
void clear_it(void);
unsigned long long int distance_by_min();
void in_out_chars(void);

#endif
