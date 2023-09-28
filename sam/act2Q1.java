package sam;

import java.util.Scanner;

public class act2Q1 {

	public static void main(String[] args) {

		try (Scanner scanner = new Scanner(System.in)) {
			System.out.print("Enter the number of subjects: ");
			int numSubjects = scanner.nextInt();
			System.out.print("Enter the number of students: ");
			int numStudents = scanner.nextInt();

			int[][] marks = new int[numStudents][numSubjects];

			for (int i = 0; i < numStudents; i++) {
				System.out.println("Enter marks for Student " + (i + 1) + ":");
				for (int j = 0; j < numSubjects; j++) {
					System.out.print("Subject " + (j + 1) + ": ");
					marks[i][j] = scanner.nextInt();
				}
			}

			System.out.println("\nMarks for the " + numStudents + " students\n");
			for (int i = 0; i < numStudents; i++) {
				System.out.print("|");
				for (int j = 0; j < numSubjects; j++) {
					System.out.print("-----|");
				}
				System.out.println();
				for (int j = 0; j < numSubjects; j++) {
					System.out.print("| " + marks[i][j] + "  ");
				}
				System.out.println("|");
			}
			System.out.print("|");
			for (int j = 0; j < numSubjects; j++) {
				System.out.print("-----|");
			}
		}

		System.out.println();
	}
}
