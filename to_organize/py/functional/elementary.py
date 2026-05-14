class test_dir:
    name = 'Rolf Koehler'
    age = 56
    genre = True  # True for male and False for female


def quit_my_crap():
    print('·U· Thank you for using my program ·U·')
    exit(0)


def proof_sum(a, b):
    print(f'The sum of whatever the author put is: {a+b}')


def outer():
    def inner():
        print('I\'m the inner space of the TARDIS')
    print('I\'m the outer space of the TARDIS')
    return inner


def reverse(s):  # This is often used a as list
    return s[::-1]
