import elemental as el


def get_function():
    random_num = el.np.random.randint(2, 6)
    func = el.do_numpy_algebra(random_num)
    return el.get_LaTeX(func, random_num)


def random_trigonometrics():
    trigonometric_functions = {
            1: '\\sin',
            2: '\\cos',
            3: '\\tan',
            4: '\\sinh',
            5: '\\cosh',
            6: '\\tanh'}
    return trigonometric_functions[el.np.random.randint(1, 7)]+'(x)'


def random_logarithms():
    random_num = el.np.random.randint(2, 5)
    func = el.do_numpy_algebra(random_num)
    return f'\\frac{{{el.get_LaTeX(el.np.polyder(func), random_num-1)}}}{{\\ln{{({el.get_LaTeX(func, random_num)})}}}}'


def get_result():
    opts = {
            0: get_function,
            1: random_trigonometrics,
            2: random_logarithms}
    return opts[el.np.random.randint(0, 3)]()
