package payRollSystem;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class PayrollSystem {

	ArrayList<Employee> allEmployees;

	public PayrollSystem() {
		allEmployees = new ArrayList<Employee>();
	}

	public void addEmployee(Scanner sc) {
		while (sc.hasNextLine()) {
			System.out.println("Enter Name:");
			sc.nextLine();
			String name = sc.nextLine();
			String ssn = "";
			boolean correctFormat = false;
			while (!correctFormat) {
				System.out.println("Enter SNN[format 000-00-0000]:");
				ssn = sc.next();
				if (ssn.length() == 11) {
					correctFormat = true;

				} else {
					System.out.println("Incorrect Format. Try again.");
				}

			}
			System.out.println("Enter Address:");
			sc.nextLine();
			String address = sc.nextLine();
			String maritalStatus = "";
			correctFormat = false;
			while (!correctFormat) {
				System.out.println("Enter Marital Status [Married or Single]:");
				maritalStatus = sc.next().toLowerCase();
				if (maritalStatus.equals("single")
						|| maritalStatus.equals("married")) {
					correctFormat = true;

				} else {
					System.out.println("Incorrect Marital Status. Try again.");
				}
			}
			System.out.println("Rate:");
			double rate = sc.nextDouble();
			allEmployees.add(new Employee(name, ssn, address, maritalStatus,
					rate));
			break;
		}
		Collections.sort(allEmployees);

	}

	public void displayEmployeeInformation(Scanner sc) {
		while (sc.hasNextLine()) {
			System.out.println("Enter SSN[format 000-00-0000]: ");
			String ssn = sc.next();
			findEmployee(ssn);
			boolean isFound = found(ssn);
			if (!isFound) {
				System.out.println("Employee not found.");
				System.out.println("Would you like to re-enter SSN? [Yes or No]");
				String choice = sc.next();
				if (choice.toLowerCase().equals("yes")){
					continue;
				}
				else{
					break;
				}
			} else {
				Employee currentEmployee = findEmployee(ssn);
				System.out.println("Employee name: "
						+ currentEmployee.getName());
				System.out.println("Social Security Number: ***-**-"
						+ currentEmployee.getSsn().substring(7,
								currentEmployee.getSsn().length()));
				System.out.println("Address: " + currentEmployee.getAddress());
				System.out.println("Marital Status: "
						+ currentEmployee.getMaritalStatus());
				System.out.println("Hourly pay rate: "
						+ currentEmployee.getRate());
				break;
			}
		}
	}

	public void editEmployee(Scanner sc) {
		boolean finishedEditing = false;
		while (!finishedEditing) {
			System.out.println("Enter SSN[format 000-00-0000]: ");
			String ssn = sc.next();
			findEmployee(ssn);
			boolean isFound = found(ssn);
			if (!isFound) {
				System.out.println("Employee not found. ");
				System.out.println("Would you like to re-enter SSN? [Yes or No]");
				String choice = sc.next();
				if (choice.toLowerCase().equals("yes")){
					continue;
				}
				else{
					break;
				}
			}

			else {
				boolean notDone = true;
				while (notDone) {
					System.out.println("OPTIONS TO EDIT: Choose a number 1-5");
					System.out.println("1 - full name");
					System.out.println("2 - address");
					System.out.println("3 - marital status");
					System.out.println("4 - hourly pay rate ");
					System.out.println("5 - hours worked during week");
					System.out.println("6 - quit");

					int option = sc.nextInt();

					// Edit Full Name
					if (option == 1) {

						System.out.println("Editing full name:");
						System.out.println("Enter new name");
						sc.nextLine();
						String newName = sc.nextLine();
						Employee currentEmployee = findEmployee(ssn);
						String updatedName = currentEmployee.getName();
						currentEmployee.setName(newName);
						System.out.println("Name changed from " + updatedName
								+ ", your updated name is ["
								+ currentEmployee.getName() + "]");

					}

					// Edit Address
					else if (option == 2) {
						System.out.println("Editing address:");
						System.out.println("Enter new address");
						sc.nextLine();
						String newAddress = sc.nextLine();
						Employee currentEmployee = findEmployee(ssn);
						currentEmployee.setAddress(newAddress);
						String updatedAddress = currentEmployee.getAddress();
						System.out
								.println("Address changed, your updated address is ["
										+ updatedAddress + "]");

					}

					// Edit Marital Status
					else if (option == 3) {
						System.out.println("Editing Marital Status:");
						String maritalStatus = "";

						boolean correctFormat = false;
						while (!correctFormat) {
							System.out
									.println("Enter New Marital Status [Married or Single]:");
							maritalStatus = sc.next().toLowerCase();
							if (maritalStatus.equals("single")
									|| maritalStatus.equals("married")) {
								correctFormat = true;

							} else {
								System.out
										.println("Incorrect Marital Status. Try again.");
							}
						}

						Employee currentEmployee = findEmployee(ssn);
						currentEmployee.setMaritalStatus(maritalStatus);
						String updatedMS = currentEmployee.getMaritalStatus();
						System.out
								.println("Marital status changed, your updated marital status is ["
										+ updatedMS + "]");

					}

					// Edit hourly pay rate
					else if (option == 4) {
						System.out.println("Editing employee hourly pay rate:");
						System.out.println("Enter new hourly pay rate");
						double newPayrate = sc.nextDouble();
						Employee currentEmployee = findEmployee(ssn);
						currentEmployee.setRate(newPayrate);
						double updatedRate = currentEmployee.getRate();
						System.out
								.println("Hourly pay rate changed, your updated pay rate is [$"
										+ updatedRate + "]");

					}

					// Edit hours worked during week
					else if (option == 5) {
						System.out.println("Editing employee hours:");
						System.out.println("Enter hours");
						double hours = sc.nextDouble();
						Employee currentEmployee = findEmployee(ssn);
						currentEmployee.setHoursWorked(hours);
						double updatedHours = currentEmployee.getHoursWorked();
						System.out
								.println("Work hours changed, your updated hours is ["
										+ updatedHours + " Hrs]");

					}

					// Quit Editing
					else if (option == 6) {
						System.out.println("Editing complete.");
						finishedEditing = true;
						break;

					}

					// Checks if users enter a number that is NOT 1-6
					else {
						System.out
								.println("INVALID option, please choose a number 1-6.");
					}
				}

			}

		}
	}

	public void getPayRoll(Scanner sc) {
		while (sc.hasNextLine()) {
			System.out.println("Enter SSN[format 000-00-0000]: ");
			sc.nextLine();
			String ssn = sc.nextLine();
			System.out.print("What is the total numbers of hours worked?");
			double hoursWorked = sc.nextDouble();
			findEmployee(ssn);
			boolean isFound = found(ssn);
			if (!isFound) {
				System.out.println("Employee not found.");
				System.out.println("Would you like to re-enter SSN? [Yes or No]");
				String choice = sc.next();
				if (choice.toLowerCase().equals("yes")){
					continue;
				}
				else{
					break;
				}
			} else {
				Employee currentEmployee = findEmployee(ssn);
				System.out.println("Your Payslip.");
				PayrollTransactions payRollTransactions = new PayrollTransactions(
						currentEmployee, hoursWorked);
				System.out.println(payRollTransactions.toString());
			}
			System.out
					.println("Do you want to print another Playslip?(yes/no)");
			String choice = sc.next();
			if (!choice.toLowerCase().equals("yes")) {
				break;
			}
		}
	}

	public int getNumberMaritalStatus(Employee e) {
		if (e.getMaritalStatus().equals("single")) {
			int single = 1;
			return single;
		} else if (e.getMaritalStatus().equals("married")) {
			int married = 2;
			return married;
		} else {
			return 0;
		}
	}

	public boolean found(String ssn) {
		for (int i = 0; i < allEmployees.size(); i++) {
			Employee e = allEmployees.get(i);
			if (e.getSsn().equals(ssn)) {
				return true;
			}
		}
		return false;
	}

	public Employee findEmployee(String ssn) {
		for (int i = 0; i < allEmployees.size(); i++) {
			Employee e = allEmployees.get(i);
			if (e.getSsn().equals(ssn)) {
				return e;
			}
		}
		return null;
	}

	public void deleteEmployee(Scanner sc) {
		while (sc.hasNextLine()) {
			System.out.println("Enter SSN[format 000-00-0000]: ");
			String ssn = sc.next();
			Employee currentEmployee = findEmployee(ssn);
			boolean isFound = found(ssn);
			if (!isFound) {
				System.out.println("Employee not found.");
				System.out.println("Would you like to re-enter SSN? [Yes or No]");
				String choice = sc.next();
				if (choice.toLowerCase().equals("yes")){
					continue;
				}
				else{
					break;
				}
				
			} else {
				allEmployees.remove(currentEmployee);
				System.out.println("Employee removed.");
				break;

			}
			
		}

	}

}
