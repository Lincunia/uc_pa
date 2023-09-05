#include "basic.hpp"

int main(void) {
  char opt;
  int clients = 0, sales = 0;
  do
  {
    cout << "\nNumero de ventas: " << sales
      << "\nNumero de clientes: " << clients
      << "\n\n=============================\n\tMENU"
      << "\n=============================\n"
      << "\na. Salir"
      << "\nb. Trabajar con otro cliente\n"
      << "\nInserte la opcion: ";
    opt = getchar();
    system("clear || cls");
    clear_it();
    switch (opt)
    { case 'a':
      cout << "Gracias por usar el programa *U*";
      break;

      case 'b':
      clients++;
      client_time(clients, &sales);
      break;

      default:
      cout << "Por favor, no inserte una opcion externa a lo que necesita";
      break;
    } cout << "\n";
  } while (opt != 'a');
  cout << "Presione enter para continuar ...";
  char enter = 0;
  while (getchar() != '\n');
  return 0;
}

void client_time(int client, int *sales) {
	int code, amount;
	while(true){
		cout << "Hola cliente numero " << client << ", inserte el codigo del producto: ";
		cin >> code;
		if(check_it(code)) break;
	}
	
	cout << code;
  *sales += 2;
}
