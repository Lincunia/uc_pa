#include <stdio.h>

int main(void)
{
    int n, m, i, total = 1;
    printf("Total amount: ");
    scanf("%d", &n);
    printf("Amount inside a group: ");
    scanf("%d", &m);
	if(m > n){
		perror(" -- Not valid amount --\n");
		return 1;
	}
    for (i = n; i > (n - m); i--) {
        total *= i;
    }
    printf("Combinations from that group: %d\n", total);
    return 0;
}
