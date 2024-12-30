package situation_of_s;

public class StringFunctions {
  void repetition(String str, char chr) {
    int repetitionsAmount = 0, i;
    for (i = 0; i < str.length(); i++) {
      if (str.charAt(i) == chr) {
        repetitionsAmount++;
      }
    }
    System.out.println("La cantidad de repeticiones es: " + repetitionsAmount);
  }

  void vocalAndNumericAmount(String str) {
    int vocalAmount = 0, numberAmount = 0;
    String auxStr = str.toLowerCase();
    for (char car : auxStr.toCharArray()) {
      if (car == 'a' || car == 'e' || car == 'i' || car == 'o' || car == 'u') {
        vocalAmount++;
      }
      if (car == '1' || car == '2' || car == '3' || car == '4' || car == '5' ||
          car == '6' || car == '7' || car == '8' || car == '9' || car == '0') {
        numberAmount++;
      }
    }
    System.out.println("La cantidad de vocales es: " + vocalAmount);
    System.out.println("La cantidad de numeros es: " + numberAmount);
  }

  void invert(String cadena) {
    String invertedStr = "";
    for (int i = cadena.length() - 1; i >= 0; i--) {
      invertedStr += cadena.charAt(i);
    }
    System.out.println("La cadena invertida es: " + invertedStr);
  }
}
