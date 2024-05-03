package situation_of_s;

public class Menu {
  private final StringFunctions functions;
  private final InputString getInto;
  private String str;
  private char chr, key;

  static void displayMenu() {
    System.out.println(
        "\n\t>>> MENU <<<\n"
        + "\na. Salir."
        + "\nb. Invertir cadena."
        + "\nc. Cantidad de vocales y de números de una cadena."
        + "\nd. Cantidad de veces que aparece una vocal en una cadena.\n");
  }

  final char ask() {
    key = getInto.insertChar("Inserte la opción:");
    if (key == 'a') {
      System.out.println("Gracias por usar el programa");
      return key;
    }
    str = getInto.insertString();
    switch (key) {
    case 'b':
      functions.invert(str);
      break;
    case 'c':
      functions.vocalAndNumericAmount(str);
      break;
    case 'd':
      chr = getInto.insertChar("Inserte el caracter a buscar:");
      functions.repetition(str, chr);
      break;
    default:
      System.out.println("Esa opción no se encuentra en el menú");
      break;
    }
    return key;
  }

  Menu() {
    functions = new StringFunctions();
    getInto = new InputString();
    do {
      displayMenu();
      key = ask();
    } while (key != 'a');
    getInto.scannerDies();
  }
}
