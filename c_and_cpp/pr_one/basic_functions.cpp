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
bool check_product(unsigned short int code) {
  if (code > 10 || code < 1)
    return true;
  return false;
}
char ask_yes_or_not(string question, char opt) {
ask_again:
  cout << question << "('Y' for yes or 'N' for no):\n";
  opt = getchar();
  clear_it();
  opt = toupper(opt);
  if (opt != 'N' && opt != 'Y') {
    cout << "Remember you must type the option in the right way\n\n";
    goto ask_again;
  }
  return opt;
}
void client_time(int clients, int *sales, char opt) {
  unsigned short int code;
  unsigned int subtotal = 0, amount;
  bool chk = true;
  cout << "¡Good morning client number " << clients << "!\n";
over_again:
  code = 0;
  while (check_product(code)) {
    cout << "Please insert the code of the product:\n";
    cin >> code;
    if (!chk) {
      system("clear || cls");
      cout << "Sorry, that product does not belongs to our cathalog\nDo you "
              "want to buy something else?\n";
    }
  }
  cout << "Insert the amount of the product:\n";
  cin >> amount;
  get_product(code);
  clear_it();
  // subtotal += push_shopping_list(obj, amount);
  // subtotal += obj.get_price() * amount;
  subtotal += (amount * 12000);
  cout << "Thanks for buying, this is the total price to pay: " << subtotal
       << "\n\n";
  if (ask_yes_or_not("Do you want to continue?", opt) == 'N') {
    *sales += 1;
    goto over_again;
  }
  if (print_piece(subtotal, opt) == 'Y') {
    goto over_again;
  }
}
char print_piece(int subtotal, char opt) {
  float tax = subtotal * 0.12;
  cout << "\n\tUCENTRAL SUPERMARKET\n"
       << "\tCarrera 5 n.ª21-38\n\n"
       << "====================CHECK====================\n"
       << "\nSubtotal:\t\t$" << subtotal << "\nTax:\t\t$" << tax
       << "\n-------------------------------------------"
       << "\n ID | Description | Weight | Price | Amount"
       << "\n-------------------------------------------\n";
  //print_shoppings();
  cout << "\nAmount to pay:\t\t$" << subtotal + tax
       << "\n\n=========================================\n\n";
  system("clear || cls");
  return ask_yes_or_not("Do you want to insert another product?", opt);
}
