package program2;

public class TestCompareNumber {
  private int A, B, C;
  private InputNumber reader;
  private ProcessCompareNumber printThem;
  TestCompareNumber() {
    reader = new InputNumber();
    printThem = new ProcessCompareNumber();
    loadData();
    printThem.compareTheNumbers(A, B, C);
  }
  void loadData() {
    A = reader.insert("Number 1:");
    B = reader.insert("Number 2:");
    C = reader.insert("Number 3:");
    reader.scannerDies();
  }
}
