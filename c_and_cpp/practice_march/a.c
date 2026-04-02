#include <stdio.h>

int main(void)
{
  int a, b, c;
  printf("Inserte unos números con tres letras:\n");
  scanf("%d %d %d", &a, &b, &c);
  if (a<0) printf("%d\n", a*b*c);
  else printf("%d\n", a+b+c);
  return 0;
}
