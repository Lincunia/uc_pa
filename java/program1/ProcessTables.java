package program1;

public class ProcessTables {
  private int r;
  private Print imp;
  private InputData lea;
  ProcessTables(int P, int Q, int M, int N) {
    lea = new InputData();
    imp = new Print();
    for (int i = P; i <= Q; i++) {
      lea.siga("Oprima Enter para continuar ...");
      for (int j = M; j <= N; j++) {
        r = i * j;
        imp.printIt(i, j, r);
      }
    }
    imp.printIt("Fin tablas");
    ;
  }
}
