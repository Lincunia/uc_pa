import reference as rf


def main():
    opt = {0: rf.el.quit_my_crap,
           1: rf.something,
           2: rf.test_of_proof,
           3: rf.outer_and_inner,
           4: rf.test_lambda,
           5: rf.dir_proof}
    while True:
        c = int(input(('''
    MENU
1. something
2. test_of_proof
3. outer
4. lambda
5. dir_proof
0. Exit
    Insert what you consider: ''')))
        try:
            opt[c]()
        except KeyError:
            print('''Unvalid option, put in what it is proposed
If you desire to apply a function, program it in here''')
            continue


if __name__ == '__main__':
    main()
