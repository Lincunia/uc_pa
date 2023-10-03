import numpy as np


def do_numpy_algebra(random_num):
    a = [0] * random_num
    for i in range(random_num):
        a[i] = np.random.randint(-20, 20)
    return np.poly1d(a)


def get_LaTeX(func, base_num):
    LaTeX_text = ''
    exp = 0
    for i in range(base_num):
        exp = base_num - (i + 1)
        if int(i) >= 1 and func.c[i] > 0:
            LaTeX_text += '+'
        if func.c[i] == 0:
            continue
        LaTeX_text += f'{func.c[i]}'
        if exp == 1:
            LaTeX_text += 'x'
        if exp > 1:
            LaTeX_text += f'x^{{{exp}}}'
    return LaTeX_text
