package option1;
public class TestsAverage {
  TestsAverage(StudentsData[] someStudents, double average, double averageMax,
               int averageIndex, int i, int j) {
    for (i = 0; i < 3; i++) {
      average = 0;
      for (j = 0; j < 5; j++) {
        average += someStudents[j].marks[i];
      }
      average /= j;
      if (average > averageMax) {
        averageIndex = i;
        averageMax = average;
      }
    }
    printThem(someStudents, averageMax, averageIndex, i);
  }
  void printThem(StudentsData[] someStudents, double averageMax,
                 int averageIndex, int i) {
    System.out.println("The maximum average of the tests: " +
                       someStudents[averageIndex].testsNames[averageIndex] +
                       " = " + averageMax);
    for (i = 1; i <= 5; i++) {
      System.out.println("Tests from the student " + i + ": " +
                         someStudents[i - 1].marks[averageIndex]);
    }
  }
}
