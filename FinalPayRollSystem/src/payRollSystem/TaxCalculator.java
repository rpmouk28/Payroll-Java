package payRollSystem;

public class TaxCalculator {

	// Constants necessary for calculating income tax;
	private int LOW_TAX_BRACKET = 12000;
	private int MEDIUM_TAX_BRACKET = 62000;
	private double RATE_LOW_TAX_BRACKET = 0.045;
	private double RATE_MEDIUM_TAX_BRACKET = 0.068;
	private double RATE_HIGH_TAX_BRACKET = 0.0898;

	// Constants necessary for calculating social security tax
	private double RATE_SOCIAL_SECURITY = 0.062;

	// Constants necessary for calculating medicare tax
	private double RATE_MEDICARE = 0.0145;

	// Constants necessary for calculating federal tax;
	private double LOW_SINGLE = 1506;
	private double MEDIUM_SINGLE = 15667;
	private double LOW_MARRIED = 3163;
	private double MEDIUM_MARRID = 15906;

	// Income tax
	private double incomeTax;

	// Federal Tax
	private double medicareTax;

	// FICA tax == Medicare + social Security
	private double stateTax;
	private double federalTax;
	private double ficaTax;

	private Employee e;
	private double hoursWorked;

	// Pay
	private double grossPay;
	private double netPay;

	public TaxCalculator(Employee e, double hoursWorked) {
		this.hoursWorked = hoursWorked;
		this.e = e;
		calculateGrossPay();
		calculateAllTaxes();
		calcualteNetPay();
	}

	private void calculateGrossPay() {
		grossPay = e.getRate() * hoursWorked;
	}

	private void calcualteNetPay() {
		netPay = grossPay - incomeTax - federalTax - ficaTax;
	}

	private void calculateAllTaxes() {
		calculateIncomeTax();
		calculateFICTax();
		String maritalStatus = e.getMaritalStatus();
		char ms = 'S'; // Default value.
		if (maritalStatus.toLowerCase().equals("married")) {
			ms = 'M';
		}
		calculateFederalTax(ms);
	}

	private void calculateIncomeTax() {

		if (grossPay <= LOW_TAX_BRACKET) {
			incomeTax = grossPay * RATE_LOW_TAX_BRACKET;
		} else if (grossPay <= MEDIUM_TAX_BRACKET) {
			incomeTax = grossPay * RATE_MEDIUM_TAX_BRACKET;
		} else {
			incomeTax = grossPay * RATE_HIGH_TAX_BRACKET;
		}
	}

	private void calculateFICTax() {
		stateTax = grossPay * RATE_SOCIAL_SECURITY;
		medicareTax = grossPay * RATE_MEDICARE;
		ficaTax = stateTax + medicareTax;
	}

	private void calculateFederalTax(char maritalStatus) {

		switch (maritalStatus) {
		case 'S':
			if (grossPay <= LOW_SINGLE) {
				federalTax = grossPay * .15 + 34.90;
			} else if (grossPay <= MEDIUM_SINGLE) {
				federalTax = grossPay * .33 + 1744.33;
			} else {
				federalTax = grossPay * .396 + 4543.02;
			}
			break;
		case 'M':
			if (grossPay <= LOW_MARRIED) {
				federalTax = grossPay * .15 + 69.80;
			} else if (grossPay <= MEDIUM_MARRID) {
				federalTax = grossPay * .33 + 1952.55;
			} else {
				federalTax = grossPay * .396 + 4921.68;
			}
			break;
		default:
			System.out.println("Incorrect marital status.");
			// System.out.println("System will now terminate.");
			// System.exit(0);
		}
	}

	public double getIncomeTax() {
		return incomeTax;
	}

	public double getFederalTax() {
		return federalTax;
	}

	public double getMedicareTax() {
		return medicareTax;
	}

	public double getStateTax() {
		return stateTax;
	}

	public double getFicaTax() {
		return ficaTax;
	}

	public double getGrossPay() {
		return grossPay;
	}

	public double getNetPay() {
		return netPay;
	}

}
