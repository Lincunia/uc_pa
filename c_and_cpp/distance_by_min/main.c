#include "header.h"

int main()
{
	int opt;
	printf("Insert your option for this: ");
	scanf("%d", &opt);
	clear_it();
	switch(opt){
		case 1:
			printf("This is the distance: %llu\n", distance_by_min());
			break;
		case 2:
			in_out_chars();
	}
    return 0;
}
