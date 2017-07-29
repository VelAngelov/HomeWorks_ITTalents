package court.classes.action_citizens;

import court.classes.Validation;
import court.classes.law_positions.Jurist;
import court.classes.law_positions.Loyer;
import court.classes.lists.JuristList;

public class Citizen extends HasLegalRights implements Accuser, Accused, Witness {
	protected String name;
	protected String adress;
	protected int age;

	public Citizen(String name, String adress, int age) {
		name = Validation.validateThreeNames(name);
		adress = Validation.validateString(adress);
		age = Validation.returnBiggerThanNumber(age, 18);
		this.name = name;
		this.adress = adress;
		this.age = age;
		super.loyers = new JuristList();
	}

	@Override
	public boolean equals(Object obj) {
		if (obj instanceof Citizen) {
			Citizen c = (Citizen) obj;
			boolean isEqual = this.name.equals(c.getName());
			isEqual = isEqual && this.adress == c.getAdress();
			isEqual = isEqual && this.age == c.getAge();
			return isEqual;
		}
		return false;
	}

	public String getName() {
		return name;
	}

	public String getAdress() {
		return adress;
	}

	public int getAge() {
		return age;
	}

	// From hasLegalRights class:
	public boolean addLoyer(Loyer l) {
		if (!super.loyers.add(l)) {
			System.out.printf("%s is already in the list of loyers!\n", l.getName());
			return false;
		}
		return false;
	}

	public void addLoyers(Loyer... loyers) {
		for (Loyer l : loyers) {
			addLoyer(l);
		}
	}

	public boolean hasJurist(Jurist j) {
		return super.loyers.contains(j);
	}

	@Override
	public boolean hasLoyer() {
		if (this.loyers == null || super.loyers.size() == 0) {
			return false;
		}
		return true;
	}

	public Jurist[] getLoyersWithoutRemove() {
		if (super.loyers == null || super.loyers.size() <= 0) {
			return null;
		}
		Jurist[] loyers = new Jurist[super.loyers.size()];
		int i = 0;
		for (Jurist j : super.loyers) {
			loyers[i++] = j;
		}
		return loyers;
	}

	public Loyer removeMyLoyer() {
		if (super.loyers != null || super.loyers.size() != 0) {
			return (Loyer) super.loyers.remove(0);
		}
		return null;
	}

	public boolean removeLoyer(Jurist loyer) {
		return super.loyers.remove((Jurist) loyer);
	}
}
