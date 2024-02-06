package option1;

public class StudentsData {
  protected double marks[] = new double[3];
  protected String name;
  protected String testsNames[] = {"Test 1", "Test 2", "Test 3"};
  StudentsData(double init[], String name) {
    for (int i = 0; i < 3; i++) {
      marks[i] = init[i];
    }
    this.name = name;
  }
}
