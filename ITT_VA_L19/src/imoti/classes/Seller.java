package imoti.classes;

public class Seller extends Client {
	private static int id;

	private Seller(String telNumber) {
		super(telNumber);
		id++;
	}

	public Seller(String name, String telNumber) {
		this(telNumber);
		super.name = Validator.validateString(name) ? name : ("Seller" + id);
	}

	public void generateProperty(int chanceApartament, int chanceHouse, int chancePlot) {
		int chances = chanceApartament + chanceHouse + chancePlot;
		int chance = Validator.rnd(0, chances + 1);
		if (chance < chanceApartament) {
			this.imot = new Apartament(null, 0, 0, null, null, this);
		} else if (chance < chanceApartament + chanceHouse) {
			this.imot = new House(null, 0, 0, null, null, 0, this);
		} else {
			this.imot = new Plot(null, 0, 0, null, this);
		}
	}

	public Property getImot() {
		return imot;
	}
}
