#include <iostream>
using std::cout;
/*
 * This might have memory leask, which I must understand first and then.
 * I must fix the program
 */

void clear_it();

int main(void) {
  char opt;
  int clients = 0, sales = 0;
  do {
    cout << "\nNumber of sales: " << sales << "\nNumber of clients: " << clients
         << "\n\n=============================\n"
         << "\tMENU\n"
         << "=============================\n\n"
         << "a. Exit\n"
         << "b. Buy something\n"
         << "\nInsert the option:\n";
    opt = getchar();
    system("clear || cls");
    clear_it();
    switch (opt) {
    case 'a':
      cout << "Gracias por usar el programa *U*";
      break;

    case 'b':
      clients++;
      break;

    default:
      cout << "Please, insert one of the options proposed";
      break;
    }
    cout << "\n";
  } while (opt != 'a');
  cout << "Press enter to finish the program ...";
  char enter = 0;
  while (getchar() != '\n')
    ;
  return 0;
}

void clear_it() {
  int c;
  while ((c = getchar()) != '\n' && c != EOF)
    ;
}
