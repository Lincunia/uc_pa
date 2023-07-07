import reference as rf


def main():
    opt = {0: rf.el.quit_my_crap,
           1: rf.something,
           2: rf.test_of_proof,
           3: rf.outer_and_inner}
    while True:
        c = int(input(('''
    MENU
1. something
2. test_of_proof
3. outer
0. Exit
    Insert what you consider: ''')))
        try:
            opt[c]()
        except KeyError:
            continue


if __name__ == '__main__':
    main()
