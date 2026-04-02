/*
 * PROGRAM TO LEARN CROSS-PLATFORM DEVELOPMENT
 */
#include <stdlib.h>
void clear_screen()
{
#ifdef _WIN32
    system("cls");
#else
    system("clear");
#endif
}

int main(void)
{
    clear_screen();
    return 0;
}
