package sam;

import java.util.Scanner;

public class Q1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner scanner = new Scanner(System.in);

		System.out.println("Enter the first number: ");
		double num1 = scanner.nextDouble();

		System.out.println("Enter the second number: ");
		double num2 = scanner.nextDouble();

		System.out.println("Enter the third number: ");
		double num3 = scanner.nextDouble();

		double smallest = findSmallest(num1, num2, num3);
		double largest = findLargest(num1, num2, num3);
		double average = calculateAverage(num1, num2, num3);

		System.out.println("Smallest number: " + smallest);
		System.out.println("Largest number: " + largest);
		System.out.println("Average: " + average);

		scanner.close();
	}

	public static double findSmallest(double a, double b, double c) {
		return Math.min(Math.min(a, b), c);
	}

	public static double findLargest(double a, double b, double c) {
		return Math.max(Math.max(a, b), c);
	}

	public static double calculateAverage(double a, double b, double c) {
		return (a + b + c) / 3.0;
	}
}
