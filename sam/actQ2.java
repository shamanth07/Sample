package sam;

public class actQ2 {

	public static void main(String[] args) {

		int[] marks = { 0, 5, 5, 7, 8, 7, 8, 9, 9, 6, 8, 6, 9, 7, 7, 9, 4, 7, 8, 8 };
		int[] frequency = new int[10];

		for (int mark : marks) {
			frequency[mark]++;
		}

		for (int i = 0; i < 10; i++) {
			System.out.print(i + " : ");
			for (int j = 0; j < frequency[i]; j++) {
				System.out.print("*");
			}
			System.out.println();
		}
	}
}
