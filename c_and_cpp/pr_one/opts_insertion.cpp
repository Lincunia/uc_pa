#include "basic.h"

void split_text(string line, string *args) {
  int posInit = 0, i = 0;
  int posFound = 0;
  string splitted;

  while (posFound >= 0) {
    posFound = line.find(";", posInit);
    splitted = line.substr(posInit, posFound - posInit);
    posInit = posFound + 1;
    args[i] = splitted;
    i++;
  }
}
void import_lines_to_list() {
  ifstream file;
  string line, args[5];
  file.open("products.csv", ifstream::in);
  if (file.fail())
    return;
  while (getline(file, line)) {
    split_text(line, args);
    push_products_list(args);
  }
  file.close();
}
void print_products_opts() {
  product *node = product_opts;
  while (node != NULL) {
    cout << node->get_product_name() << "\t" << node->get_id();
    node = node->next;
  }
  delete[] node;
  cout << "\n";
}
void push_products_list(string *args) {
  product *new_node = new product();
  new_node->set_values(stoi(args[0]), args[1], args[2], stoi(args[3]),
                       stoi(args[4]));
  new_node->next = product_opts;
  product_opts = new_node;
}

