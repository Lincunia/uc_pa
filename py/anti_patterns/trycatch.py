'''
When you inset a try/except block, you can't see the complete set of errors
that you have in your files, so you mustn't insert that code block in order to
do troubleshooting freely... So if in your code there's a try/except block,
then you're creating a software that works and looks like shit, because you're
harming your morale, happiness and self-esteem when you figure out for hours
the solution for the issue by the time you thin you code badly.

Even though, that sounds demoralizing, you can prevent that situation by
simply removing that block segment
'''
import basis as b


def raise_something():
    try:
        n = 65 / 0
        b.logging.log(n)
    except Exception as e:
        b.logging.error(e)
        raise e


def get_error():
    a = input('Insert a string:')
    n = int(a)
    print('Congratulations, you inserted an int:' + n)


def proof_some():
    nums = ([23, 2], ['one', 2], [23, 0])
    for i in nums:
        try:
            b.logging.log(b.divide(i[0], i[1]))
        except Exception as e:
            raise ValueError('Invalid argument') from e


def t_c_composition():
    try:
        b.linux_interaction()
    except AssertionError as error:
        print(error)
    else:
        try:
            with open('file.log', 'r') as file:
                print(file.read())
        except FileNotFoundError as fnf_error:
            print(fnf_error)
    finally:
        print('Cleaning up, irrespective of any exceptions.')


def main():
    opt = {
            0: b.end_of_the_program,
            1: get_error,
            2: raise_something,
            3: proof_some,
            4: t_c_composition
            }
    while True:
        c = input('''
    MENU
1: get_error
2: raise_something
3: proof_some
4: t_c_composition
0. Exit
    Insert what you consider: ''')
        try:
            opt[int(c)]()
        except KeyError:
            print('''Unvalid option, put in what it is proposed
If you desire to apply a function, program it in here''')
            continue
        if c == '0':
            break


if __name__ == "__main__":
    main()
