#include "basic.h"

bool verify_if_n_is_prime(int n) {
  for (i = 2; i <= (n / 2); i++) {
    if (!(n % i)) {
      return false;
    }
  }
  return true;
}
void clear_it() {
  int c;
  do {
    c = getchar();
  } while (c != '\n' && c != EOF);
}

void print_column_names(int n){
  for (i = 0; i < n; i++)
    printf("  %d", i);
  printf("\n\n");
}
void print_add_table(int n){
  print_column_names(n);
  for (i = 0; i < n; i++) {
    printf("%d:", i);
    for (j = 0; j < n; j++) {
      r = i + j;
      if (r >= n)
        r -= n;
      printf("  %d", r);
    }
    printf("\n\n");
  }
}
void print_product_table(int n){
  print_column_names(n);
  for (i = 0; i < n; i++) {
    printf("%d:", i);
    for (j = 0; j < n; j++) {
      r = i * j;
      while (r >= n)
        r -= n;
      printf("  %d", r);
    }
    printf("\n\n");
  }
}
bool ask_for_natural_numbers(int *num, int *mum){
  printf("Please insert a natual number 1:\n");
  scanf("%u", num);
  printf("Please insert a natual number 2 (less than the first one):\n");
  scanf("%u", mum);
  if (*mum > *num) {
    printf("Can't you read?\n");
    return 1;
  }
  return 0;
}
