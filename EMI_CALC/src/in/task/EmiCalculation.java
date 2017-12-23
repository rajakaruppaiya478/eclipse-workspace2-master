package in.task;

public class EmiCalculation {
	double interestAmount = 0;

	public void loanTable(double loanAmount, int tenure, double interest) {
		double interestMonthly = 0;
		double ref_calc = Math.pow((1 + ((interest / 100) / 12)), tenure);
		double equatedAmount = 0;
		double principalMonthly = 0;
		double totalInterest = 0;

		System.out.println(
				"\n\n\ncolumn 1 : Month\ncolumn 2 : Balance Amount\ncolumn 3 : EMI\ncolumn 4 : Interest ( Month wise )\ncolumn 5 : principal ( Monthly )\n");

		if (interest != 0) {

			equatedAmount = (loanAmount * (interest / (12 * 100)) * ref_calc) / (ref_calc - 1);

		} else {

			equatedAmount = loanAmount / tenure;

		}

		for (int i = 1; i <= tenure; i++) {

			interestMonthly = (loanAmount * (interest / 100)) / 12;
			principalMonthly = equatedAmount - interestMonthly;
			loanAmount = loanAmount - principalMonthly;
			totalInterest = totalInterest + interestMonthly;
			if (i != tenure) {
				System.out.println(i + " \t " + loanAmount + " \t " + equatedAmount + " \t " + interestMonthly + " \t "
						+ principalMonthly);
			} else {
				loanAmount = 0;
				System.out.println(i + " \t          " + loanAmount + "    \t " + equatedAmount + " \t "
						+ interestMonthly + " \t " + principalMonthly);
			}
		}
		System.out.println("\n\n\nTotal interest you have to pay : " + totalInterest + "\n\n\n\n");

	}

}
