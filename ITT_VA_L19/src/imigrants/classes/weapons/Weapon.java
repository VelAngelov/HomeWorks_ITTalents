package imigrants.classes.weapons;

import imigrants.classes.Validator;

public abstract class Weapon {
	protected double cost;
	protected String type;
	protected boolean isBomb;
	protected int quantityBulets;

	public Weapon(int cost) {
		this.cost = cost > 0 ? cost : 1000;
	}

	public double getCost() {
		return cost;
	}

	public boolean isBomb() {
		return isBomb;
	}
	public String getType() {
		return type;
	}

	public int shoot() {
		return Validator.rnd(1, quantityBulets + 1);
	}
}
