package program1;

// WTF my Sir was doing?
public class Print {
  private String label;
  void printIt(String miLabel) {
    label = miLabel.toString();
    printThemAll(label);
  }
  void printIt(String miLabel, int x) {
    label = (miLabel + x).toString();
    printThemAll(label);
  }
  void printIt(int x, int y, int z) {
    label = (x + "*" + y + "=" + z).toString();
    printThemAll(label);
  }
  void printThemAll(String labelcito) { System.out.println(label); }
}
