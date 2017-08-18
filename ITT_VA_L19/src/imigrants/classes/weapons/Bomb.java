package imigrants.classes.weapons;

import imigrants.classes.Validator;

public class Bomb extends Weapon {

	public Bomb(int cost) {
		super(cost);
		super.isBomb = true;
		super.quantityBulets = 1;
		super.type = "Bomb";
	}

	@Override
	public int shoot() {
		return Validator.rnd(100, 500);
	}
}
