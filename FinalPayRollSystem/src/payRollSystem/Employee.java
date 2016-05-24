package payRollSystem;

public class Employee implements Comparable<Employee> {

	private String name;
	private String ssn; // read as string because most format will be
						// [000-00-0000]

	private String address;
	private String maritalStatus;
	private double rate;
	private double hoursWorked;

	public Employee(String givenName, String givenSsn, String givenAddress,
			String givenMaritalStatus, double givenRate) {
		name = givenName;
		ssn = givenSsn;
		address = givenAddress;
		maritalStatus = givenMaritalStatus;
		rate = givenRate;
		hoursWorked = 0;

	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSsn() {
		return ssn;
	}

	public void setSsn(String ssn) {
		this.ssn = ssn;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getMaritalStatus() {
		return maritalStatus;
	}

	public void setMaritalStatus(String maritalStatus) {
		this.maritalStatus = maritalStatus;
	}

	public double getRate() {
		return rate;

	}

	public void setRate(double rate) {
		if (rate < 0) {
			rate = 0;
			System.out.println("rate cannot be below zero");
		}
		this.rate = rate;
	}

	public double getNetPay(double hoursWorked) {
		return hoursWorked * rate;
	}

	public double getHoursWorked() {
		return hoursWorked;
	}

	public void setHoursWorked(double hoursWorked) {
		this.hoursWorked = hoursWorked;
	}

	public int compareTo(Employee otherObject) {
		Employee other = (Employee) otherObject;
		return ssn.compareTo(other.ssn);
	}
}