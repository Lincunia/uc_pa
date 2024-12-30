# TIPS FOR PYTHON

1. If you're going to concatenate a string with other things (integers,
floats, boolean, etc.) use format-strings, don't struggle with other methods.

2. Avoid manually closing a file, just use the with statement.

3. Use context manager instead of try-finally to ensure that all the inputs
get closed.

4. Don't use a bare except clause, because you may not know what is actually
happening to the system, and the collection of bugs will be pretty enormous.

5. If you want to define the value of an argument, specially with a list type,
don't use `[]` to make it empty, use `None` instead.

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

6. Use comprehensions (list = {i: v for i in range(n)}, being "list" a random
list, "i" the iterator, "v" a random value for the index of the list depending
on the iterator and "n" a random number) if you want to work with a list and
reduce the amount of code.

7. Moderate the amount of times you use the sixth tip, the thing that you must
care is how readable is your code.

8. If you want to check the data type of any variable, you ought to use
`isinstance()` function instead of the == operator.

9. When you try to check if a variable is `True`, `False` or `None`, don't use
the == operator, use `is` instead.

10. You don't have to use `if bool(x)` or `if len(x) != 0` you can implicitly
use `if x`.

11. Use `for i in list` instead of `for i in range(len(list))` but if you want
the indexes too, you can use the `enumerate()` function like so:

```python
a = ['What', 'have', 'I', 'done', 'to', 'deserve', 'this']
for i, v in enumerate(a):
    print(i, v)
'''
0 What
1 have
2 I
3 done
4 to
5 deserve
6 this
'''
```

12. Use tuple unpacking, which extracts the elements of a tuple to separate
variables, you can do it in this way:

```python
a_tuple = 'Hello', 'World'
x, y = a_tuple
print(y)  # World
```

13. You should consider these aspects about the time module:

- `time.time()` ← It gives you the current time
- `time.perf_counter()` ← as time.time() but more accurate
- `time.sleep(1)`

14. If you want to debug a current situation on your code, you should use the
logging module to display the information about your debugs.

15. When you use the sub-process module, and then you start using the `run()`
function, in the first argument (Where you have to insert a shell command) you
have to use a list of a command argument instead of a string. Bad:
` subprocess.run(["ls -l"], capture_output=True, shell=True) ` and good:
` subprocess.run(['ls, '-l'], capture_output=True)`

16. Learn to use `numpy `and `pandas`, for array operations and for more
general data analysis respectively

17. Don't import every namespace by using * (`from itertools import *`), just
use the things that you really need (`import itertools import count`)

18. Don't start writing code just because, please start looking for ways on
how to structure the code in order to do some packaging

19. Use the pep8 guide, how to set the things appropriately 

20. Try to upgrade your code to the latest version on the language, but don't
delete that code because it would be useful someday
