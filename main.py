import reference as rf


def main():
    opt = {0: rf.quit_my_crap,
           1: rf.something,
           2: rf.test_of_proof}
    while True:
        c = int(input(('''
    MENU
1. something
2. test_of_proof
0. Exit
    Insert what you consider: ''')))
        try:
            opt[c]()
        except KeyError:
            continue


if __name__ == '__main__':
    main()
