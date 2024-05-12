#include "basic.h"

void option_b() {
  int num;
  printf("Please insert a natual number:\n");
  scanf("%u", &num);
  printf("%u ", num);
  if (verify_if_n_is_prime(num)) {
    printf("is a prime number\n");
  } else {
    printf("is a composite number\n");
  }
}
void option_c() {
  int a, b, c, num, mum;
  r = 1;
  if(ask_for_natural_numbers(&num, &mum)) return;
  a = num;
  b = mum;
  while (r) {
    r = num % mum;
    c = mum;
    printf("%d => %d (%d) + %d\n", num, mum, num / mum, r);
    num = mum;
    mum = r;
  }
  printf("MCD{%d, %d} = %d\n", a, b, c);
  if(c == 1){
    printf("Both numbers are coprimes\n");
  }
}
void option_d(){
  int n;
  printf("Insert the size of the boards:\n");
  scanf("%d", &n);
  print_add_table(n);
  printf("\n ======================================= \n");
  print_product_table(n);
}
/*
 * I have no idea how to do it
void option_e(){
  r = 1;
  if(ask_for_natural_numbers()) return;
  while (r) {
    r = num % mum;
    printf("%d/%d => %d (%d) + %d\n", num, mum, mum, num / mum, r);
    num = mum;
    mum = r;
  }
}
*/
