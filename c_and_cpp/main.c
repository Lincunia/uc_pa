#include <stdio.h>
#include <stdlib.h>

void flush_b();
void push(void);
void pop(void);

int main(int argc, char const *argv[])
{
  char o;
  if (argc == 2)
  {
    o = *argv[1];
    goto starting;
  }
  do
  {
    printf("\n\tOPTION DISPLAY\n\na. Insert\nb. Show\nc. Leave\n\nInsert the option: ");
    o = getchar();
  starting:
    flush_b();
    system("clear || cls");
    switch (o)
    {
      case 'a':
        push();
        break;
      case 'b':
        pop();
        break;
      case 'c':
        printf("Thanks for the use of this program");
        break;
      default:
        printf("Please, make sure you insert the right options");
        break;
    }
    printf("\n");
  } while (o != 'c');
  return 0;
}
void flush_b()
{
  int c;
  while ((c = getchar()) != '\n' && c != EOF);
}
void push()
{
  printf("Until the lights go down");
}
void pop()
{
  printf("No mames");
}
