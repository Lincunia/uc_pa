def f():
    var = 30

    def g():
        global var
        var = 20
    g()
    print(var)


f()  # No effect on 'var'
print(var)  # But there's something else, you can create a global varaible
# within a function that has the 'global' keyword


def h():
    var = 30

    def i():
        nonlocal var
        var = 10
    i()
    print(var)


h()  # Visual effect on 'var'
