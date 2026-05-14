#include "utilities.h"

void
verify_input (char *ss)
{
    if (ss == NULL)
        {
            printf ("Not valid insertion\n");
            exit (1);
        }
}

char *
insert_string (char *str, char *req, unsigned int size)
{
    char *ss;
    str = malloc (size);
    printf ("%s", req);
    ss = fgets (str, size, stdin);
    verify_input (ss);
    return str;
}

char *
capitalize_string (char *s)
{
    return s;
}

int
main (void)
{
    unsigned short str_length = 0;
    char current_char, crow_char;
    char *text, *str, *str_l, *crow;
    str_l = insert_string (str_l, "Insert the string length: ", 5);
    str_length = char_arr_to_short (str_l);
    text = insert_string (text, "Insert message: ", str_length);
    crow = malloc (str_length);

    for (unsigned short i = 0; *(text + i) != '\0'; i++)
        {
            current_char = *(text + i);
            if (current_char >= 'a' && current_char <= 'z')
                *(text + i) = current_char - 32;
            switch (*(text + i))
                {

                case 'A':
                    crow_char = 83;
                    break;
                case 'B':
                    crow_char = 70;
                    break;
                case 'C':
                    crow_char = 84;
                    break;
                case 'D':
                    crow_char = 90;
                    break;
                case 'E':
                    crow_char = 76;
                    break;
                case 'F':
                    crow_char = 81;
                    break;
                case 'G':
                    crow_char = 85;
                    break;
                case 'H':
                    crow_char = 73;
                    break;
                case 'I':
                    crow_char = 82;
                    break;
                case 'J':
                    crow_char = 86;
                    break;
                case 'K':
                    crow_char = 89;
                    break;
                case 'L':
                    crow_char = 79;
                    break;
                case 'M':
                    crow_char = 74;
                    break;
                case 'N':
                    crow_char = 67;
                    break;
                case 'O':
                    crow_char = 69;
                    break;
                case 'P':
                    crow_char = 88;
                    break;
                case 'Q':
                    crow_char = 77;
                    break;
                case 'R':
                    crow_char = 72;
                    break;
                case 'S':
                    crow_char = 87;
                    break;
                case 'T':
                    crow_char = 78;
                    break;
                case 'U':
                    crow_char = 80;
                    break;
                case 'V':
                    crow_char = 66;
                    break;
                case 'W':
                    crow_char = 65;
                    break;
                case 'X':
                    crow_char = 68;
                    break;
                case 'Y':
                    crow_char = 75;
                    break;
                case 'Z':
                    crow_char = 71;
                    break;
                default:
                    crow_char = *(text + i);
                    break;
                }
            *(crow + i) = crow_char;
        }
    printf ("Crow text: %s\n", crow);
    return EXIT_SUCCESS;
}
