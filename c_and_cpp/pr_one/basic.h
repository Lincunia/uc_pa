#ifndef BEGGING
#define BEGGING
/*
 * Libreries
 */
#include <iostream>
#include <stdlib.h>
#include <string.h>
/*
 * Classes, unions, etc.
 */
class user {
public:
  user(int, int, char *);
  unsigned int id, money;
  char name[100];
};
user::user(int in_id, int in_money, char *in_name) {
  id=in_id;
  strcpy(name, in_name);
  money=in_money;
}
/*
 * Functions
 */
void add_users();
void print_file(char *);
#endif // !BEGGING
