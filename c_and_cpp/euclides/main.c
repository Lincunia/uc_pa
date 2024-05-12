#include "basic.h"

/*
 * TODO: Recreate the Bézout's algorithm
 */

int main(void) {
  char opt;
  do {
    printf("\n\tMENU\n"
           "a. Exit\n"
           "b. Know if a natural number is prime\n"
           "c. Euclides algorithm\n"
           "d. n|b-a\n"
           //"e. Bézout's theorem\n"
           "\nInsert the option:\n");
    scanf("%c", &opt);
    system("clear || cls");
    switch (opt) {
    case 'a':
      printf("Thanks for using this program\n");
      break;

    case 'b':
      option_b();
      break;

    case 'c':
      option_c();
      break;

    case 'd':
      option_d();
      break;

    /*
    case 'e':
      option_e();
      break;
      */

    default:
      printf("Wrong option\n");
      break;
    }
    clear_it();
  } while (opt != 'a');

  return EXIT_SUCCESS;
}
