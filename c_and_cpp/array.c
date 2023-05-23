#include <stdio.h>
#include <stdlib.h>
#include <string.h>

void in_val(char *);

int main(void)
{
  char txt[8], *ft;
arre:
  printf("Inserte la cantidad de números flotantes (máximo 9999999): \n");
  in_val(txt);
  if(strcmp(txt, "malitos")==0){
    printf("Lo que insertó no es válido\n\n");
    goto arre;
  }
  int d=strtol(txt, &ft, 10), i;
  if(!d){
    printf("Inserte un número, no un texto\n\n");
    goto arre;
  }
  float *f=(float*)malloc(d);
  for (i = 0; i < d; i++) {
    printf("Inserte el valor en el arreglo en [%d]: ", i);
    in_val(txt);
    *(f+i)=strtof(txt, &ft);
  }
  for (i = 0; i < d; i++) {
    printf("Contenido en [%d]: %0.14f\n", i, *(f+i));
  }
  return EXIT_SUCCESS;
}

void in_val(char *txt){
  while (1) {
    char *str;
    str=fgets(txt, 8, stdin);
    if(str==NULL){
      strcpy(txt, "malitos");
    }
    break;
  }
}
