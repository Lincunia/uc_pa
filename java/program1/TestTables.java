package program1;

public class TestTables {
  private int P, Q, M, N;
  private InputData reader;
  private ProcessTables printThem;
  TestTables() {
    carganumbers();
    printThem = new ProcessTables(P, Q, M, N);
  }
  void carganumbers() {
    reader = new InputData();
    P = reader.getInto("Initial multiplicand:");
    Q = reader.getInto("Final multiplicand);
    N = reader.getInto("Final multiplier");
    M = reader.getInto("Initial multiplier");
    reader.scannerDies();
  }
}
