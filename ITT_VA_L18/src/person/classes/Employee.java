package person.classes;

public class Employee extends Person {
	private double daySalary;
	private Task currentTask;
	private int hoursLeft;
	private AllWork allwork;

	public Employee(String name) {
		super(name, 18, true);
	}

	public Employee(String name, int age, boolean isMale, double daySalary) {
		super(name, age, isMale);
		this.daySalary = daySalary;
	}

	public void work() {
		if (currentTask == null) {
			System.out.printf("%s rests.There is no more work... %n", super.name);
		} else if (currentTask.getWorkingHours() > 0) {
			System.out.printf("%s working on %s ,%d hours remaining to finish this work.%n", super.name,
					currentTask.getName(), currentTask.getWorkingHours());
			currentTask.setWorkingHours(currentTask.getWorkingHours() - 1);
		} else if (currentTask.getWorkingHours() == 0) {
			System.out.printf("~~%s finish with %s", super.name, this.currentTask.getName());
			this.currentTask = this.allwork.getNextTask();
			if (this.currentTask != null) {
				System.out.printf(", starting new work %s%n", this.currentTask.getName());
			}else {
				System.out.println();
			}
			work();
		}
	}

	public void startWorkingDay() {
		this.hoursLeft = 8;
	}

	public String getName() {
		return super.name;
	}

	public Task getCurrentTask() {
		return currentTask;
	}

	public void setCurrentTask(Task currentTask) {
		this.currentTask = currentTask;
	}

	public int getHoursLeft() {
		return hoursLeft;
	}

	public void setHoursLeft(int hoursLeft) {
		this.hoursLeft = hoursLeft;
	}

	public AllWork getAllwork() {
		return allwork;
	}

	public void setAllwork(AllWork allwork) {
		this.allwork = allwork;
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
