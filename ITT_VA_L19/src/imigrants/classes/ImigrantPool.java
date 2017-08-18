package imigrants.classes;

import java.util.ArrayList;

import imigrants.classes.weapons.WeaponShop;

public class ImigrantPool {
	private ArrayList<Imigrant> imigrants;

	public ImigrantPool(int numberImigrants, int pNormal, int pRadicalist, int pExtremist, WeaponShop shop) {
		int totalP = pNormal + pRadicalist + pExtremist;
		this.imigrants = new ArrayList<Imigrant>();
		numberImigrants = numberImigrants > 0 ? numberImigrants : 100;
		int chance;
		for (int i = 0; i < numberImigrants; i++) {
			chance = Validator.rnd(0, totalP);
			if (chance < pNormal) {
				imigrants.add(new NormalIm(Validator.rnd(1000, 10000), null));
			} else if (chance < pNormal + pRadicalist) {
				imigrants.add(new RadicalIm(Validator.rnd(1000, 10000), null, 0.5));
			} else {
				imigrants.add(new ExtremistIm(Validator.rnd(1000, 10000), null));
			}
		}
		makeRelations(2);
		buyWeapons(shop, 5);
	}

	private void makeRelations(int numberFriends) {
		numberFriends = numberFriends > 0 ? numberFriends : 0;
		for (int i = 0; i < imigrants.size(); i++) {
			for (int j = 0; j < numberFriends; j++) {
				imigrants.get(i).addFriend(imigrants.get(generateFriend(i)));
			}
		}
	}

	private int generateFriend(int n) {
		int index = Validator.rnd(0, imigrants.size());
		if (index == n) {
			return generateFriend(index);
		}
		return index;
	}

	private void buyWeapons(WeaponShop shop, int attempts) {
		for (Imigrant i : imigrants) {
			shop.tryToBuyWeapon(i, attempts);
		}
	}

	public void startMigration(ArrayList<Town> towns) {
		ArrayList<Imigrant> deadI = new ArrayList<Imigrant>();
		for (Imigrant i : imigrants) {
			if (Validator.isExisting(i)) {
				i.migrate(towns);
			} else {
				deadI.add(i);
			}
		}
		if (deadI.size() != 0) {
			imigrants.removeAll(deadI);
		}
	}

	public void makeAttacks(int attaks) {
		attaks = attaks < imigrants.size() ? attaks : 0;
		Imigrant im;
		for (int i = 0; i < attaks; i++) {
			im = imigrants.get(Validator.rnd(0, imigrants.size()));
			if (Validator.isExisting(im) && im.getTown() != null) {
				im.attack();
			}
		}
	}

}
