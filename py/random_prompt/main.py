import generate_random


def main():
    n = int(input('Inserte la cantidad de integrales random: '))
    tex_file = open('exercises.tex', 'w')
    tex_file.write('''\\documentclass{article}
\\usepackage{amssymb, amsmath}
\\usepackage{geometry}
\\geometry{
\tletterpaper,
\tleft=25mm,
\ttop=25mm
}

\\begin{document}
\\begin{enumerate}
''')
    for i in range(n):
        tex_file.write('\t\\item\n\t\t\\begin{gather*}\n')
        tex_file.write(generate_random.defined_integral())
        tex_file.write('\t\t\\end{gather*}\n')
    tex_file.write('''\\end{enumerate}
\\end{document}''')
    tex_file.close()


if __name__ == "__main__":
    main()
