package imigrants.classes;

import java.util.ArrayList;

public class Country extends NotABeing {
	private static int serialN;
	private ArrayList<Town> towns;

	private Country() {
		serialN++;
	}

	public Country(String name) {
		this();
		if (Validator.isValidString(name)) {
			super.name = name;
		} else {
			super.name = "Country" + serialN;
		}
		towns = new ArrayList<Town>();
	}

	public boolean addTown(Town t) {
		if (Validator.isExisting(t) && !towns.contains(t)) {
			towns.add(t);
			return true;
		}
		return false;
	}

	public void addTown(Town... towns) {
		for (Town t : towns) {
			this.addTown(t);
		}
	}

	public void generateTowns(int numberTowns, double pPolicemans) {
		numberTowns = numberTowns > 0 ? numberTowns : 0;
		pPolicemans = pPolicemans > 0.001 ? pPolicemans : 0.001;
		for (int i = 0; i < numberTowns; i++) {
			new Town(null, this, -1, pPolicemans);
		}
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append(String.format("====Country:%s\n\tTowns:\n", this.name));
		if (towns != null && !towns.isEmpty()) {
			for (int i = 0; i < this.towns.size(); i++) {
				sb.append("\t" + this.towns.get(i).toString());
			}
		}
		return sb.toString();
	}

	@Override
	void refreshDB() {
		for (Town t : towns) {
			if (!t.isAlive()) {
				towns.remove(t);
			}
		}
	}

	public ArrayList<Town> towns() {
		return towns;
	}
}
