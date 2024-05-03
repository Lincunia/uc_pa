#include "basic.h"

void print_shoppings() {
  shopping *node = shoppings;
  while (node != NULL) {
    node->get_values();
    node = node->next;
  }
  delete[] node;
}
void push_shopping_list(product obj, unsigned int amount) {
  shopping *new_node = new shopping();
  new_node->set_values(obj.get_id(), obj.get_product_name(),
                       obj.get_product_weight(), obj.get_weight(),
                       obj.get_price());
  new_node->set_amount(amount);
  new_node->next = shoppings;
  shoppings = new_node;
}
bool print_piece(int subtotal, char opt) {
  float tax = subtotal * 0.12;
  system("clear || cls");
  cout << "\n\tUCENTRAL SUPERMARKET\n"
       << "\tCarrera 5 n.ª21-38\n\n"
       << "====================CHECK====================\n"
       << "\nSubtotal:\t\t$" << subtotal << "\nTax:\t\t$" << tax
       << "\n-------------------------------------------"
       << "\n ID | Description | Weight | Price | Amount"
       << "\n-------------------------------------------\n";
  print_shoppings();
  cout << "\nAmount to pay:\t\t$" << subtotal + tax
       << "\n\n=========================================\n\n";
  return ask_yes_or_not("Do you want to insert another product?", opt);
}
void client_time(int clients, int *sales, char opt) {
  unsigned short int code;
  unsigned int subtotal = 0, amount;
  cout << "¡Good morning client number " << clients << "!\n";
over_again:
  code = 0;
  print_products();
  cout << "Please insert the code of the product:\n";
  cin >> code;
  if (code > 10 || code < 1) {
    system("clear || cls");
    cout << "Sorry, that product does not belongs to our cathalog\n"
            "Do you want to buy something else?\n";
    goto over_again;
  }
  product obj = get_product(code);
  cout << "Insert the amount of the product:\n";
  cin >> amount;
  clear_it();
  push_shopping_list(obj, amount);
  subtotal += obj.get_price() * amount;
  cout << "Thanks for buying, this is the total price to pay: " << subtotal
       << "\n\n";
  *sales += 1;
  if (!ask_yes_or_not("Do you want to continue?", opt)) {
    goto over_again;
  }
  if (print_piece(subtotal, opt)) {
    system("clear || cls");
    goto over_again;
  }
  remove_conent(false);
}
