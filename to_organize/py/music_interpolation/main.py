import numpy as np
import matplotlib.pyplot as plt
from pathlib import Path
import interpolacion_sin_filtros as not_i
import metodos_filtros as m_filtros
import metodos_archivo as m_archivos


# Cálculo de energía y potencia
def energia_potencia(senal):
    energia = np.sum(senal**2)
    potencia = energia / len(senal)
    return energia, potencia


# Genera gráfica comparativa de los espectros en frecuencia normalizada.
def graficar_espectros(original, raw, filtrada, fs_orig, fs_new, factor,
                       metodo, carpeta_salida):
    fft_orig = np.fft.rfft(original)
    mag_orig = np.abs(fft_orig)
    freq_orig = np.fft.rfftfreq(len(original), d=1/fs_orig)
    freq_norm_orig = freq_orig / (fs_orig/2)
    # Espectro de la señal interpolada (raw y filtrada) con nueva fs
    fft_raw = np.fft.rfft(raw)
    mag_raw = np.abs(fft_raw)
    fft_filt = np.fft.rfft(filtrada)
    mag_filt = np.abs(fft_filt)
    freq_new = np.fft.rfftfreq(len(raw), d=1/(fs_new))
    freq_norm_new = freq_new / (fs_new/2)

    plt.figure(figsize=(10, 6))
    # Espectro original: se plotea hasta Nyquist original, pero se debe superponer correctamente.
    # La señal original, después de interpolación, ocupa [0, 1/factor] en la nueva frecuencia normalizada.
    plt.plot(
            freq_norm_orig,
            20*np.log10(mag_orig+1e-10),
            label='Original',
            alpha=0.7)
    plt.plot(
            freq_norm_new,
            20*np.log10(mag_raw+1e-10),
            label='Interpolada (sin filtro)',
            alpha=0.7
            )
    plt.plot(
            freq_norm_new,
            20*np.log10(mag_filt+1e-10),
            label='Interpolada (filtrada)',
            alpha=0.7
            )
    plt.axvline(
            x=1.0/factor,
            color='r',
            linestyle='--',
            label=f'Frec. corte teórica (1/{factor})'
            )
    plt.xlabel('Frecuencia normalizada (Nyquist = 1)')
    plt.ylabel('Magnitud (dB)')
    plt.title(f'Comparación espectral - Método: {metodo}, Factor: {factor}')
    plt.legend()
    plt.grid(True, linestyle=':', alpha=0.6)
    plt.tight_layout()
    ruta_grafica = carpeta_salida / f'espectro_{metodo}_factor{factor}.png'
    plt.savefig(ruta_grafica, dpi=150)
    plt.close()


def usar_metodo(metodo_key, metodo_func, nombres_metodos, senal_orig,
                fs_orig, fs_nueva, factor, carpeta_salida):
    print(f'\n--- Método: {nombres_metodos[metodo_key]} ---')
    senal_raw = metodo_func(senal_orig, factor)
    filtro = m_filtros.disenar_filtro_pb(
            corte_normalizado=1.0/factor,
            num_taps=101
            )
    if metodo_key == 'zero_stuff':
        # Para zero-stuffing se necesita ganancia = factor para restaurar
        # amplitud
        ganancia = factor
    else:
        # Para retención y lineal la amplitud ya es correcta
        ganancia = 1.0
    senal_filtrada = m_filtros.aplicar_filtro(
            senal_raw,
            filtro,
            ganancia=ganancia
            )
    # 4. Calcular energía y potencia
    E_raw, P_raw = energia_potencia(senal_raw)
    E_filt, P_filt = energia_potencia(senal_filtrada)
    print(f'  Sin filtrar  -> Energía: {E_raw:.6f}, Potencia: {P_raw:.6f}')
    print(f'  Filtrada     -> Energía: {E_filt:.6f}, Potencia: {P_filt:.6f}')
    # 5. Guardar archivos de audio
    prefijo = f'{metodo_key}_factor{factor}'
    m_archivos.escribir_wav(
            carpeta_salida / f'{prefijo}_raw.wav',
            senal_raw, fs_nueva
            )
    m_archivos.escribir_wav(
            carpeta_salida / f'{prefijo}_filtrado.wav',
            senal_filtrada,
            fs_nueva
            )
    print(f'  Archivos guardados: {prefijo}_raw.wav y {prefijo}_filtrado.wav')
    # 6. Generar gráfica espectral
    graficar_espectros(senal_orig, senal_raw, senal_filtrada,
                       fs_orig, fs_nueva, factor,
                       metodo_key, carpeta_salida)


# Procesamiento principal
def procesar_interpolacion(ruta_entrada, carpeta_salida, factores=[2, 4]):
    carpeta_salida = Path(carpeta_salida)
    carpeta_salida.mkdir(parents=True, exist_ok=True)
    senal_orig, fs_orig = m_archivos.leer_wav(ruta_entrada)
    print(f'Señal original: {len(senal_orig)} muestras, {fs_orig} Hz')
    E_orig, P_orig = energia_potencia(senal_orig)
    print(f'''
	--- Señal original ---
Energía: {E_orig:.6f}, Potencia: {P_orig:.6f}
''')
    metodos = {
        'zero_stuff': not_i.interpolacion_ceros,
        'zero_order': not_i.interpolacion_retencion,
        'linear': not_i.interpolacion_lineal
    }
    nombres_metodos = {
        'zero_stuff': 'inserción de ceros',
        'zero_order': 'retención de muestras',
        'linear': 'lineal'
    }

    for factor in factores:
        print(f'\n{'='*50}')
        print(f'Factor de interpolación: {factor}')
        fs_nueva = fs_orig * factor
        for metodo_key, metodo_func in metodos.items():
            usar_metodo(metodo_key, metodo_func, nombres_metodos, senal_orig,
                        fs_orig, fs_nueva, factor, carpeta_salida)

    print('\nProcesamiento completado.')


if __name__ == '__main__':
    archivo = './mono.wav'
    carpeta_salida = './resultados_interpolacion'
    factores = [2, 4]
    procesar_interpolacion(archivo, carpeta_salida, factores)
