package sam;

import java.util.Scanner;

public class Q3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner scanner = new Scanner(System.in);

		System.out.print("Enter the initial deposit (e.g., $1000): ");
		double initialDeposit = scanner.nextDouble();

		System.out.print("Enter the annual percentage return (e.g., 5 for 5%): ");
		double annualPercentageReturn = scanner.nextDouble() / 100.0;

		System.out.print("Enter the number of years: ");
		int years = scanner.nextInt();

		double futureValue = calculateFutureValue(initialDeposit, annualPercentageReturn, years);
		System.out.printf("The future value of your investment after %d years will be $%.2f%n", years, futureValue);

		scanner.close();
	}

	public static double calculateFutureValue(double initialDeposit, double annualPercentageReturn, int years) {

		double futureValue = initialDeposit * Math.pow(1 + annualPercentageReturn, years);
		return futureValue;
	}

}
