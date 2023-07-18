import numpy as np


def input_pol():
    i = 0
    opt = ''
    a = np.array([], dtype=int)
    while opt != 'n':
        num = input(f'Inserte el nùmero en el exponente {i}: ')
        a = np.append(a, int(num))
        i += 1
        opt = input('más? ')
    a = np.poly1d(a)
    print(f'resultado de su inserción:\n{a}')


def display_exit():
    print('\nSólo es cuestión de esperar y seguir mejorando en lo que fuera\n')
