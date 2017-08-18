package imigrants.classes;

import java.util.ArrayList;
import imigrants.classes.weapons.Weapon;

public abstract class Imigrant extends Being {
	private static int id;
	private String name = "Imigrant";
	protected Pasport pasport;
	protected double cash;
	protected ArrayList<Imigrant> friends;
	protected ArrayList<Weapon> weapons;
	protected boolean isLegal;
	protected boolean hasBomb;

	private Imigrant() {
		id++;
	}

	Imigrant(int cash, Town town) {
		this();
		this.cash = cash > 0 ? cash : 5000;
		super.town = Validator.isExisting(town) ? town : null;
		super.country = town == null ? null : town.getCountry();
		this.name += id;
		this.friends = new ArrayList<Imigrant>();
		this.weapons = new ArrayList<Weapon>();
	}

	// Imigrant may be without country and town!
	@Override
	void die() {
		System.out.printf("%s died\n", this.name);
		super.die();
	}

	public Town getTown() {
		return super.town;
	}

	public boolean isLegal() {
		return isLegal;
	}

	public void setHasBomb() {
		this.hasBomb = true;
	}

	public boolean hasBomb() {
		return hasBomb;
	}

	public String getName() {
		return this.name;
	}

	public void changeTown(Town town) {
		if (Validator.isExisting(town)) {
			this.town = town;
			this.country = town.getCountry();
		}
	}

	@Override
	void refreshDB() {
		if (!this.isAlive()) {
			for (Imigrant i : friends) {
				i.refreshDB();
			}
			super.town.refreshDB();
			super.country.refreshDB();
		}
		ArrayList<Imigrant> deadI = new ArrayList<Imigrant>();
		for (Imigrant i : friends) {
			if (!i.isAlive()) {
				deadI.add(i);
			}
		}
		if (deadI.size() != 0) {
			friends.removeAll(deadI);
		}
		if (town == null || !town.isAlive()) {
			this.town = null;
		}
		if (country == null || !country.isAlive()) {
			this.country = null;
		}
	}

	public boolean addFriend(Imigrant i) {
		if (Validator.isExisting(i)) {
			if (this.friends.size() == 0 || !this.friends.contains(i)) {
				this.friends.add(i);
				return true;
			}
		}
		return false;
	}

	public void suicide() {
		System.out.printf("%s:\"My life does not make sense\"\n", this.name);
		this.die();
	}

	protected void generateAutomaticPasport() {
		this.pasport = new Pasport(null, 0, null, null);
	}

	private void inviteFriendsInTown() {
		refreshDB();
		for (Imigrant i : friends) {
			i.tryToEnterInTown(this.town);
		}
	}

	public boolean tryToEnterInTown(Town town) {
		if (town != null && this.town != null && this.town.getName().equals(town.getName())) {
			return false;
		}
		boolean isIn = town.tryToEnterInTown(this);
		if (isIn) {
			System.out.printf("%s enter in town %s\n", this.name, this.town.getName());
			inviteFriendsInTown();
			return true;
		}
		return false;
	}

	public boolean tryToExitFromTown() {
		if (!Validator.isExisting(town)) {
			return true;
		}
		if (this.town.tryToExitFromTown(this)) {
			this.town.removeImigrant(this);
			this.town = null;
			System.out.printf("%s escaped successfully from the town!\n", this.name);
			return true;
		} else {
			System.out.printf("%s is shot by a policeman in an attempt to escape\n", this.name);
			this.die();
			return false;
		}

	}

	public void migrate(ArrayList<Town> towns) {
		if (!tryToEnterInTown(towns.get(Validator.rnd(0, towns.size())))) {
			migrate(towns);
		}
	}

	private void attackWithWeapon(Weapon w) {
		refreshDB();
		if (w.isBomb()) {
			int shoots = w.shoot();
			this.weapons.remove(w);
			System.out.printf("%s made bomb attack in %s\n", this.name, this.town.getName());
			this.town.shootPeoples(shoots);
			this.die();
			return;
		} else {
			System.out.printf("%s made terrorist attack with %s in %s\n", this.name, w.getType(), this.town.getName());
			int shoots = w.shoot();
			this.town.shootPeoples(shoots);
			this.tryToExitFromTown();
		}
	}

	public boolean buyWeapon(Weapon w) {
		if (w != null && this.cash >= w.getCost()) {
			this.weapons.add(w);
			cash -= w.getCost();
			return true;
		}
		return false;
	}

	private boolean tryAttack() {
		if (Validator.isExisting(this) && !this.weapons.isEmpty()) {
			Weapon weapon = null;
			if (this.hasBomb()) {
				for (Weapon w : weapons) {
					if (w.isBomb()) {
						weapon = w;
						break;
					}
				}
			} else {
				weapon = this.weapons.get(Validator.rnd(0, weapons.size()));
			}
			if (weapon != null) {
				this.attackWithWeapon(weapon);
				return true;
			}
			return false;
		}
		return false;
	}

	public void attack() {
		if (!tryAttack()) {
			this.suicide();
		}
		refreshDB();
	}

	@Override
	public String toString() {
		refreshDB();
		StringBuilder sb = new StringBuilder();
		sb.append(String.format("%s cash:%.2f  town:%s\nfriends:", this.name, this.cash, this.town.getName()));
		if (this.friends != null && !this.friends.isEmpty()) {
			for (Imigrant i : friends) {
				sb.append(String.format("\t%s\n", i.getName()));
			}
		}
		return sb.toString();
	}

}
