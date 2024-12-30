#include <stdbool.h>
#include <stdio.h>
#include <stdlib.h>
#include <string.h>

static char *str;

int main(void) {
  char txt[8];
  bool chk = true;
  printf("Please insert the amount of floating numbers (9999999 as maximum)\n");
  str = fgets(txt, 8, stdin);
  if (str == NULL) {
    printf("Invalid input\n");
    return EXIT_FAILURE;
  }
  for (int i = 0; i < strlen(txt); i++) {
    if (txt[i] >= '0' && txt[i] <= '9') {
      chk = false;
      break;
    }
  }
  if (chk) {
    printf("It must be a number\n");
    return EXIT_FAILURE;
  }
  printf("This is what you inserted: %u\n", (unsigned)atoi(txt));
  return EXIT_SUCCESS;
}
