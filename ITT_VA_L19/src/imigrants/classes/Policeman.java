package imigrants.classes;

public abstract class Policeman extends Being {
	private static int id;
	private String name;

	private Policeman() {
		id++;
	}

	public Policeman(String name, Town town) {
		this();
		this.name = Validator.isValidString(name) ? name : "Policeman" + id;
		super.town = Validator.isExisting(town) ? town : null;
		super.country = town.getCountry();
	}

	@Override
	public void die() {
		this.die();
		System.out.printf("%s dies in pain!\n", this.name);
	}

	@Override
	void refreshDB() {
	}

	protected boolean letImigrantGoIn(Imigrant i) {
		if (Validator.isExisting(i)) {
			if (!this.town.containsImigrant(i)) {
				// ako imigranta si e imal grad da izbqga ot nego.
				if (Validator.isExisting(i.getTown())) {
					i.getTown().removeImigrant(i);
				}
				this.town.addImigrant(i);
				i.changeTown(this.town);
			}
			return true;
		}
		return false;
	}

	// for override:
	public boolean checkImigrant(Imigrant i) {
		return i.isLegal() ? letImigrantGoIn(i) : false;
	}
}
