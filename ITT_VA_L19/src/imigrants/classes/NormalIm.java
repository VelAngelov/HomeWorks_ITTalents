package imigrants.classes;

import imigrants.classes.weapons.Weapon;

public class NormalIm extends Imigrant {

	NormalIm(int cash, Town town) {
		super(cash, town);
		generateAutomaticPasport();
		super.isLegal = true;
	}

	@Override
	public boolean addFriend(Imigrant imigrant) {
		if (this.friends == null || this.friends.size() < 10) {
			return super.addFriend(imigrant);
		}
		return false;
	}

	@Override
	public void suicide() {
	}

	@Override
	public boolean buyWeapon(Weapon w) {
		return false;
	}

}
