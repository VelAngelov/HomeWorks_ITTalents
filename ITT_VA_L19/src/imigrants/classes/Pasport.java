package imigrants.classes;

public class Pasport {
	private static int id;
	private String name;
	private int age;
	private String homeTownString;
	private String homeCountryString;

	private Pasport() {
		id++;
	}

	public Pasport(String name, int age, String homeTownString, String homeCountryString) {
		this();
		this.name = Validator.isValidString(name) ? name : "Legal Imigrant" + id;
		this.age = (age > 18 && age < 100) ? age : 21;
		this.homeTownString = Validator.isValidString(homeTownString) ? homeTownString : "Town of terror";
		this.homeCountryString = Validator.isValidString(homeCountryString) ? homeCountryString : "Terrorland";
	}

	@Override
	public String toString() {
		return String.format("Name:%s\nAge:%d\nTown:%s\nCountry:%s\n", name, age, homeTownString, homeCountryString);
	}
}
