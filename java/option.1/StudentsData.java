package option1;

public class StudentsData {
	private double marks[][] = {{3.5, 3.6, 4.2},
			{4.2, 4.0, 3.5},
			{1.5, 1.8, 4.0},
			{1.8, 2.5, 3.8},
			{2.5, 3.0, 3.2}},
			sum,
			average=0,
			averageMax=0;
	private int i, j, averageIndex=0;
	private String students [] = {"estud1", "estud2", "estud3", "estud4", "Estud5"},
	tests [] = {"parc1", "parc2", "parc3"};
	private ClassAverage crying;
	private TestsAverage changing;
	StudentsData(){
		crying = new ClassAverage(average, averageMax, sum, marks, averageIndex, i, j, students);
		crying.printThem(students, averageIndex, averageMax, marks, averageIndex);
		changing = new TestsAverage();
		// Calcular promedio de parciales
		for(i=0;i<3;i++) {
			sum=0; average=0;
			for(j=0;j<3;j++) {
				sum += marks[i][j];
			}
			average = sum/j;
			// Calcular promedio máximo y su respectivo índice
			if (average > averageMax) {
				averageIndex = i;
				averageMax = average;
			}
		}
		//Imprimir resultados de parcial con mayor promedio
		
	}
}