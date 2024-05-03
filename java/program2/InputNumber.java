package program2;
import java.util.Scanner;

public class InputNumber {
  private Scanner getInto;
  private Print prt;
  InputNumber() {
    getInto = new Scanner(System.in);
    prt = new Print();
  }
  int insert(String etiqueta) {
    prt.printIt(etiqueta);
    return getInto.nextInt();
  }
  void scannerDies() { getInto.close(); }
}
