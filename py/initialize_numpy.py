from numpy import zeros, ones, empty


def use_zeros(x, y):
    print('Unidimensional numpy.array:')
    for i in range(y):
        arr = zeros(x)
        print(f'Array number {i}: {arr}')
    print('\nnumpy.array with more dimensions:')
    arr = zeros((y, x))
    for i in arr:
        print(i)


def use_ones(x, y):
    print('Unidimensional numpy.array:')
    for i in range(y):
        arr = ones(x)
        print(f'Array number {i}: {arr}')
    print('\nnumpy.array with more dimensions:')
    arr = ones((y, x))
    for i in arr:
        print(i)


def use_empty(x, y):
    print('Unidimensional numpy.array:')
    for i in range(y):
        arr = empty(x)
        print(f'Array number {i}: {arr}')
    print('\nnumpy.array with more dimensions:')
    arr = empty([y, x])
    for i in arr:
        print(i)


def main():
    y = input('Insert the amount of arrays: ')
    x = input('Insert the size of the previous ones: ')
    try:
        x = int(x)
        y = int(y)
    except Exception as e:
        raise e
    use_zeros(x, y)
    print('\n ============================= \n')
    use_ones(x, y)
    print('\n ============================= \n')
    use_empty(x, y)


if __name__ == "__main__":
    main()
