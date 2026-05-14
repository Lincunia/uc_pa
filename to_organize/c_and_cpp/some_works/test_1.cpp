#include <iostream>

int main() {
    float temp, p=0, max=1000;
    int hd=6;
    while(hd<=24){
        std::cout << "Inserte la temperatura (°C) de las ";
        if(hd==24) std::cout << "00";
		else std::cout << hd;
		std::cout << ":00 ";
		std::cin >> temp;
		p+=temp;
		hd+=6;
		if(temp<=max) max=temp;
    }
    std::cout << "Temperatura promedio: " << p/4
    << "\nTemperatura mínima del día: " << max << std::endl;
    return 0;
}

/*
 * VERSIÓN ALERNATIVA
 *

#include <iostream>

int main() {
    float temp[4], p=0, max=1000;
    int hd=0, i;
    for(i=0; i<4; i++){
        std::cout << "Inserte la temperatura (°C) de las ";
        if(hd==24) std::cout << "00";
		else std::cout << hd;
		std::cout << ":00 ";
		std::cin >> temp[i];
		p+=temp[i];
		hd=(i+1)*6;
		if(temp[i]<=max) max=temp[i];
    }
    std::cout << "Temperatura promedio: " << p/4
    << "\nTemperatura mínima del día: " << max << std::endl;
    return 0;
}
*/