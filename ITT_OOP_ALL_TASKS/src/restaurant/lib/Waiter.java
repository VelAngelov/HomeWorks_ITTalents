package restaurant.lib;

import java.util.Comparator;
import java.util.HashMap;

/*
 * Сервитьорите имат следните характеристики:
• Име;
• Пари от бакшиши.
 */
public class Waiter {
	public static final String[] NAMES = {"Pesho","Ivan","Toni","Maria","Svetla","Snejka","Dimityr"};
	public static final Comparator<Waiter> COMPARE_BY_TIP = (o1,o2)-> ((int)(100*(-o1.getTips() + o2.getTips())));
	
	private String name;
	private double tips;
	private Restaurant restaurant;
	private HashMap<Client,Double> bills;
	
	public Waiter(String name,Restaurant restaurant) {
		if(name == null) {
			throw new IllegalArgumentException("Waiter without name!");
		}
		if(restaurant == null) {
			throw new IllegalArgumentException("Waiter without workplace!");
		}
		this.name = name;
		this.restaurant = restaurant;
		restaurant.registerNewWaiter(this);
		bills = new HashMap<Client, Double>();
	}
	
	public double makeBillForClient(Client client) {
		if(bills.containsKey(client)) {
			return bills.get(client);
		}
		return 0;
	}
	
	public String getName() {
		return name;
	}

	public double getTips() {
		return tips;
	}

	/**
	 * 
	 * @param client
	 * @param order
	 * @throws OutOfStockException
	 */
	Dish orderMealFromClient(Client client,String order){
		if(restaurant.containsDish(order)) {
			Dish meal = restaurant.getDishByName(order);
			if(!this.bills.containsKey(client)) {
				this.bills.put(client, 0d);
			}
			this.bills.put(client, bills.get(client)+meal.getCost());
			return meal;
		}
		System.out.println("Sorry " + client.getType().toLowerCase() + " restaurant dont have more " + order.toLowerCase());
		throw new OutOfStockException();
	}
	/**
	 * @param client
	 * @param order
	 * @throws OutOfStockException
	 */
	Drink orderDrinkFromClient(Client client, String order){
		if(restaurant.containsDrink(order)) {
			Drink drink = restaurant.getDrinkByName(order);
			if(!this.bills.containsKey(client)) {
				this.bills.put(client, 0d);
			}
			this.bills.put(client, bills.get(client)+drink.getCost());
			return drink;
		}
		System.out.println("Sorry " + client.getType().toLowerCase() + " restaurant dont have more " + order.toLowerCase());
		throw new OutOfStockException();
	}

	void payClientBill(Client client, double totalCost, double tip) {
		bills.remove(client);
		this.restaurant.addCash(totalCost);
		this.tips+=tip;
		System.out.println(client.getType() + "payed " + totalCost + "lv and tip "+tip);
	}
}
