#include "class_header.hpp"

int main(int argc, char *argv[]) {
  char opt;
  int i, n;
  if (argc == 2) {
    opt = argv[1][0];
    goto mabel;
  }
  do {
    std::cout
        << "\n\tMENÚ\n"
        << "\na. Salir"
        << "\nb. Prueba de punteros con clases"
        << "\nc. Intento de operadores"
        << "\nd. Uso del this"
        << "\ne. Uso del template (al menos para mí esa fue mi primera vez)"
        << "\nf. Empleo de los template specialization"
        << "\ng. Prueba de destructor"
        << "\nh. Aplación de la copia en la asignación"
        << "\ni. Prueba con los miembros especiales"
        << "\n\nInserte las opciones dadas\n";
    std::cin >> opt;
    std::cin.ignore();
  mabel:
    opt = tolower(opt);
    system("clear || cls");
    switch (opt) {
    case 'a':
      std::cout << "Gracias por usar el programa" << std::endl;
      break;
    case 'b':
      class_test_one(n, i);
      break;
    case 'c':
      class_test_two();
      break;
    case 'd':
      class_test_three();
      break;
    case 'e':
      class_test_four();
      break;
    case 'f':
      class_test_five();
      break;
    case 'g':
      class_test_six();
      break;
    case 'h':
      class_test_seven();
      break;
    case 'i':
      class_test_eight();
      break;
    default:
      std::cout << "Lo que insertó, no corresponde a lo que colocó en el programa";
      break;
    }
    std::cout << "\n=======================================\n";
  } while (opt != 'a');
  return 0;
}
