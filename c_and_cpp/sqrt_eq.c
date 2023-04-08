#include <stdio.h>
#include <math.h>

/*
 * ESTE ES UN PRAGRAMA QUE TE SACA LA ECUACIÓN CUADRÁTICA
 */
int main(int argc, char **argv)
{
	int a, b, c, d;
	if (argc == 4)
	{
		sscanf(argv[1], "%d", &a);
		sscanf(argv[2], "%d", &b);
		sscanf(argv[3], "%d", &c);
		goto wtf;
	}
	printf("\nInserte por favor el valor de a: ");
	scanf("%d", &a);
	printf("\nInserte por favor el valor de b: ");
	scanf("%d", &b);
	printf("\nInserte por favor el valor de c: ");
	scanf("%d", &c);
wtf:
	d = -4 * a * c;
	printf("\n-4*a*c: %d", d);
	printf("\nb^2: %f", pow(b, 2));
	d += pow(b, 2);
	printf("\n2a: %d y -b: %d", 2 * a, b * -1);
	printf("\nNumerador 1: %14f", (b * -1) + sqrt(d));
	printf("\nNumerador 2: %14f", (b * -1) - sqrt(d));
	return 0;
}
