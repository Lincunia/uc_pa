#include <iostream>

int main() {
    float sb;
    std::cout << "Escriba el valor de su sueldo base mensual: ";
    std::cin >> sb;
    std::cout.precision(12);
    sb+=(sb*0.1);
    std::cout << "Valor por comisión: " << sb/3
    << "\nGanancia mensual: " << sb << std::endl;
    return 0;
}