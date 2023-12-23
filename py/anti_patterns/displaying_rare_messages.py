import logging


def printing_things():
    logging.debug('Fix this thing')
    logging.info('You\'re a vulgar living being')
    logging.error('I\'m now becomming my own self-fulfilled prophecy... OH NO')


def main():
    logging.basicConfig(level=logging.DEBUG,
                        format='[%(levelname)s] %(asctime)s - %(message)s')
    printing_things()


if __name__ == "__main__":
    main()
