#include "class_header.hpp"

class MyClassOperator {
public:
  int x, y;
  MyClassOperator() {}
  MyClassOperator(int a, int b) : x(a), y(b) {}
  int operator*(int &);
  MyClassOperator operator+(MyClassOperator &);
};

int MyClassOperator::operator*(int &param) { return x * param; }
MyClassOperator MyClassOperator::operator+(MyClassOperator &param) {
  MyClassOperator auxiliar_class;
  auxiliar_class.x = x + param.x;
  auxiliar_class.y = y + param.y;
  return auxiliar_class;
}

void class_test_two() {
  MyClassOperator foo(3, 4);
  MyClassOperator bar(1, 5);
  int num = 34;
  MyClassOperator result = foo + bar;
  std::cout << "Segmentación de x: " << result.x
            << "\nSegmentación de y: " << result.y
            << "\nCosas de x: " << foo * num;
}
void class_test_three() {
  test a;
  test *b = &a;
  a.set_txt("Este es el texto de la clase a\n");
  if (b->is_it_me(a)) {
    std::cout << b->get_txt();
  }
}
