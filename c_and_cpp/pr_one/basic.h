#ifndef BEGGING
#define BEGGING
#include <iostream>
#include <cstdlib>
#include <cctype>
using namespace std;
// Basic matrix
// Scrappy reference: Code-Description-Unities-Size of unities-prize
// This thing will improve
string productos[10][5]={
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

// These functions

void clear_it();
void pause();
void client_time(int, int *);
bool check_matrix(int *, string, bool);
void print_piece();

#endif // !BEGGING
