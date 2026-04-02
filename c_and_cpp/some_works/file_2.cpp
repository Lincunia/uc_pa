#include <iostream>

int main() {
    int i=0, n;
    std::cout << "Inserte un número entero: ";
    std::cin >> n;
    while(i<=10){
        std::cout << n << " x " << i <<" = " << n*i << std::endl;
        i++;
    }
    return 0;
}