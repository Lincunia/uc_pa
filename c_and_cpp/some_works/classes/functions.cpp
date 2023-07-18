#include "class_header.hpp"

void class_test_one(int n, int i) {
  std::string str;

  std::cout << "Inserte lo que consideren:" << std::endl;
  std::cin >> n;
  std::cin.ignore();
  test *arre = new test[n];

  for (i = 0; i < n; i++) {
    std::cout << "Inserte un texto en " << i << " por favor:" << std::endl;
    std::getline(std::cin, str);
    (arre + i)->set_txt(str);
  }
  for (i = 0; i < n; i++) {
    std::cout << "\nTexto de [" << i << "]: " << arre[i].get_txt();
  }
  delete[] arre;
}
