'''
Only with python 3.11 or later
'''
try:
    raise ExceptionGroup(
        "several errors",
        [
            ValueError("invalid value"),
            TypeError("invalid type"),
            KeyError("missing key"),
        ],
    )
except ValueError:
    print("Handling ValueError")
except TypeError:
    print("Handling TypeError")
except KeyError:
    print("Handling KeyError")
