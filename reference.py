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
    print(f'Order 3 (Pero sin ordenar): {a}')
    a = [3, 1, 4, 6, 9, 0]
    print(f'\nAhora el uso de list.sort: {a.sort()}')
    len(a)


def outer_and_inner():
    func = el.outer()
    func                # Outer
    func()              # Inner
    el.outer()()        # Outer and Inner
