#include "basic.h"
#include <algorithm>

product get_product(unsigned short int id) {
  product *node = product_opts;
  product obj;
  while (node->get_id() != id) {
    node = node->next;
  }
  obj = *node;
  node = NULL;
  return obj;
}
void push_products_list(string *args) {
  unsigned short int id = stoi(args[0]), weight = stoi(args[3]),
                     price = stoi(args[4]);
  product *new_node = new product();
  new_node->set_values(id, args[1], args[2], weight, price);
  new_node->next = product_opts;
  product_opts = new_node;
}
void import_lines_to_list() {
  ifstream file;
  string line, args[5];
  file.open("products.csv", ifstream::in);
  if (file.fail()) {
    cout << "For any reason, the program couldn't be opened";
    return;
  }
  while (getline(file, line)) {
    int posInit = 0;
    int posFound = 0;
    string splitted;
    for (int i = 0; i < 5; i++) {
      posFound = line.find(";", posInit);
      splitted = line.substr(posInit, posFound - posInit);
      posInit = posFound + 1;
      args[i] = splitted;
    }
    push_products_list(args);
  }
  file.close();
}
void print_products() {
  product *node = product_opts;
  while (node != NULL) {
    cout << node->get_id() << "\t" << node->get_product_name();
    if (node->get_product_name().length() <= 8) {
      cout << "\t";
    }
    cout << "\t" << node->get_weight() << node->get_product_weight() << "\t"
         << "$" << node->get_price() << "\n";
    node = node->next;
  }
  delete[] node;
}
