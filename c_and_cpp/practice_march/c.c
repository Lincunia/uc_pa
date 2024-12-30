#include <stdio.h>
#include <time.h>

int return_month();

int main ()
{
  unsigned int t;
  printf("Inserte el total de la compra\n");
  scanf("%ud", &t);
  if (return_month()==10) {
    printf("Total a pagar: %f\n", t*0.2);
    return 0;
  }
  printf("Total a pagar: %d\n", t);
  return 0;
}

int return_month(){
  time_t rawtime;
  struct tm * timeinfo;

  time ( &rawtime );
  timeinfo = localtime ( &rawtime );
  return timeinfo->tm_mon+1;
}
