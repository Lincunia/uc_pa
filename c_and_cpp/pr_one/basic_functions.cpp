#include "basic.h"

void clear_it() {
  int c;
  do {
    c = getchar();
  } while (c != '\n' && c != EOF);
}
void pause() {
  cout << "Press enter to continue...";
  while (getchar() != '\n')
    ;
}
bool ask_yes_or_not(string question, char opt) {
ask_again:
  cout << question << "('Y' for yes or 'N' for no):\n";
  opt = getchar();
  clear_it();
  opt = toupper(opt);
  if (opt != 'N' && opt != 'Y') {
    cout << "Remember you must type the option in the right way\n\n";
    goto ask_again;
  }
  return ((opt == 'Y') ? true : false);
}
void remove_conent(bool i) {
  if (i) {
    while (product_opts != NULL) {
      delete product_opts;
      product_opts = product_opts->next;
    }
    return;
  }
  while (shoppings != NULL) {
    delete shoppings;
    shoppings = shoppings->next;
  }
}
