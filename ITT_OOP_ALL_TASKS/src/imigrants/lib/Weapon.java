package imigrants.lib;

import java.util.Random;

import imigrants.lib.Weapon.WeaponType;

public class Weapon {
	private WeaponType type;
	private double cost;
	
	public enum WeaponType{
		PISTOLET(8),
		AVTOMAT(90),
		BOMBA(-1);
		private int numberOfBulets;
		private WeaponType(int numberOfBulets) {
			this.numberOfBulets = numberOfBulets;
		}
		public int getNumberOfBulets() {
			return numberOfBulets;
		}
	}
	public Weapon(WeaponType type, double cost) {
		this.type = type;
		this.cost = cost;
	}
	/** return -1 for bomb,else number of bulets*/
	public int shoot() {
		if(type.getNumberOfBulets()==-1) {
			return -1;
		}
		return new Random().nextInt(type.getNumberOfBulets()+1);
	}
	public double getCost() {
		return cost;
	}
	public WeaponType getType() {
		return type;
	}
}
