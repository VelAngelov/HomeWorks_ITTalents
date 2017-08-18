package imigrants.classes.weapons;

public class Automat extends Weapon {

	public Automat(int cost) {
		super(cost);
		super.isBomb = false;
		super.type = "AK-47";
		super.quantityBulets = 100;
	}
}
