package program1;

public class ProcessTables {
  private int r;
  private Print imp;
  private InputData lea;
  public ProcessTables() {
    lea = new InputData();
    imp = new Print();
  }
  public void printTable(int P, int Q, int M, int N) {
    for (int i = P; i <= Q; i++) {
      lea.siga("Press ENTER to continue...");
      for (int j = M; j <= N; j++) {
        r = i * j;
        imp.printIt(i, j, r);
      }
    }
    imp.printIt("Fin tablas");
  }
}
