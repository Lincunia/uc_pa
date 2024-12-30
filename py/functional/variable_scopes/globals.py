print(globals())
x = 'foo'
print(globals())  # Keep your eyes on what you got at the end of the list
# nreturned
print(globals()['x'])  # 'foo' must be displayed

g = globals()  # Just like functional programming
print(g)  # Look at the "'g': {...}" element in the list
