package in.task;

import java.util.Scanner;

public class EmiApp {

	public static void main(String[] args) {
		EmiCalculation emiCalculation = new EmiCalculation();
		System.out.println("Enter interest percentage :");
		Scanner scanner = new Scanner(System.in);
		double interest = scanner.nextDouble();
		System.out.println("Enter Loan Amount");
		double loanAmount = scanner.nextDouble();
		System.out.println("Enter tenure ( months )");
		int tenure = scanner.nextInt();
		emiCalculation.loanTable(loanAmount, tenure, interest);

	}

}
