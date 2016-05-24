package payRollSystem;

import java.sql.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;


public class PayrollTransactions {

	Employee e;
	double hoursWorked;
	TaxCalculator taxCalculator;
	Date date;
	DateFormat dateFormat;
	
	
	public PayrollTransactions(Employee e, double hoursWorked){
		this.e = e;
		this.hoursWorked = hoursWorked;
		taxCalculator = new TaxCalculator(e, hoursWorked);
		dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		date= new Date(0);
		
	}
	
	
	//Prints payroll of individual employee
	public  String toString(){
		Calendar cal = Calendar.getInstance();
		return "\n_____________________________________" +
				"\nName: "  +e.getName() + 
				"\n------------------------------------" +
				"\nLast 4 digits of Social Security: " + 
				e.getSsn().substring(7, e.getSsn().length())+ 
				"\n------------------------------------" +
				"\nDate: " + dateFormat.format(cal.getTime()) +
				"\n------------------------------------" +
				"\nHours worked: " + hoursWorked +
				"\n------------------------------------" +
				"\nNet Pay: $" + String.format("%.2f", taxCalculator.getNetPay()) +
				"\n------------------------------------" +
				"\nGross Pay: $" + String.format("%.2f", taxCalculator.getGrossPay()) +
				"\n------------------------------------" +
				"\n\nDeductions---------" +
				"\nIncome Tax: $" + String.format("%.2f", taxCalculator.getIncomeTax()) +
				"\nFederal Tax: $" + String.format("%.2f", taxCalculator.getFederalTax()) +
				"\nFICA: $" + String.format("%.2f", taxCalculator.getFicaTax()) +
				"\nMedicare: $" + String.format("%.2f", taxCalculator.getMedicareTax()) +
				"\nState Tax: $" + String.format("%.2f", taxCalculator.getStateTax()) +
				"\n_______________________________________";
	}

	
}
