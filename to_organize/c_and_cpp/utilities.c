#include "utilities.h"

/*
 * I know the existance fo atoi() or strtol(), but I wanted to learn how to
 * convert a number in s function by myself
 */
unsigned short
char_arr_to_short (char *num_as_str)
{
    unsigned short r_num = 0;
    char current_char;
    for (unsigned long int num_size = strlen (num_as_str), i = 0; i < num_size;
         i++)
        {
            current_char = *(num_as_str + i);
            if (current_char == 10)
                break;
            r_num *= 10;
            r_num += current_char - '0';
        }
    return r_num;
}

void
clear_it ()
{
    int c;
    do
        {
            c = getchar ();
        }
    while (c != '\n' && c != EOF);
}
