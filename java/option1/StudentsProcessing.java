package option1;

public class StudentsProcessing {
  protected double marks[][] = {{3.5, 3.6, 4.2},
                                {4.2, 4.0, 3.5},
                                {1.5, 1.8, 4.0},
                                {1.8, 2.5, 3.8},
                                {2.5, 3.0, 3.2}},
                   average, averageMax;
  private StudentsData[] someStudents;
  protected int i, j, averageIndex;
  StudentsProcessing() {
    someStudents = new StudentsData[5];
    someStudents[0] = new StudentsData(marks[0], "George");
    someStudents[1] = new StudentsData(marks[1], "Martin");
    someStudents[2] = new StudentsData(marks[2], "Antonio");
    someStudents[3] = new StudentsData(marks[3], "Javier");
    someStudents[4] = new StudentsData(marks[4], "Farian");
    new ClassAverage(someStudents, average, averageMax, averageIndex, i, j);
    new TestsAverage(someStudents, average, averageMax, averageIndex, i, j);
  }
}
