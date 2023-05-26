#include "basic.h"

int main(void)
{
  char opt;
  int clients=0, sales=0;
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
    {
      case 'a':
        cout << "Gracias por usar el programa *U*";
        break;

      case 'b':
        clients++;
        client_time(clients, &sales);
        break;

      default:
        cout << "Por favor, no inserte una opción externa a lo que necesita";
        break;
    }
    cout << "\n";
  } while (opt != 'a');
  pause();
  return 0;
}

void clear_it()
{
  int c;
  while ((c = getchar()) != '\n' && c != EOF);
}
void pause()
{
  cout << "Presione enter para continuar ...";
  char enter = 0;
  while( getchar() != '\n' );
}
bool check_matrix(int *it, string code, bool chk)
{
  for (*it = 0; *it < 10; *it+=1)
  {
    if(code==productos[*it][0]){
      chk=true;
      break;
    }
  }
  return chk;
}
void client_time(int i, int *sales)
{
  string code;
  char c_opt, *ft;
  int subtotal=0, it, amount;
  cout << "¡Muy buenos días clinete número " << i << "!\n";
  do {
    bool chk=false;
    cout << "\nPor favor inserte el código del producto:\n";
    getline(cin, code);
    chk=check_matrix(&it, code, chk);
    if(!chk){
      system("clear || cls");
      cout << "Lo sentimos, ese producto no se encuentra\n\n¿Quiere meter otro producto?\n";
      continue;
    }
    cout << "\nInserte ahora, la cantidad de este:\n";
    cin >> amount;
    clear_it();
    subtotal+=(strtol(productos[it][4].c_str(), &ft, 10)*amount);
    cout << "Gracias por su compra, este es el monto total a pagar: " << subtotal << "\n\n";
ask_it:
    cout << "¿Desea continuar? ('Y' para si o 'N' para no):\n";
    c_opt=getchar();
    clear_it();
    c_opt=toupper(c_opt);
    if(c_opt!='N' && c_opt!='Y'){
      cout << "Recuerde que tiene que escribir bien la opción\n\n";
      goto ask_it;
    }
    *sales+=1;
  } while(c_opt!='N');
  print_piece();
}
void print_piece()
{
  system("clear || cls");
  cout << "\n" << "\tEMPRESA: MERCADO DE U CENTRAL\n"
    << "\tCarrera 5 n.ª21-38\n\n"
    << "======COMPRAS TOTALES=====\n"
    << "\nSubtotal:\t\t" << "Me importa un carajo"
    << "\nImpuesto:\t\t" << "No voy a ser una rata con usted"
    << "\n\nTotal a pagar:\t\t" << "Olvidate de esas pagas absurdas"
    << "\n\n==========================\n\n";
  pause();
  system("clear || cls");
}
