package option1;

public class ClassAverage {
  ClassAverage(StudentsData[] someStudents, double average, double averageMax,
               int averageIndex, int i, int j) {
    for (i = 0; i < 5; i++) {
      average = 0;
      for (j = 0; j < 3; j++) {
        average += someStudents[i].marks[j];
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
    System.out.println("The greatest mark of the student: " +
                       someStudents[averageIndex].name + " = " + averageMax);
    for (i = 1; i <= 3; i++) {
      System.out.println("Mark " + i + ": " +
                         someStudents[averageIndex].marks[i - 1]);
    }
  }
}
