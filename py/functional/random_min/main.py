import pandas as pd
import matplotlib.pyplot as plt


def ch1():
    # Abrimos el archivo
    file = open('votosCV.txt', 'r', encoding='utf-8')
    # Las lineas se almacenan en esta lista de strings
    lines = file.readlines()
    # Se crea el DataFrame con las columnas puestas, pero vacias
    df = pd.DataFrame({"candidato1": [],
                       "candidato2": [],
                       "candidato3": [],
                       "votoenblanco": [],
                       "votonulo": []})
    # La fila auxiliar vacia
    row = list()
    # Se crea un rango como índice tanto para las lineas del archivo como en
    # el DataFrame
    for line in range(3):
        # Se recorren los caracteres de la línea actual
        for i in lines[line]:
            # Se eliminan los caracteres '[', ']', '\n', ','
            if i in "[\n],":
                lines[line] = lines[line].replace(i, '')
        # Se coloca una lista con los candidatos puestos en la linea en la que
        # se encuentra
        wrd = lines[line].split(' ')
        # Se cuentan los elementos que se referencian en las columnas del
        # DataFrame
        for i in df.columns:
            row.append(wrd.count(i))
        # Se insertan la cantidad en el DataFrame
        df.loc[line] = row
        # Se limpia la fila auxiliar
        row.clear()
    return df


def ch2(df):
    # Se opera de forma automática los valores de DataFrame para dar una
    # gráfica en forma de barra
    df.plot.bar(rot=0)
    # Es una gráfica
    plt.xlabel("Numero de mesas")
    # Se guarda como "barras.png"
    plt.savefig("barras")

    # Se opera de forma automática los valores de DataFrame para dar una
    # gráfica en forma de lineas
    df.plot()
    # Es otra gráfica
    plt.xlabel("Numero de mesas")
    # Se guarda como "lineas.png"
    plt.savefig("lineas")

    plt.show()


def ch3(df):
    # Se escribe el archivo csv que guarda los datos de los candidatos
    f_w = open("DataFrame.csv", "w")
    # Este bucle va dedicado a las cabeceras
    for i in df.columns:
        f_w.write(i+', ')
    # Este bucle va dedicado al resto de valores para cada columna
    for i in range(3):
        f_w.write('\n')
        for j in range(5):
            # Este va insertando poco a poco los datos en forma de filas dentro
            # del DataFrame
            f_w.write(str(df.loc[i][j])+', ')
        f_w.write('mesa'+str(i+1))


def main():
    # Se llaman los operadores
    print(" - SUBRETO 1 -")
    df = ch1()
    print(df, "\n - SUBRETO 2 -")
    ch2(df)
    print(" - SUBRETO 3 -")
    ch3(df)


if __name__ == "__main__":
    main()
