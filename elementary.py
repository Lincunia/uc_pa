def quit_my_crap():
    print('·U· Thank you for using my program ·U·')
    exit(0)


def proof_sum(a, b):
    print(f'The sum of whatever the author put is: {a+b}')


def outer():
    def inner():
        print('Soy la función interna')
    print('Soy la función externa')
    return inner
