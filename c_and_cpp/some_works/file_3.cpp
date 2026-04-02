#include <iostream>

int main() {
    int dd=0, hh, mm, ss, t;
    std::cout << "Inserte la hora de partida: ";
    std::cin >> hh;
    std::cout << "Inserte los minutos: ";
    std::cin >> mm;
    std::cout << "Inserte los segundos: ";
    std::cin >> ss;
    std::cout << "Inserte la cantidad de segundos ue tarda de llegar allá: ";
    std::cin >> t;
    ss+=t;
    while(ss>=60){
        ss-=60;
        mm++;
    }
    while(mm>=60){
        mm-=60;
        hh++;
    }
    while(hh>=24){
        hh-=24;
        dd++;
    }
    std::cout << "El ciclista llegó a las " << hh << " : " << mm << " : " << ss << " tras "<<  dd << " días\n";
    return 0;
}