package restaurant.lib;

/*
 * Напитките биват:
• Алкохолни – те са с цена от 4 лева на бройка;
• Безалкохолни – те са с цена от 2 лева на бройка.
 */
public class Drink {
	/**
	 * 0-"ALCOHOL",1-"NON-ALCOHOL"
	 */
	public static final String[] DRINKS = {"ALCOHOL","NON-ALCOHOL"};
	
	private String type;
	private double cost;
	
	private Drink(String type, double cost) {
		this.type = type;
		this.cost = cost;
	}
	
	public static Drink createNewAlcoholDrink() {
		return new Drink(DRINKS[0] , 4);
	}
	
	public static Drink createNewNonAlcoholDrink() {
		return new Drink(DRINKS[1] , 2);
	}

	public String getType() {
		return type;
	}

	public double getCost() {
		return cost;
	}
	@Override
	public String toString() {
		return type + ", cost=" + cost;
	}
}
