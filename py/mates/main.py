import in_pol
from os import system

def main():
    c=''
    while c!='a':
        c=input('''
    MENÚ
a. Salir
b. Escribir polinomios

Inserte la variable: ''')
        system('cls || clear')
        if c=='b': in_pol.input_pol()
if __name__ == "__main__":
    main()
