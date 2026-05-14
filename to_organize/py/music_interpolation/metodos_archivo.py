import wave
import numpy as np
from pathlib import Path


def leer_wav(ruta_archivo):
    with wave.open(ruta_archivo, 'rb') as wf:
        canales = wf.getnchannels()
        if canales != 1:
            raise ValueError("El archivo debe ser monofónico.")
        samprate = wf.getframerate()
        n_frames = wf.getnframes()
        datos_bytes = wf.readframes(n_frames)
        # Convertir bytes a enteros (16 bits, little-endian)
        datos_int = np.frombuffer(datos_bytes, dtype=np.int16)
        datos_float = datos_int.astype(np.float64) / 32768.0
    return datos_float, samprate


# Guarda los datos (rango [-1,1]) como archivo WAV mono de 16 bits.
def escribir_wav(ruta_archivo, datos, tasa_muestreo):
    ruta_str = str(ruta_archivo)
    Path(ruta_str).parent.mkdir(parents=True, exist_ok=True)
    datos_int = np.clip(datos, -1.0, 1.0) * 32767
    datos_int = datos_int.astype(np.int16)
    with wave.open(ruta_str, 'wb') as wf:
        wf.setnchannels(1)
        wf.setsampwidth(2)  # 16 bits = 2 bytes
        wf.setframerate(tasa_muestreo)
        wf.writeframes(datos_int.tobytes())

