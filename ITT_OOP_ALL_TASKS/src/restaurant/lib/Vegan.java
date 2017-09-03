package restaurant.lib;
/*
 * • вегани – те имат 30 лева в джоба и ядат само салати и пият само
безалкохолни.
 */
public class Vegan extends Client {

	public Vegan() {
		super(Client.CLIENTS[2], 30);
	}

	@Override
	String orderNewMeal() {
		return Dish.MEALS[0];
	}

	@Override
	String orderNewDrink() {
		return Drink.DRINKS[1];
	}

}
