from numpy.random import randint
import generate_it as gi


def defined_integral():
    min = randint(-10, 2)
    max = -10
    while min >= max:
        max = randint(-10, 10)
    return f'\t\t\t\\int_{{{min}}}^{{{max}}} {gi.get_result()} \\mathrm{{d}}x\n'
