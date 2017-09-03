package restaurant.lib;

import java.util.Random;

/*
 * Ястията биват:
• Салати – всички салати са по 5 лева и имат грамаж между 300 и 600 грама.
• Основни ястия – всички основни ястия са по 9 лева и са с грамаж между
400 и 800 грама.
• Десерти – всички десерти са по 4 лева и имат грамаж между 200 и 300
грама.
 */
public class Dish {
	/**
	 * 0-"SALAD",1-"MAIN MEAL",2-"DESSERT"
	 */
	public static final String[] MEALS = {"SALAD","MAIN MEAL","DESSERT"};
	
	private String type;
	private double cost;
	private double weight;
	
	private Dish(String type, double cost, double weight) {
		this.type = type;
		this.cost = cost;
		this.weight = weight;
	}
	
	public static Dish createNewSalad() {
		return new Dish(MEALS[0] , 5, 300+new Random().nextInt(301));
	}
	
	public static Dish createNewMainMeal() {
		return new Dish(MEALS[1] , 9, 400+new Random().nextInt(401));
	}
	
	public static Dish createNewDessert() {
		return new Dish(MEALS[2] , 4, 200+new Random().nextInt(101));
	}

	public String getType() {
		return type;
	}

	public double getCost() {
		return cost;
	}

	public double getWeight() {
		return weight;
	}

	@Override
	public String toString() {
		return type + ", cost=" + cost + ", weight=" + weight;
	}

}
