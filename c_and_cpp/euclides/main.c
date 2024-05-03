#include "basic.h"

int main(void) {
  char opt;
  do {
    printf("\n\tMENU\n"
           "a. Exit\n"
           "b. Know if a natural number is prime\n"
           "c. Euclides algorithm\n"
           "\nInsert the option:\n");
    scanf("%c", &opt);
    clear_it();
    system("clear || cls");
    switch (opt) {
    case 'a':
      printf("Thanks for using this program\n");
      break;

    case 'b':
      option_b();
      clear_it();
      break;

    case 'c':
      option_c();
      clear_it();
      break;

    default:
      printf("Wrong option\n");
      break;
    }
  } while (opt != 'a');

  return EXIT_SUCCESS;
}
