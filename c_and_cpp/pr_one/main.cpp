#include "basic.h"
#include "other_functions.cpp"

int main(void) {
  char opt;
  int clients = 0, sales = 0;
  do
  {
    cout << "\nNúmero de ventas: " << sales
      << "\nNúmero de clientes: " << clients
      << "\n\n=============================\n\tMENÚ"
      << "\n=============================\n"
      << "\na. Salir"
      << "\nb. Trabajar con otro cliente\n"
      << "\nInserte la opción: ";
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
      cout << "Por favor, no inserte una opción externa a lo que necesita";
      break;
    } cout << "\n";
  } while (opt != 'a');
  cout << "Presione enter para continuar ...";
  char enter = 0;
  while (getchar() != '\n');
  return 0;
}

void client_time(int i, int *sales) {
  string code;
  string *other_matrix = new string();

  char c_opt, *ft;
  int subtotal = 0, it, amount;
  cout << "¡Muy buenos días clinete número " << i << "!\n";
again:
  do {
    bool chk = false;
    cout << "\nPor favor inserte el código del producto:\n";
    getline(cin, code);
    chk = check_matrix(&it, code, chk);
    if (!chk) {
      system("clear || cls");
      cout << "Lo sentimos, ese producto no se encuentra\n\n¿Quiere meter otro producto?\n";
      continue;
    }
    cout << "\nInserte ahora, la cantidad de este:\n";
    cin >> amount;
    clear_it();
    subtotal += (strtol(productos[it][4].c_str(), &ft, 10) * amount);
    insert_aux_list(productos[it], amount);
    cout << "Gracias por su compra, este es el monto total a pagar: $" << subtotal << "\n\n";
    c_opt=ask_things("¿Desea continuar?");
    *sales += 1;
  } while (c_opt != 'N');
  if(print_piece(subtotal)=='Y') {
    goto again;
  }
}

char print_piece(int subtotal) {
  system("clear || cls");
  char opt;
  float imp = subtotal * 0.12;
  cout << "\n\tEMPRESA: MERCADO DE U CENTRAL\n"
    << "\tCarrera 5 n.ª21-38\n\n"
    << "====================COMPRAS TOTALES====================\n"
    << "\nSubtotal:\t\t$"
    << subtotal
    << "\nImpuesto:\t\t$"
    << imp
    << "\n-------------------------------------------------------"
    << "\n Descripción | Cantidad de unidades | Precio | Cantidad"
    << "\n-------------------------------------------------------\n";
  for(array<string, 5> som: arr) {
    cout << som[0] << "\t";
    if(som[0].length()<8) cout << "\t";
    cout << som[1] << som[2] << "\t\t$" << som[3] << "\t\t" << som[4] << endl;
  }
  cout << "\nTotal a pagar:\t\t$"
    << subtotal + imp
    << "\n\n=======================================================\n\n";
  opt=ask_things("¿Quiere adquirir más productos?");
  system("clear || cls");
  return opt;
}

