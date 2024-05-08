#include <stdio.h>

static int i, j, n, r;

void print_column_names(int);
void print_add_table(int);
void print_product_table(int);

int main(void) {
  int i_0;
  printf("Por favor los valores (perteneciente a los números enteros) que "
         "corresponden:\n\n"
         "Inserte el tamaño:\n");
  scanf("%d", &n);
  printf("Inserte el valor inicial:\n");
  scanf("%d", &i_0);
  if (i_0 >= n) {
    printf("Valor no válido, ejecute el programa una vez más\n");
    return 1;
  }

  print_column_names(i_0);
  print_add_table(i_0);

  print_column_names(i_0);
  print_product_table(i_0);
  return 0;
}

void print_column_names(int i_0){
  for (i = i_0; i < n; i++)
    printf("\t%d", i);
  printf("\n\n");
}
void print_add_table(int i_0){
  for (i = i_0; i < n; i++) {
    printf("%d:", i);
    for (j = i_0; j < n; j++) {
      r = i + j;
      if (r >= n)
        r -= n;
      printf("\t%d", r);
    }
    printf("\n\n");
  }
}
void print_product_table(int i_0){
  for (i = i_0; i < n; i++) {
    printf("%d:", i);
    for (j = i_0; j < n; j++) {
      r = i * j;
      while (r >= n)
        r -= n;
      printf("\t%d", r);
    }
    printf("\n\n");
  }
}
