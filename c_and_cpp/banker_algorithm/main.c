/*
 * It is used to take the safe state of the system to detect a deadlock. Using
 * a certain number of process and resources
 */
#include <stdio.h>

int max[10][10], allocation[10][10], need[10][10];
int avail[10];
int np, nr;

void read_matrix(int matrix[10][10])
{
}
void display_matrix(int matrix[10][10])
{
}
void calculate_need()
{
}

int main()
{
    int j;
    printf("Enter the number of processes:\n");
    scanf("%d", &np);
    printf("Enter the number of resources:\n");
    scanf("%d", &nr);
    printf("Enter the initial allocation matrix:\n");
    read_matrix(allocation);
    printf("Enter the maximum requirement matrix:\n");
    read_matrix(max);
    printf("Enter the available resources:\n");
	for (j = 0; j < nr; j++) {
		scanf("%d", &avail[j]);
	}
    return 0;
}
