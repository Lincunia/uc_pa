#include "header.h"

unsigned long long int distance_by_min()
{
    int m;
    printf("Insert the amount of minutes you need to convert: ");
    scanf("%d", &m);
    return SPEED * 60 * m;
}
void in_out_chars(){
	char c;
	bool a=false;
	printf("Insert any text you want: ");
	while(c!='\n'){
		c=getchar();
		putchar(c);
	}
	printf("%d", a);
}
void clear_it(void){
	int c;
	do{
		c=getchar();
	}while(c!='\n' && c!=EOF);
}
