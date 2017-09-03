package restaurant.lib;

import java.util.Random;

/*
 * • студенти – те имат 10 лева в джоба и могат да ядат всичко;
 */
public class Student extends Client{

	public Student() {
		super(Client.CLIENTS[0], 10);
	}

	@Override
	String orderNewMeal() {
		return Dish.MEALS[new Random().nextInt(Dish.MEALS.length)];
	}

	@Override
	String orderNewDrink() {
		return Drink.DRINKS[new Random().nextInt(Drink.DRINKS.length)];
	}

}
