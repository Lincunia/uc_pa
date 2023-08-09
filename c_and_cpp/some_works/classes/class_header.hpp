#ifndef QUE_PICHA
#define QUE_PICHA
#include <cctype>
#include <cstdlib>
#include <iostream>
#include <string>

class test {
  std::string txt;

public:
  void set_txt(std::string t) { txt = t; }
  std::string get_txt() { return txt; }
  bool is_it_me(test &p) {
    if (&p == this)
      return true;
    return false;
  }
};

class DestructorTest {
  std::string *ptr;

public:
  DestructorTest(const std::string &txt) : ptr(new std::string(txt)) {}
  ~DestructorTest() {
    delete ptr;
    std::cout << "Tócate la de Darude: Sandstorm\n"; // No me lo estoy tgomando
                                                     // en serio ¿no?
  }
  const std::string content() { return *ptr; }
};

void class_test_one(int, int); // Prueba sencilla de clases
void class_test_two();         // Operator
void class_test_three();
void class_test_four();
void class_test_five();
void class_test_six();
void class_test_seven();
void class_test_eight();
#endif // !QUE_PICHA
