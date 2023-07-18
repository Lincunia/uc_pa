#include <iostream>
/*
 * Al parecer me pareció una excelente idea tratar de documentar lo que voy
 * encontrando en forma de comentarios... qué raro. Las "function templates"
 * pueden adaptar su funcionalidad en más de un tipo de dato o clase sin repetir
 * el código entero de cada archivo. Esas funciones se declaran como un
 * parámetro, no como una función tradicional. En este punto me estoy quedadndo
 * escribiiendo un montń de cosas para que pueda hacer el commit en git. En los
 * parámetros de plantilla (Template parametes) es un tipo de parámetro en el
 * que se le puede pasar un tipo de dato como argumento (Como una función pero
 * que no como tal, sino que también se le meten otras cosas)
 */

template <class T> T GetMax(T a, T b) {
  T result;
  result = (a > b) ? a : b;
  return (result);
}

int main() {
  int i = 5, j = 6, k;
  long l = 10, m = 5, n;
  k = GetMax<int>(i, j);
  n = GetMax<long>(l, m);
  std::cout << k << std::endl;
  std::cout << n << std::endl;
  return 0;
}
