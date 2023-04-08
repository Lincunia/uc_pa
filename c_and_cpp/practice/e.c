#include <stdio.h>

int main(void)
{
  unsigned short int y;
  printf("Inserte un año cualesqueira\n");
  scanf("%hu", &y);
  if(!(y%4) && (y%100)) printf("El año que diste es biciesto\n");
  else if(!(y%400)) printf("El año que diste es biciesto\n"); // A CRAP, I KNOW
  else printf("El año que diste no es biciesto\n");
  return 0;
}
