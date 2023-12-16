/*
Diseñar un programa que determina el monto a pagar poruna llamada telefónica
teniendo en cuenta lo siguente: Toda llamada que dure hasta 3 minutos tiene un
costo de $500 luego por cada minuto adicional cobrará $200 se debe leer el
tiempo de la llamada. Debe discriminar el cobro: el valor de los tres primeros
minutos y el valor de los minutos adicionales
*/
#include <cassert>
#include <iostream>
using std::cout;

int to_check(int);
void reduce(int &, int &);

int main() {
  assert(to_check(520) == 1700);
  cout << "Test nº1  worked\n";
  assert(to_check(180) == 500);
  cout << "Test nº2  worked\n";
  assert(to_check(290) >= 900);
  cout << "Test nº3  worked\n";
  assert(to_check(301) == 1100);
  cout << "Test nº4  worked\n";
  return 0;
}

int to_check(int s) {
  int v = 0, m = 0;
  while (s > 180) {
    v += 200;
    reduce(s, m);
  }
  while (s >= 60) {
    reduce(s, m);
  }
  v += 500;
  cout << "Usted estuvo llamando por " << m
       << " minutos, por lo que el valor a cobrar es $" << v
       << ". Gracias por usar el programa :)\n";
  return v;
}
void reduce(int &s, int &m) {
  s -= 60;
  m += 1;
}
