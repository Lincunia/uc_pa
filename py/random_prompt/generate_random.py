from random import randint


def get_random():
    return randint(-20, 20)


def defined_integral():
    min = get_random()
    max = -20
    while min >= max:
        max = get_random()
    return f'\\int_{{{min}}}^{{{max}}} f(x) \\mathrm{{d}}x\n'
