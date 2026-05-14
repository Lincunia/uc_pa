# This programs was the inspiration from the comments of this video:
#   https://www.youtube.com/watch?v=vsjJhW0FEHE
from cryptography.hazmat.primitives.ciphers import Cipher
from cryptography.hazmat.primitives.ciphers.algorithms import AES
from cryptography.hazmat.primitives.ciphers.modes import ECB
from base64 import b64decode

# The 'ciphertext' variable is the video title and the 'key' variable comes
# from the description video
key = 'letsalllovelain!'
ciphertext = '7L4XY0NTJ1kbGXygOCkXqyJRbaQoXZgl3t9y+o+HRyzJbOMCkNkjokAj9NqwtUwp'

enc_key = key.encode()
aes_ecb_cipher = Cipher(AES(enc_key), ECB())
output_text = aes_ecb_cipher.decryptor().update(b64decode(ciphertext))
print(output_text.decode())
