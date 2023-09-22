package option1;

public class TestsAverage extends ClassAverage{
	void printThem(String tests[], int averageIndex, double averageMax, double marks[][], int i) {
		System.out.println("\n\nMaxPromParc: "+ tests[averageIndex]+ "="+
				String.format("%.2f",averageMax));
		System.out.print("Notas: ");
		for (i=0; i<5; i++) {
			System.out.print(marks[i][averageIndex]+ " ");
		}
	}
}
