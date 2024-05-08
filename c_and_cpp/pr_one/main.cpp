#include "basic.h"

int main() {
  char opt, o;
  int clients = 0, sales = 0;
  import_lines_to_list();
  do {
    cout << "\nNumber of sales: " << sales
         << "\nNumber of clients: " << clients
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
      cout << "Thanks for using the program *U*";
      break;

    case 'b':
      clients++;
      client_time(clients, &sales, o);
      break;

    default:
      cout << "Please, insert one of the options proposed";
      break;
    }
    cout << "\n";
  } while (opt != 'a');
  remove_conent(true);
  return 0;
}
