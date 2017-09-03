package imoti.classes;

public abstract class Entity {
	protected String name;
	protected String telNumber;
	protected double cash;

	Entity(String telNumber) {
		if (telNumber != null && telNumber.startsWith("08") && telNumber.length() == 10
				&& telNumber.replaceAll("[0-9]", "").isEmpty()) {
			this.telNumber = telNumber;
		} else {
			this.telNumber = Validator.generateTelNumber();
		}
	}

	public String getName() {
		return name;
	}

	public String getTelNumber() {
		return telNumber;
	}

	void addCesh(double cash) {
		this.cash += cash;
	}

	public double getCash() {
		return cash;
	}
}
