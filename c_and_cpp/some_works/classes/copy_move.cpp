#include "class_header.hpp"

class Example {
  std::string *ptr;

public:
  Example(const std::string &str) : ptr(new std::string(str)){};
  Example(){};
  Example operator=(Example &);
  std::string content() { return *ptr; }
};

Example Example::operator=(Example &ex) {
  delete ptr;
  ptr = new std::string(ex.content());
  return *this;
}

class Example2 {
public:
  Example2(const std::string &str) : ptr(new std::string(str)){};

  Example2(Example2 &&ex) : ptr(ex.ptr) { ex.ptr = nullptr; }
  Example2 &operator=(Example2 &&ex) {
    delete ptr;
    ptr = ex.ptr;
    ex.ptr = nullptr;
    return *this;
  }

  Example2 operator+(const Example2 &a) {
    return Example2(content() + a.content());
  };

  std::string content() const { return *ptr; }
  std::string *ptr;
};

void class_test_six() {
  DestructorTest foo("Arre mula, esta es la prueba a la que nadie le importó");
  std::cout << foo.content() << std::endl;
  // El timepo de vida de foo acabó
}
void class_test_seven() {
  Example foo(
      "If you were a woman and I was a man\n"); // No pregunten, me encontré con
                                                // esto en la playlist XD
  Example baz;
  baz = foo; // copy signment
  std::cout << baz.content();
}
void class_test_eight() {
  Example2 foo("Exam");
  Example2 bar = Example2("ple\n");
  foo = foo + bar;
  std::cout << foo.content();
}
