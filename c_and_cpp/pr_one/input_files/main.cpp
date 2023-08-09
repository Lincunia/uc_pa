#include <fstream>
#include <iostream>
#include <string>

void write(int, char **);
void read();
void append();

int main(int argc, char *argv[]) {
  char opt;
  std::cout
      << "Hello, What do you want to do?\n"
      << "\na. Write a file with the arguments by the time the program was "
         "executed"
      << "\nb. Read \"lorem.txt\""
      << "\nc. Append information to any file\n"
      << "\nInsert the information you wish:\n";
  std::cin >> opt;
  std::cin.ignore();
  switch (opt) {
  case 'a':
    write(argc, argv);
    break;

  case 'b':
    read();
    break;

  case 'c':
    append();
    break;

  default:
    std::cout << "Option not recognized by the program\n";
    break;
  }
  return 0;
}

void write(int argc, char *argv[]) {
  std::ofstream a_file;
  a_file.open("write.txt", std::fstream::out);
  if (a_file.fail()) {
    std::cout << "The file \"write.txt\" wasn't able to create" << std::endl;
    return;
  }
  for (int i = 1; i < argc; i++) {
    a_file << argv[i] << std::endl;
  }
  a_file.close();
}
void read() {
  std::ifstream a_file;
  std::string line;
  a_file.open("lorem.txt", std::fstream::in);
  if (a_file.fail()) {
    std::cout
        << "The file \"lorem.txt\" wasn't able to open, something went wrong\n";
    return;
  }
  while (getline(a_file, line)) {
    std::cout << line << std::endl;
  }
  a_file.close();
}
void append() {
  std::fstream a_file;
  std::string name, line;
  bool verify = true;
  std::cout << "Insert the name of the file:\n";
  getline(std::cin, name);
  a_file.open(name.c_str(), std::fstream::app);
  if (a_file.fail()) {
    std::cout << "The file \"" << name
              << "\" wasn't able to open, something went wrong\n";
    return;
  }
  while (verify) {
    std::cout << "Inserte su linea:\n";
    getline(std::cin, line);
    a_file << line << std::endl;
    std::cout << "¿Seguir insertando?\n";
    std::cin >> verify;
    std::cin.ignore();
  }
}
