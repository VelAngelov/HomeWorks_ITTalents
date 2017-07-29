package persons.classes;

public class Employee extends Person {
	private double daySalary;

	public Employee(String name, int age, boolean isMale, double daySalary) {
		super(name, age, isMale);
		this.daySalary = daySalary;
	}

	public double calculateOvertime(double hours) {
		if (super.age < 18) {
			return 0;
		} else {
			return this.daySalary * 1.5 * hours / 8;
		}
	}

	public String showEmployeeInfo() {
		StringBuilder info = new StringBuilder(super.showPersonInfo());
		info.append(String.format("Day salary: %.2f$%n", daySalary));
		return info.toString();
	}
}
