# When you program something you might find a situation like this:
x = 20  # You declare a normal variable


def f():
    x = 40  # "Redefine" the values of x
    print(x)


f()  # returns 40
print(x)  # returns 20. Why does this thing happen? Well, to solve that issue,
# you must use the keyword 'global' which modifies a global scope and you apply
# that like that:


def g():
    global x  # just like a new reference to the scope that belongs to the
    # global one. And that way we could work without any troubles with the
    # namespace of our variables
    x = 40
    print(x)


g()  # returns 40
print(x)  # returns 40. LIKE A BOSS!!
alpha, betta, gamma = 23, 'Oh No', True
print(f'Declaraciones de variables respectivas: {alpha}, {betta}, {gamma}')
