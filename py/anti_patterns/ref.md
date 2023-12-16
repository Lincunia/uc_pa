# TIPS FOR PYTHON

1. If you're going to concatenate a string with other things (integers, floats, boolean, etc.) use format-strings, don't
struggle with other methods
2. Avoid manually closing a file, just use the with statement
3. Use context manager instead of try-finally to ensure that all the inputs get closed
4. Don't use a bare except clause, because you may not know what is actually happening to the system, and the collection
of bugs will be pretty enormous
5. If you want to define the value of an argument, specially with a list type, don't use [] to make it empty, use None
instead

What we don't want to do:
```python
def append_with_something(n, l=[]):
    l.append(n**2)
    return l

l1 = append_with_something(1) # [1]
l2 = append_with_something(2) # [1, 4]
```

What we wish to happen:
```python
def append_with_something(n, l=None):
    l = []
    l.append(n**2)
    return l

l1 = append_with_something(1) # [1]
l2 = append_with_something(2) # [4]
```
6. Use comprehensions (list = {i: v for i in range(n)}, being "list" a random list, "i" the iterator, "v" a random value
for the index of the list depending on the iterator and "n" a random number) if you want to work with a list and reduce
the amount of code
7. Moderate the amount of times you use the sixth tip, the thing that you must care is how readable is your code
8. If you want to check the data type of a variable
