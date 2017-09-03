package imigrants.lib;

import java.util.ArrayList;
import java.util.Random;

/*
 * Държавите има следните характеристики:
• Име.
• Списък с градове в тази държава
 */
public class Country {
	private String name;
	private ArrayList<Town> towns;
	
	
	public Country(String name) {
		super();
		this.name = name;
		this.towns = new ArrayList<>();
	}

	void registerTown(Town town) {
		this.towns.add(town);
	}

	void removeTown(Town town) {
		this.towns.remove(town);
	}

	public Town getRndTownToMigrateIn() {
		return towns.get(new Random().nextInt(towns.size()));
	}

}
