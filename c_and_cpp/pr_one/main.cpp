#include "basic.h"

int main(){
  add_users();
  print_file(txt);
  return 0;
}

void add_users(){
  std::cout << "Hola, subnormal" << std::endl;
}
void print_file(char *name){
  FILE *p_file;
  p_file=fopen("users.txt", "a");
  if(p_file==NULL){
    fputs("Error: ", stderr);
    abort();
  }
  fprintf(p_file, "%s\n", name);
  fclose(p_file);
}
