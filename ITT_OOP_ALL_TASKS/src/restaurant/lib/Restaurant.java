package restaurant.lib;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Random;

/*
 * Реализирайте структура от класове, която да представлява работата на ресторант
„При Пешо Таланта“
Ресторантът има следните характеристики:
• Наименование;
• Адрес;
• Капитал – начална сума, налична в касата на ресторанта;
• Меню с ястия и напитки;
• Списък със сервитьори, които обслужват клиентите
 */
/*
 * Менюто съдържа следните характеристики:
• Списък с ястия. Всяко ястие има наименование, цена и грамаж.
• Списък с напитки. Всяка напитка има наименование и цена.
 */
/*
 * В ресторанта могат да се настаняват клиенти. Всеки клиент има име и пари в
джоба, които е отделил за хапване и пийване.
 */
/*
 * +Ресторантът има ограничено количество от всяко ястие, като при създаването си
той е зареден с по 10 порции от всеки вид и по 20 броя от всяка напитка.
 */
public class Restaurant {
	
	private String name;
	private String adress;
	private double cash;
	private ArrayList<Waiter> waiters;
	private HashMap<String,Queue<Dish>> meals;
	private HashMap<String,Queue<Drink>> drinks;
	
	public Restaurant(String name, String adress, double cash) {
		if(name==null||adress==null||cash<0) {
			throw new IllegalArgumentException();
		}
		this.name = name;
		this.adress = adress;
		this.cash = cash;
		
		this.waiters = new ArrayList<>();
		
		this.meals = new HashMap<String, Queue<Dish>>();
		initializeMeals(meals);
		this.drinks = new HashMap<String, Queue<Drink>>();
		initializeDrinks(drinks);
		
		chargeRestaurant();
	}
	public void printMealsAndDrinks() {
		System.out.println("MEALS:");
		for(String s:meals.keySet()) {
			System.out.print("\t"+s);
			if(meals.get(s).isEmpty()) {
				System.out.println();
				continue;
			}
			System.out.println("-" + meals.get(s).size()+"porcii");
		}
		System.out.println("DRINKS:");
		for(String s:drinks.keySet()) {
			System.out.print("\t"+s);
			if(drinks.get(s).isEmpty()) {
				System.out.println();
				continue;
			}
			System.out.println("-" + drinks.get(s).size()+"broq");
		}
	}
	
	public void printWaiterWithMaxTips() {
		sortWaitersByTips();
		System.out.println("Top waiter is" +waiters.get(0).getName()+" with total tips:"+ waiters.get(0).getTips()+"lv");
	}
	public void printWaiterWithTipsSorted() {
		sortWaitersByTips();
		for(Waiter w:waiters) {
			System.out.println(w.getName()+" total tips:"+ w.getTips()+"lv");
		}
	}
	
	public void findWaiters(int count) {
		if(count <= 0) {
			return;
		}
		for (int i = 0; i < count; i++) {
			new Waiter(Waiter.NAMES[new Random().nextInt(Waiter.NAMES.length)], this);
		}
	}
	
	public double checkDrinkCost(String drink) {
		if(drink==null || drinks.get(drink) == null || drinks.get(drink).isEmpty()) {
			return 0;
		}
		return drinks.get(drink).peek().getCost();
	}
	
	public double checkMealCost(String meal) {
		if(meal==null || meals.get(meal) == null || meals.get(meal).isEmpty()) {
			return 0;
		}
		return meals.get(meal).peek().getCost();
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAdress() {
		return adress;
	}

	public void setAdress(String adress) {
		this.adress = adress;
	}

	public double getCash() {
		return cash;
	}

	public void setCash(double cash) {
		this.cash = cash;
	}

	boolean registerNewWaiter(Waiter waiter) {
		this.waiters.add(waiter);
		return true;
	}

	Waiter getRandomWaiter() {
		return waiters.get(new Random().nextInt(waiters.size()));
	}

	boolean containsDish(String order) {
		return !meals.get(order).isEmpty();
	}
	
	/**
	 * 
	 * @param order
	 * @return null or dish
	 */
	Dish getDishByName(String order) {
		if(meals.get(order).size()!=0) {
			return meals.get(order).poll();
		}
		return null;
	}
	
	boolean containsDrink(String order) {
		return !drinks.get(order).isEmpty();
	}
	
	/**
	 * 
	 * @param order
	 * @return null or drink
	 */
	Drink getDrinkByName(String order) {
		if(drinks.get(order).size()!=0) {
			return drinks.get(order).poll();
		}
		return null;
	}
	
	void addCash(double totalCost) {
		this.cash+=totalCost;
	}
	
	private void initializeDrinks(HashMap<String,Queue<Drink>> drinks) {
		drinks.put(Drink.DRINKS[0], new  LinkedList<Drink>());
		drinks.put(Drink.DRINKS[1], new  LinkedList<Drink>());
	}
	
	private void initializeMeals(HashMap<String,Queue<Dish>> meals) {
		meals.put(Dish.MEALS[0], new  LinkedList<Dish>());
		meals.put(Dish.MEALS[1], new  LinkedList<Dish>());
		meals.put(Dish.MEALS[2], new  LinkedList<Dish>());
	}
	
	private void chargeRestaurant() {
		for (int i = 0; i < 20; i++) {
			this.drinks.get(Drink.DRINKS[0]).offer(Drink.createNewAlcoholDrink());
			this.drinks.get(Drink.DRINKS[1]).offer(Drink.createNewNonAlcoholDrink());
		}
		for (int i = 0; i < 10; i++) {
			this.meals.get(Dish.MEALS[0]).offer(Dish.createNewSalad());
			this.meals.get(Dish.MEALS[1]).offer(Dish.createNewMainMeal());
			this.meals.get(Dish.MEALS[2]).offer(Dish.createNewDessert());
		}
	}
	private void sortWaitersByTips() {
		Collections.sort(waiters, Waiter.COMPARE_BY_TIP);
	}

}
