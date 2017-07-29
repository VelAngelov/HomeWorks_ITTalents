package persons.classes;

public class Person {
	protected String name = "Unknown";
	protected int age = 0;
	protected boolean isMale;

	public Person(String name, int age, boolean isMale) {
		if (name != null && !name.isEmpty()) {
			this.name = name;
		}
		if (age > 0 && age < 120) {
			this.age = age;
		}
		this.isMale = isMale;
	}

	public String showPersonInfo() {
		StringBuilder info = new StringBuilder();
		info.append(String.format("Name: %s%n", name));
		info.append(String.format("Age: %d%n", age));
		info.append(String.format("Gender: %s%n", isMale ? "Male" : "Female"));
		return info.toString();
	}
}
