import in_pol
from os import system


def main():
    opt = {'a': in_pol.display_exit,
           'b': in_pol.input_pol}
    c = ''
    while c != 'a':
        c = input('''
    MENÚ
a. Salir
b. Escribir polinomios

Inserte la variable: ''')
        system('cls || clear')
        try:
            opt[c]()
        except KeyError:
            continue


if __name__ == "__main__":
    main()
