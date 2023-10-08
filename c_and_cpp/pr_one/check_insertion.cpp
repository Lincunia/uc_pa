#include "basic.h"

void get_product(unsigned short int id) {
  product *node = product_opts;
  while (node != NULL) {
    cout << node->get_product_name() << "\t" << node->get_id();
    node = node->next;
  }
  delete[] node;
  cout << "\n";
}
void print_shoppings() {
  shopping *node = shoppings;
  while (node != NULL) {
    node->get_values();
    node = node->next;
  }
  delete[] node;
  cout << "\n";
}
void push_shopping_list(product obj, unsigned int amount) {
  shopping *new_node = new shopping();
  new_node->set_values(obj.get_id(), obj.get_product_name(),
                       obj.get_product_weight(), obj.get_weight(),
                       obj.get_price());
  new_node->set_amount(amount);
  /*
  new_node->next = shoppings;
  shoppings = new_node;
  */
}
