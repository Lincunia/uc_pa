# The Python 3 version. It's a little less work.
import traceback


class ExceptionLogger:
    def log(str):
        print(str)


def get_number():
    return int('foo')


def log_traceback(ex):
    exception_logger = ExceptionLogger()
    tb_lines = traceback.format_exception(ex.__class__, ex, ex.__traceback__)
    tb_text = ''.join(tb_lines)
    # I'll let you implement the ExceptionLogger class,
    # and the timestamping.
    exception_logger.log(tb_text)


def main():
    try:
        get_number()
    except Exception as ex:
        log_traceback(ex)


if __name__ == "__main__":
    main()
