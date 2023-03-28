#include <stdio.h>
#include "header.h"

unsigned long long int distance_by_min()
{
    int m;
    printf("Insert the amount of minutes you need to convert: ");
    scanf("%d", &m);
    return SPEED * 60 * m;
}