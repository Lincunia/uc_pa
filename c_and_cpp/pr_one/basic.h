#ifndef BEGGING_FOR_MORE
#define BEGGING_FOR_MORE
#include <fstream>
#include <iostream>
using namespace std;

class product {
private:
  unsigned short int id, weight, price;
  string product_name, product_weight;

public:
  void set_values(unsigned short int i, string pr_na, string pr_we,
                  unsigned short int w, unsigned short int p) {
    id = i;
    weight = w;
    price = p;
    product_name = pr_na;
    product_weight = pr_we;
  }
  // Getters (just for the rest of the program)
  unsigned short int get_id() { return id; };
  unsigned short int get_weight() { return weight; }
  unsigned short int get_price() { return price; }
  string get_product_name() { return product_name; }
  string get_product_weight() { return product_weight; }
  product *next;
};

class shopping : public product {
private:
  unsigned int amount;

public:
  void set_amount(unsigned int a) { amount = a; }
  void get_values() {
    cout << get_id() << "\t" << get_product_name();
    if (get_product_name().length() <= 8) {
      cout << "\t";
    }
    cout << "\t" << get_weight() << get_product_weight() << "\t" << "$"
         << get_price() << "\t" << amount << "\n";
  }
  shopping *next;
};

static product *product_opts = NULL;
static shopping *shoppings = NULL;

// basic_functions.cpp
void clear_it();
void pause();
bool ask_yes_or_not(string, char);
void remove_conent(bool);
// shopping_functions.cpp
void print_shoppings();
void push_shopping_list(product, unsigned int);
bool print_piece(int, char);
void client_time(int, int *, char);
// product_functions.cpp
product get_product(unsigned short int);
void push_products_list(string *);
void import_lines_to_list();
void  print_products();
#endif // !BEGGING_FOR_MORE
