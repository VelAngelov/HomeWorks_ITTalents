package imigrants.classes.weapons;

public class Gun extends Weapon {

	public Gun(int cost) {
		super(cost);
		super.type = "gun";
		super.isBomb = false;
		super.quantityBulets = 8;
	}
}