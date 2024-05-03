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
void option_b() {
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
  r = 1;
  printf("Please insert a natual number 1:\n");
  scanf("%u", &num);
  printf("Please insert a natual number 2 (less than the first one):\n");
  scanf("%u", &mum);
  if (mum > num) {
    printf("You don't fool me\n");
    return;
  }
  while (r) {
    r = num % mum;
    printf("%d/%d => %d (%d) + %d\n", num, mum, mum, num / mum, r);
    num = mum;
    mum = r;
  }
}
