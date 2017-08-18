package imigrants.classes;

import imigrants.classes.weapons.Weapon;

public class RadicalIm extends Imigrant {

	RadicalIm(int cash, Town town, double chanceToHavePassport) {
		super(cash, town);
		if (Math.random() <= chanceToHavePassport) {
			generateAutomaticPasport();
			super.isLegal = true;
		}
	}

	@Override
	public boolean buyWeapon(Weapon w) {
		if (super.weapons.size() < 5 && !w.isBomb()) {
			super.buyWeapon(w);
			return true;
		}
		return false;
	}
}
