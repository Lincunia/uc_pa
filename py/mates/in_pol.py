import numpy as np

def input_pol():
    i=0
    opt=''
    a=np.array([], dtype=int)
    while opt!='n':
        a=np.append(a, int(input(f'Inserte el nùmero en el exponente {i}: ')))
        i+=1
        opt=input('más? ')
    a=np.poly1d(a)
    print(f'resultado de su inserción:\n{a}')
