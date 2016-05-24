package payRollSystem;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

public class PayrollMain {

	public static void main(String[] args) throws FileNotFoundException {

		Scanner sc = new Scanner(System.in);
		PayrollSystem payRollSystem = new PayrollSystem();
		PrintWriter textFile = new PrintWriter("payRollSystem.txt");

		boolean notDone = true;

		while (notDone) {
			System.out.println();
			System.out.println();
			System.out.println("        ");
			System.out.println();
			System.out.println("OPTIONS - Choose a number 1-6:");
			System.out.println("1 to Add an employee");
			System.out.println("2 to Edit details of an employee");
			System.out.println("3 to Delete an employee");
			System.out.println("4 to Display employee information");
			System.out.println("5 to Print a Pay Roll for an employee");
			System.out.println("6 to Exit");

			// options to choose from
			int mainChoice = sc.nextInt();

			// Option 1: Add an employee.
			if (mainChoice == 1) {
				payRollSystem.addEmployee(sc);
				System.out.println("Employee added.");

			}

			// Option 2:Edit employee information.
			else if (mainChoice == 2) {
				payRollSystem.editEmployee(sc);

			}

			// Option 3:Delete an employee.
			else if (mainChoice == 3) {
				payRollSystem.deleteEmployee(sc);

			}

			// Option 4: Display employee information.
			else if (mainChoice == 4) {
				payRollSystem.displayEmployeeInformation(sc);
			}

			// Option 5: Print a Pay Roll for an employee.
			else if (mainChoice == 5) {
				payRollSystem.getPayRoll(sc);
			}

			// Option 6: EXIT.
			else if (mainChoice == 6) {
				System.out.println("Transaction complete. Goodbye.");
				notDone = false;
				break;
			}
			// returns to options if users enter a number other than 1-5.
			else {
				System.out
						.println("INVALID option, please choose a number 1-5.");
			}

		}

		// Prints information to the text file
		for (int i = 0; i < payRollSystem.allEmployees.size(); i++) {
			Employee e = payRollSystem.allEmployees.get(i);
			textFile.println("Employee name: " + e.getName());
			textFile.println("Social Security Number: ***-**-"
					+ e.getSsn().substring(7, e.getSsn().length()));
			textFile.println("Address:" + e.getAddress());
			textFile.println("Marital Status:" + e.getMaritalStatus());
			textFile.println("Hourly pay rate: " + e.getRate());

		}
		textFile.close();
	}
}
