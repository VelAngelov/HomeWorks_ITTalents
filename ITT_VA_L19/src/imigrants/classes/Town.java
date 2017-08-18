package imigrants.classes;

import java.util.ArrayList;

public class Town extends NotABeing {
	private static int serialN;
	private ArrayList<Policeman> policemans;
	private int numberCitizens;
	private ArrayList<Imigrant> imigrants;
	private Country c;

	private Town() {
		serialN++;
	}

	public Town(String name, Country c, int numberOfCitizens, double pPolicemans) {
		this();
		this.policemans = new ArrayList<Policeman>();
		this.imigrants = new ArrayList<Imigrant>();
		if (Validator.isValidString(name)) {
			this.name = name;
		} else {
			this.name = "Town" + serialN;
		}
		if (Validator.isExisting(c)) {
			this.c = c;
			c.addTown(this);
		} else {
			this.die();
		}
		this.numberCitizens = numberOfCitizens > 0 ? numberOfCitizens : 10000;
		int policemans = (int) (pPolicemans * this.numberCitizens);
		policemans = policemans > 0 ? policemans : 10;
		int chance;
		for (int i = 0; i < policemans; i++) {
			chance = Validator.rnd(0, 100);
			if (chance < 70) {
				addPoliceman(new Cop(null, this));
			} else {
				addPoliceman(new Swat(null, this));
			}
		}
	}

	@Override
	void refreshDB() {
		if (!this.isAlive()) {
			return;
		}
		ArrayList<Policeman> dead = new ArrayList<Policeman>();
		if (policemans != null && !policemans.isEmpty()) {
			for (Policeman p : policemans) {
				if (!p.isAlive()) {
					dead.add(p);
				}
			}
			policemans.removeAll(dead);
		}

		ArrayList<Imigrant> deadI = new ArrayList<Imigrant>();
		if (imigrants != null && !imigrants.isEmpty()) {
			for (Imigrant i : imigrants) {
				if (!i.isAlive()) {
					deadI.add(i);
				}
			}
			imigrants.removeAll(deadI);
		}
	}

	public String getName() {
		return this.name;
	}

	@Override
	void die() {
		System.out.printf("Town:%s dies!\n", this.name);
		super.die();
	}

	private boolean addPoliceman(Policeman policeman) {
		refreshDB();
		if (Validator.isExisting(policeman) && !this.policemans.contains(policeman)) {
			this.policemans.add(policeman);
			return true;
		}
		return false;
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append(String.format("Town:%s \tCitizens:%d \tPolicemans:%d \tImigrants:%d\n", this.name,
				this.numberCitizens, this.policemans.size(), this.imigrants.size()));
		return sb.toString();
	}

	private Policeman getRndPoliceman() {
		refreshDB();
		if (this.policemans != null && !this.policemans.isEmpty()) {
			return this.policemans.get(Validator.rnd(0, this.policemans.size()));
		}
		System.out.printf("There are no policemen in the town %s and the town dies of disorder\n", super.name);
		this.die();
		return null;
	}

	public Country getCountry() {
		return this.c;
	}

	public int getNumberOfCitizens() {
		return this.numberCitizens;
	}

	public void seNumberOfCitizens(int numberOfCitizens) {
		if (numberOfCitizens <= 0) {
			this.numberCitizens = 0;
			refreshDB();
		} else {
			this.numberCitizens = numberOfCitizens;
		}
	}

	public boolean tryToEnterInTown(Imigrant i) {
		Policeman p = getRndPoliceman();
		return p.checkImigrant(i);
	}

	public boolean tryToExitFromTown(Imigrant i) {
		Policeman p = getRndPoliceman();
		return p.checkImigrant(i);
	}

	boolean addImigrant(Imigrant i) {
		if (Validator.isExisting(i) && !this.imigrants.contains(i)) {
			this.imigrants.add(i);
			return true;
		}
		return false;
	}

	boolean containsImigrant(Imigrant i) {
		return this.imigrants.contains(i);
	}

	boolean removeImigrant(Imigrant i) {
		return this.imigrants.remove(i);
	}

	// deistviq ot strana na emigranti
	public int shootPeoples(int shoots) {
		shoots = shoots > 0 ? shoots : 1;
		shoots = (int) (shoots * 0.7d);
		int chance;
		for (int i = 0; i < shoots; i++) {
			if (this.policemans.size() == 0) {
				System.out.printf("%s:%d civil people died,there is no policemans in this city!\n", this.name, i + 1);
				return i + 1;
			}
			chance = Validator.rnd(1, this.numberCitizens + this.policemans.size() + 1);
			if (chance <= numberCitizens) {
				this.numberCitizens--;
			} else {
				this.policemans.remove(0);
			}
		}
		System.out.printf("%s:%d civil people died!\n", this.name, shoots);
		return shoots;
	}

	@Override
	public boolean equals(Object obj) {
		if (obj instanceof Town) {
			return this.name.equals(((Town) obj).getName());
		}
		return false;
	}
}
