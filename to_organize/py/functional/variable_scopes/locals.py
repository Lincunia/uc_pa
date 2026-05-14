def f(x, y):
    s = 'foo'
    print(locals())


def g():
    s = 'Little russian'
    loc = locals()  # This only returns a copy of the returned value of locals
    print(loc)
    num = 120
    print(loc)  # You get the same thing as int he line 9
    loc['s'] = 'Moskau'
    print(s)  # You get 'Little russian'


f(3, 4)
g()
