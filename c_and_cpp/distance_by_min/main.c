#include "header.h"

int main() {
  unsigned char opt;
  printf("Insert your option for this (1 for operate, 2 to display characters "
         "or any other number to end the program): ");
  scanf("%hhu", &opt);
  clear_it();
  switch (opt) {
  case 1:
    printf("This is the distance: %llu\n", distance_by_min());
    break;
  case 2:
    in_out_chars();
    break;
  default:
    printf("Goodbye you fool :)\n");
    break;
  }
  return EXIT_SUCCESS;
}
