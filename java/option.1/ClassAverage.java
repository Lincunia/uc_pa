package option1;

public class ClassAverage {
	ClassAverage(double average, double averageMax, double sum, double marks[][], int averageIndex, int i, int j, String students[]){
		// Calcular promedio de estudiantes
		for(i=0;i<5;i++) {
			sum=0; average=0;
			for(j=0;j<3;j++) {
				sum += marks[i][j];
			}
			average = sum/j;
			// Calcular promedio máximo y su respectivo índice
			verify(average, averageMax, averageIndex, i);
		}
	}
	void verify(double average, double averageMax, int averageIndex, int i) {
		if (average > averageMax) {
			averageIndex = i;
			averageMax = average;
		}
	}
	void printThem(String students[], int averageIndex, double averageMax, double marks[][], int i) {
		// Imprimir resultados de estudiante con promedio máxino
		System.out.println("MáxPromEst: "+ students[averageIndex]+" = "+ averageMax);
		System.out.print("Notas: ");
		for (i=0; i<3; i++) {
			System.out.print(marks[averageIndex][i]+ " ");
		}
	}
}
