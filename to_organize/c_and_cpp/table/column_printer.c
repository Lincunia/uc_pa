#include <stddef.h>
#include <stdio.h>
#include <string.h>

void print_line_division(unsigned int col_len) {
	int i;
	printf("|");
    for (i = 0; i < col_len - 1; i++) {
		printf("-");
	}
	printf("|\n");
}

void print_inside(char *str, size_t str_len, size_t dif_len){
	size_t current_str_len = strlen(str) + 2;
	printf("| %s", str);
	for (int j = current_str_len; j < dif_len; j += 8) {
		printf("\t");
	}
	printf("|\n");
}

int main(int argc, char** argv)
{
    int i;
    size_t current_str_len;
    size_t largest_str = 7;
    for (i = 1; i < argc; i++) {
        current_str_len = strlen(argv[i]);
        if (current_str_len > largest_str) {
            largest_str = current_str_len;
        }
    }
    largest_str += 2;
    size_t dif_len = largest_str + (8 - (largest_str % 8));

	print_line_division(dif_len);
	char *header = "CONTENT";
	print_inside(header, strlen(header), dif_len);
	print_line_division(dif_len);
    for (i = 1; i < argc; i++) {
		print_inside(argv[i], strlen(argv[i]), dif_len);
    }
	print_line_division(dif_len);
    return 0;
}
