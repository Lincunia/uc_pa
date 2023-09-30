from numpy.random import randint
import generate_it as gi


def get_random():
    return randint(-20, 20)


def defined_integral():
    min = get_random()
    max = -20
    while min >= max:
        max = get_random()
    return f'\t\t\t\\int_{{{min}}}^{{{max}}} {gi.random_function()} \\mathrm{{d}}x\n'
