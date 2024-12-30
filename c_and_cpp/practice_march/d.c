#include <stdio.h>

int main(void)
{
  int n;
  printf("Inserte un número entero:\n");
  scanf("%d", &n);
  if (!n) {
    printf("El número no es par ni impar\n");
    return 0;
  }
  if (n%2) printf("El número es impar");
  else printf("El número es par");
  printf("\n");

  return 0;
}
