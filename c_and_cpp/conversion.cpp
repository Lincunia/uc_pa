#include <forward_list>
#include <iostream>

void conversion_number(int number, int base) {
  int aux;
  std::forward_list<int> output_numbers = {};
  std::cout << "\nNumber as it is: " << number << "\nNew number:";
  while (number != 0) {
    aux = number % base;
    output_numbers.push_front(aux);
    number /= base;
  }
  for (int &x : output_numbers)
    std::cout << ' ' << x;
  std::cout << "\n\n";
  output_numbers.clear();
}

int main() {
  std::string oct_string;
  int base;
  std::cout << "\nInsert your number: ";
  std::getline(std::cin, oct_string);
  std::cout << "Insert the base to convert: ";
  std::cin >> base;
  conversion_number(stoi(oct_string, 0, 10), base);
  return 0;
}
