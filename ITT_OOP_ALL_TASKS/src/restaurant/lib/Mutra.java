package restaurant.lib;

public class Mutra extends Client {

	public Mutra() {
		super(Client.CLIENTS[1], 50);
	}

	@Override
	String orderNewMeal() {
		return Dish.MEALS[1];
	}

	@Override
	String orderNewDrink() {
		return Drink.DRINKS[0];
	}

}
