package tyrgovci.classes;

abstract class Entity {
	private static int id;
	private String name;
	private String adress;
	protected int cash;
	private String rabVreme;

	private Entity() {
		id++;
	}

	Entity(String adress) {
		this();
		this.adress = Validator.validateString(adress) ? adress : ("Sofiq, Studentski grad ul.Nezabravima N" + id);
	}

	public String getName() {
		return name;
	}

	public String getAdress() {
		return adress;
	}

	public int getCash() {
		return cash;
	}

	void setName(String name) {
		this.name = name;
	}

	void setCash(int cash) {
		this.cash = cash;
	}

	void setRabVreme(String rabVreme) {
		this.rabVreme = Validator.validateString(rabVreme) ? rabVreme : "8:00-22:00";
	}

	String getRabVreme() {
		return rabVreme;
	}

	void addCash(int cash) {
		this.cash += cash;
	}
}
