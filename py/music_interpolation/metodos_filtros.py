import numpy as np


# Diseña un filtro FIR pasa-bajo con ganancia unitaria en DC.
# corte_normalizado: frecuencia de corte en ciclos/muestra (0 a 0.5)
def disenar_filtro_pb(corte_normalizado, num_taps=101):
    if num_taps % 2 == 0:
        num_taps += 1
    M = num_taps // 2
    n = np.arange(-M, M+1)
    # Respuesta al impulso ideal (sinc)
    h_ideal = 2 * corte_normalizado * np.sinc(2 * corte_normalizado * n)
    # Ventana de Hamming
    ventana = np.hamming(num_taps)
    h = h_ideal * ventana
    # Normalizar para ganancia unitaria en DC
    h = h / np.sum(h)
    return h


# Filtra la señal mediante convolución y mantiene la longitud original.
def aplicar_filtro(senal, coeficientes, ganancia=1.0):
    filtrada = np.convolve(senal, coeficientes, mode='same')
    return filtrada * ganancia
