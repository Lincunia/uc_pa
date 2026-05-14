#include <stdio.h>
#include <stdlib.h>

void percentage(int, int);

int main(void)
{
  int a, b, c;
  printf("Inserte el número de estudiantes: \n");
  scanf("%d", &a);
  printf("Inserte el número de varones: \n");
  scanf("%d", &b);
  printf("Inserte el número de muchachas: \n");
  scanf("%d", &c);
  if(a<(b+c)) exit(EXIT_FAILURE);
  percentage(a, b);
  percentage(a, c);
  return EXIT_SUCCESS;
}

void percentage(int a, int b){
  float d=b*100;
  d/=a;
  printf("Porcentaje de niños: %f\n", d);
}
