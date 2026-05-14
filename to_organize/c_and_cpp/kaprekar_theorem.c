#include "utilities.h"

char *
sort_by_insertion (int num)
{
    char *arr = malloc (4);
    for (int i = 0; i < 4; i++)
        {
            *(arr + i) = (num % 10 + '0');
            num /= 10;
        }
    for (int i = 1; i < 4; i++)
        {
            char temp = *(arr + i);
            int j = i - 1;
            while (j >= 0 && temp < *(arr + j))
                {
                    *(arr + j + 1) = *(arr + j);
                    j--;
                }
            *(arr + j + 1) = temp;
        }
    return arr;
}

unsigned short
s_forward (int num)
{
    char *arr = sort_by_insertion (num);
    return char_arr_to_short (arr);
}

unsigned short
s_backwards (int num)
{
    char *arr = sort_by_insertion (num);
    unsigned short result = 0;
    // For some reason I wanted to do a prefix decrement
    for (int i = 3; i >= 0; --i)
        {
            result *= 10;
            result += *(arr + i) - '0';
        }
    return result;
}

int
main (int argc, char **argv)
{
    int num, n_b, n_f, iter = 1;
    if (argc == 2)
        {
            if (strlen (argv[1]) > 4)
                {
                    printf ("Not valid number");
                    return EXIT_FAILURE;
                }
            num = char_arr_to_short (argv[1]);
            goto budha;
        }
    char aux_number[5], *str;
    printf ("Insert a 4-digit number whose digits are all different: ");
    str = fgets (aux_number, 5, stdin);
    if (str == NULL)
        {
            printf ("Not valid insertion\n");
            return EXIT_FAILURE;
        }
    num = char_arr_to_short (aux_number);
budha:
    do
        {
            n_b = s_backwards (num);
            n_f = s_forward (num);
            num = n_b - n_f;
            printf ("Iteration %d: %d - %d = %d\n", iter++, n_b, n_f, num);
        }
    while (num != 6174);
    return EXIT_SUCCESS;
}
