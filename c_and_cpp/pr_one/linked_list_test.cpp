#include <fstream>
#include <iostream>
#include <string>
using namespace std;

class product {
public:
  void set_values(unsigned short int i, string pr_na, string pr_we,
                  unsigned short int w, unsigned short int p) {
    id = i;
    weight = w;
    price = p;
    product_name = pr_na;
    product_weight = pr_we;
  }
private:
  unsigned short int id, weight, price;
  string product_name, product_weight;
};

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

int main() {
  product obj;
  ifstream file;
  string line, args[5];
  file.open("products.csv", ifstream::in);
  if (file.fail())
    return 0;
  getline(file, line);
  split_text(line, args);
  obj.set_values(stoi(args[0]), args[1], args[2], stoi(args[3]), stoi(args[4]));
  file.close();
  return 0;
}
