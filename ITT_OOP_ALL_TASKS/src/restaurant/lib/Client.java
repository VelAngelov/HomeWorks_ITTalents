package restaurant.lib;

import java.util.ArrayList;
import java.util.Random;

/*
 *+ Клиентите биват три вида:
• студенти – те имат 10 лева в джоба и могат да ядат всичко;
• мутри – те имат 50 лева в джоба и ядат само основни ястия и пият само
алкохол.
• вегани – те имат 30 лева в джоба и ядат само салати и пият само
безалкохолни.
 */
/*
 * Всеки клиент може да изпълнява следните действия:
+ да прави поръчка на ястия и напитки към избран на произволен принцип
сервитьор. Поръчката представлява списък от ястия и напитки, като
съответно мутрите могат да си поръчват само мутренските неща от
менюто, веганите – само веганските, а студентите могат да си поръчат
всичко. Общата стойност на поръчките на клиентите не трябва да
надвишава 90% от парите им в джоба. Ако случайно поръчаното ястие или
напитка вече не е налично в ресторанта, трябва да се обработи
изключителна ситуация и клиентът да поръча нещо друго.
+ Да поиска сметката – тогава сервитьорът трябва да предаде на клиента
информация за общата сума на неговите поръчани неща.
+ Да плати сметката – при плащане клиентът има 80% вероятност да остави
бакшиш в размер на между 5% и 10% от стойността на поръчката му.
Бакшишът остава директно за сервитьора, а останалата сума се прибавя
към сметката на ресторанта.
 */
public abstract class Client {
	/**
	 * 0-"STUDENT",1-"MUTRA", 2-"VEGAN"
	 */
	public static final String[] CLIENTS = {"STUDENT","MUTRA", "VEGAN"};
	private static int id;
	
	private int personalId;
	private String type;
	private double cash;
	private Waiter waiter;
	private double myBill;
	protected Restaurant restaurant;
	protected ArrayList<Dish> meals;
	protected ArrayList<Drink> drinks;
	
	
	
	public Client(String type, double cash) {
		this.personalId = id++;
		this.type = type;
		this.cash = cash;
		this.meals = new ArrayList<>();
		this.drinks = new ArrayList<>();
	}



	public static Client createNewStudent() {
		return new Student();
	}
	
	public static Client createNewMutra() {
		return new Mutra();
	}
	
	public static Client createNewVegan() {
		return new Vegan();
	}
	
	public boolean goToRestaurant(Restaurant restaurant) {
		if(this.restaurant == null) {
			if(restaurant!=null) {
				this.restaurant = restaurant;
				this.waiter = restaurant.getRandomWaiter();
				return true;
			}
			return false;
		}
		return false;
	}
	
	public String getType() {
		return type;
	}

	public double getCash() {
		return cash;
	}

	public void orderMealsAndDrinks() {
		if(!verifiedRestaurantAndWaiter()) {
			return;
		}
		int attempts = 0;
		while(myBill < 0.9*cash && attempts < 2) {
			try {
				if(!orderMeal()) {
					attempts++;
				}
				if(!orderDrink()) {
					attempts++;
				}
			}catch (OutOfCashException e) {
				//out of cash
				attempts++;
			}
		}
	}
	
	public void payTheBill() {
		double totalCost = waiter.makeBillForClient(this);
		double tip = 0;
		if(new Random().nextInt(11)<8) {
			tip = ((5+new Random().nextInt(6))/100.0)*totalCost;
			tip = ((int)(tip*100))/100.0;
		}
		cash -= (totalCost+tip);
		waiter.payClientBill(this,totalCost,tip);
		this.restaurant = null;
		this.waiter = null;
	}

	public void makeMyBill() {
		if(!verifiedRestaurantAndWaiter()) {
			return;
		}
		System.out.println(waiter.getName()+": your bill is " + waiter.makeBillForClient(this));
	}
	
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + personalId;
		result = prime * result + ((type == null) ? 0 : type.hashCode());
		return result;
	}



	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (!(obj instanceof Client))
			return false;
		Client other = (Client) obj;
		if (personalId != other.personalId)
			return false;
		if (type == null) {
			if (other.type != null)
				return false;
		} else if (!type.equals(other.type))
			return false;
		return true;
	}

	abstract String orderNewMeal();
	
	abstract String orderNewDrink();
	
	boolean verifiedRestaurantAndWaiter() {
		if(restaurant != null && waiter != null) {
			return true;
		}
		return false;
	}
	
	private boolean orderMeal() {
		String order = orderNewMeal();
		double costOrder = restaurant.checkMealCost(order);
		
		if(myBill + costOrder < 0.9*cash) {
			try {
				meals.add(waiter.orderMealFromClient(this, order));
			}catch(OutOfStockException ofse) {
				return false;
			}
			System.out.println(type +" order " + order.toLowerCase());
			myBill += costOrder;
			return true;
		}
		throw new OutOfCashException();
	}
	
	private boolean orderDrink() {
		String order = orderNewDrink();
		double costOrder = restaurant.checkDrinkCost(order);
		
		if(myBill + costOrder < 0.9*cash) {
			try {
				drinks.add(waiter.orderDrinkFromClient(this, order));
			}catch(OutOfStockException ofse) {
				return false;
			}
			System.out.println(type +" order " + order.toLowerCase());
			myBill += costOrder;
			return true;
		}
		throw new OutOfCashException();
	}
}
