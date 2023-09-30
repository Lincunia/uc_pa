import numpy as np


def random_trigonometrics():
    trigonometric_functions = {
            1: '\\sin',
            2: '\\cos',
            3: '\\tan',
            4: '\\sinh',
            5: '\\cosh',
            6: '\\tanh'}
    return trigonometric_functions[np.random.randint(1, 6)]


def random_function():
    random_num = np.random.randint(2, 5)
    LaTeX_text = ''
    a = [0] * random_num
    for i in range(random_num):
        a[i] = np.random.randint(-20, 20)
    func = np.poly1d(a)
    exp = 0
    for i in range(random_num):
        exp = random_num - (i + 1)
        if i >= 1 and func.c[i] > 0:
            LaTeX_text += '+'
        if func.c[i] == 0:
            continue
        LaTeX_text += f'{func.c[i]}'
        if exp == 1:
            LaTeX_text += 'x'
        if exp > 1:
            LaTeX_text += f'x^{{{exp}}}'
    return LaTeX_text


def main():
    print(random_function())


if __name__ == "__main__":
    main()
