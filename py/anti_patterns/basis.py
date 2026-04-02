import logging
from sys import platform

n = 0


def verify_number(arg):
    if not isinstance(arg, int | float):
        raise TypeError(f'number expected, got {type(arg).__name__}')


def divide(x, y):
    for arg in (x, y):
        verify_number(arg)
    if y == 0:
        raise ValueError("denominator can't be zero")
    return x / y


def end_of_the_program():
    logging.log(20, 'Thank you for using this program')


def linux_interaction():
    assert ('linux' in platform), "Function can only run on Linux systems."
    print('Doing something.')
