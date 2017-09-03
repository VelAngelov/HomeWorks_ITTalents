package bank.classes;

public abstract class LegalEntity {
	private static int id;
	protected String name;
	protected String adress;
	protected double cash;

	private LegalEntity() {
		id++;
	}

	LegalEntity(String name, String adress, double cash) {
		this();
		this.name = Validator.isValidString(name) ? name : "Name" + id;
		this.adress = Validator.isValidString(adress) ? adress : ("gr.Sofiq N" + id);
		this.cash = cash >= 0 ? cash : 0;
	}

	public String getName() {
		return name;
	}

	public String getAdress() {
		return adress;
	}

	public double getCash() {
		return cash;
	}
}
