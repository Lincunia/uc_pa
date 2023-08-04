import elementary as el


def something():
    print('My father tells me certain things')
    var = el.proof_sum
    var(12, 43)
    objects = ['idiot', var, True]
    objects[1](23, 43)


def test_of_proof():
    a = ['but', 'through', 'all', 'the', 'sorrow', 'we', 'were', 'riding', 'high']
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
