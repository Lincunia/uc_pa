package situation_of_s;
import java.util.Scanner;

public class InputString {
  private Scanner sc;

  InputString() { sc = new Scanner(System.in); }

  String insertString() {
    System.out.println("Ingrese la cadena:");
    return sc.nextLine();
  }

  char insertChar(String str) {
    System.out.println(str);
    char c = sc.nextLine().charAt(0);
    return c;
  }

  void scannerDies() { sc.close(); }
}
