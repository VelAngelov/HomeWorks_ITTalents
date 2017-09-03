package imigrants.lib;

import java.util.ArrayList;
import java.util.Random;

import imigrants.lib.exc.NoMoreCitizensException;

/*
 * Градовете имат следните характеристики:
• Име
• Списък с полицейски служители.
• Брой жители (което включва всички, които населяват определен град).
• Списък с имигранти.
 */
public class Town {
	private String name;
	private ArrayList<Policemans> policemans;
	private int numberOfCitizens;
	private Country country;
	
	public Town(String name, int numberOfCitizens, Country country) {
		this.name = name;
		this.policemans = new ArrayList<>();
		this.numberOfCitizens = numberOfCitizens;
		this.country = country;
		country.registerTown(this);
	}
	
	public void addPolicemans(Policemans policeman) {
		this.policemans.add(policeman);
	}
	
	void dieFromBombAttack() {
		this.country.removeTown(this);
	}

	public Country getCountry() {
		return this.country;
	}

	public Policemans getRndPoliceman() {
		return this.policemans.get(new Random().nextInt(policemans.size()));
	}

	public void removeCitizens(int i) {
		if(i>this.numberOfCitizens) {
			throw new NoMoreCitizensException();
		}
		this.numberOfCitizens -= i;
	}

	public String getName() {
		return name;
	}
	
}
