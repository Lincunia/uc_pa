import numpy as np


# Inserta L-1 ceros entre cada muestra (zero-stuffing).
def interpolacion_ceros(x, L):
    N = len(x)
    y = np.zeros(N * L, dtype=x.dtype)
    y[::L] = x
    return y


# Retención de muestras (zero-order hold): repite cada muestra L veces.
def interpolacion_retencion(x, L):
    y = np.repeat(x, L)
    return y


# Interpolación lineal entre muestras consecutivas.
def interpolacion_lineal(x, L):
    N = len(x)
    y_len = N * L
    y = np.zeros(y_len)
    for i in range(y_len):
        # Índice en la señal original (parte entera)
        idx = i // L
        frac = (i % L) / L   # fracción entre 0 y 1 (excluyendo 1)
        if idx < N - 1:
            y[i] = (1 - frac) * x[idx] + frac * x[idx + 1]
        else:
            # Último segmento: repetir el último valor
            y[i] = x[-1]
    return y
