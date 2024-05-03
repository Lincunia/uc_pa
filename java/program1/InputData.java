package program1;
import java.util.Scanner;

public class InputData {
  private Scanner reader = new Scanner(System.in);
  private Print imp = new Print();
  int getInto(String etiqueta) {
    imp.printIt(etiqueta);
    return reader.nextInt();
  }
  void siga(String etiqueta) {
    imp.printIt(etiqueta);
    reader.nextLine();
  }
}
