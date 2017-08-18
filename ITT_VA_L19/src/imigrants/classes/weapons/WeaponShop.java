package imigrants.classes.weapons;

import java.util.ArrayList;

import imigrants.classes.Imigrant;
import imigrants.classes.Validator;

public class WeaponShop {
	private ArrayList<Weapon> weapons;

	public WeaponShop(int numberOfWeapons, int pGun, int pAutomat, int pBomb) {
		weapons = new ArrayList<Weapon>();
		int totalP = pGun + pAutomat + pBomb;
		numberOfWeapons = numberOfWeapons >= 0 ? numberOfWeapons : 0;
		for (int i = 0; i < numberOfWeapons; i++) {
			int chance = Validator.rnd(0, totalP + 1);
			if (chance < pGun) {
				weapons.add(new Gun(Validator.rnd(500, 1000)));
			} else if (chance < pGun + pAutomat) {
				weapons.add(new Automat(Validator.rnd(1000, 2000)));
			} else {
				weapons.add(new Bomb(Validator.rnd(500, 700)));
			}
		}
	}

	public boolean tryToBuyWeapon(Imigrant i, int attempts) {
		if (weapons.isEmpty()) {
			return false;
		}
		int index;
		Weapon w;
		boolean hasWeapon = false;
		attempts = attempts >= 0 ? attempts : 0;
		for (int j = 0; j < attempts; j++) {
			if (weapons.size() == 0) {
				break;
			}
			index = Validator.rnd(0, weapons.size());
			w = weapons.get(index);
			if (i.buyWeapon(w)) {
				hasWeapon = true;
				if (w.isBomb) {
					i.setHasBomb();
				}
				weapons.remove(index);
			}
		}
		return hasWeapon;
	}

	public int numberOfWeaponsInShop() {
		return weapons.size();
	}

}
