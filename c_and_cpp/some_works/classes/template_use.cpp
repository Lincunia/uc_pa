#include "class_header.hpp"

template <typename T> T add(T n1, T n2) { return n1 + n2; }

template <class T> class mycontainer {
  T element;

public:
  mycontainer(T arg) { element = arg; }
  T increase() { return ++element; }
};

// class template specialization:
template <> class mycontainer<char> {
  char element;

public:
  mycontainer(char arg) { element = arg; }
  char uppercase() {
    if ((element >= 'a') && (element <= 'z'))
      element += 'A' - 'a';
    return element;
  }
};

void class_test_four() {
  std::cout << "Esta es una prueba para usar los templates con int: "
            << add<int>(4, 5) << std::endl;
  std::cout << "Lo mismo pero con float: " << add<float>(4.123, 5.34);
}
void class_test_five() {
  mycontainer<int> myint(7);
  mycontainer<char> mychar('j');
  std::cout << "Contenido interno de myint: " << myint.increase() << std::endl;
  std::cout << "Contenido interno de mychar: " << mychar.uppercase()
            << std::endl;
}
