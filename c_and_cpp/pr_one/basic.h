#ifndef BEGGING_FOR_MORE
#define BEGGING_FOR_MORE
#include <iostream>
#include <cstdlib>
#include <cctype>
#include <forward_list>
#include <array>
using namespace std;

string productos[10][5] = {
  {"1", "Arroz", "Lb", "1", "2000"},
  {"2", "Azucar morena", "Lb", "2", "5600"},
  {"3", "Papa pastusa", "Lb", "4", "8900"},
  {"4", "Zanahoria", "Lb", "2", "3700"},
  {"5", "Sal", "Lb", "2", "2000"},
  {"6", "Café", "g", "170", "22600"},
  {"7", "Chocolate", "g", "500", "7300"},
  {"8", "Avena", "g", "1200", "11700"},
  {"9", "Pan tajado", "g", "600", "6000"},
  {"10", "Agua", "ml", "6000", "6500"},
};

array<string, 5> aux;
forward_list<array<string, 5>> arr;
forward_list<array<string, 5>>::iterator it;
// These functions

void clear_it();
char ask_things(string);
bool check_matrix(int *, string, bool);

void client_time(int, int *);
char print_piece(int);
void insert_aux_list(string *, int);


#endif // !BEGGING
