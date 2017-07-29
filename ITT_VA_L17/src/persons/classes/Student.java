package persons.classes;

public class Student extends Person {
	private double score = 2d;

	public Student(String name, int age, boolean isMale, double score) {
		super(name, age, isMale);
		if (score >= 2 && score <= 6) {
			this.score = score;
		}
	}

	public String showStudentInfo() {
		StringBuilder info = new StringBuilder(super.showPersonInfo());
		info.append(String.format("Last mark: %.2f%n", score));
		return info.toString();
	}
}
