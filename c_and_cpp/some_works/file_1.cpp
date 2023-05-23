#include <iostream>

int main() {
    int a, b, c;
    std::cout << "Inserte un número para el valor de a: ";
    std::cin >> a;
    std::cout << "Inserte un número para el valor de b: ";
    std::cin >> b;
    std::cout << "Inserte un número para el valor de a: ";
    std::cin >> c;
    if(a>b && a>c){
        std::cout << "a";
    }
    else{
        if(b>c) std::cout << "b";
        else std::cout << "c";
    }
    std::cout << " es el número mayor\n";
    return 0;
}