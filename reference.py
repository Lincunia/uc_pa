import elementary as el


def something():
    print('My father tells me certain things')
    var = el.proof_sum
    var(12, 43)
    objects = ['idiot', var, True]
    objects[1](23, 43)


def test_of_proof():
    a = ['but', 'through', 'all', 'the', 'sorrow', 'we', 'were', 'riding',
         'high']
    print(f'Order 1: {sorted(a)}')
    a = ['I', 'want', 'you', 'to', 'put', 'me', 'down', 'this', 'fire']
    print(f'Order 2: {sorted(a)}')
    a = ['Love', 'Brain', 'Heart', 'control', 'Caffeinate']
    print(f'Order 3: {sorted(a)}')
    print(f'Order 3 (Without any order): {a}')
    a = [3, 1, 4, 6, 9, 0]
    print(f'\nAnd now here we have list.sort: {a.sort()}')
    len(a)


def outer_and_inner():
    func = el.outer()
    func                # Outer
    func()              # Inner
    el.outer()()        # Outer and Inner


def test_lambda():
    ok_go = ['Damian Kulash', 'Tim Nordwind', 'Andy Ross', 'Dan Konopka']
    print(sorted(ok_go, key=lambda s: -len(s)))
    # The same use with format string
    print(f'-- {(lambda s: s[::-1])("one track mind, one track heart")} --')
    # You can use tuples (make sure to declare them explicitly)
    n = 'arre'
    while not n.isdigit():
        n = input('Insert a natural number instead of something else:\n')
    print((lambda x: (x, x**2, x**3))(int(n)))


def dir_proof():
    print('dir function is to display methods and propperties of an object:')
    print(dir(el.test_dir))
    print('\nAnd now, the use of it in __builtins__:')
    print(dir(__builtins__))
    '''
    A namespace is a collection of currently defined symbolic names along with
    information about the object that each name references. You can think of a
    namespace as a dictionary in which the keys are the object names and the
    values are the objects themselves. Each key-value pair maps a name to its
    corresponding object.

    This thing is a comment about the realpython site:
    https://realpython.com/python-namespaces-scope
    '''


def iterable_map():
    beatles = ['Paul', 'John', 'Richard', 'George']
    iterable = map(lambda s: s[::-1], beatles)  # The reverse function is quite
    # short, so we use lambda instead
    print(list(iterable))  # To use the representation of a list
    iterable = map(el.reverse, beatles)  # Just like the iteration in C++, the
    # iteration will be erased when everything is passed, we need to find a
    # point where to start, so we call the map funtion once again
    for i in iterable:
        print(i)
    # Another way to use those lamba
    nums = [2.3, 23.65, 45.27, 6.57, 93.4]
    print('+'.join(map(str, nums)))
    list(map(
        (lambda a, b, c: a + b + c),
        [1, 2, 3], [10, 20, 30], [100, 200, 300]
        ))


def iterable_filter():
    start_a = filter(
            (lambda s: s[0] == 'a'),
            ['albeit', 'dieter rams', 'argon', 'attitude', 'crash']
            )
    for i in start_a:
        print(i)


def use_of_reduce():
    def map_it(function, iterable):
        from functools import reduce
        return reduce(
                lambda items, value: items+[function(value)],
                iterable,
                [])
    print(list(map_it(str, [1, 2, 3, 4, 5])))
    print('''You may think this useful, but take into account that Guido van
Rossum wanted to remove the reduce function''')
