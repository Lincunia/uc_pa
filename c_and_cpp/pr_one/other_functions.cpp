#include "basic.hpp"

void clear_it() {
  int c;
  while ((c = getchar()) != '\n' && c != EOF);
}
bool check_it(int code){
	if(code >= 1 && code <= 10) return true;
	cout << "Por favor, inserte un código de entre 1 y 10";
	return false;
}
