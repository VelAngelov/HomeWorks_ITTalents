package tyrgovci.classes;

public class Market extends ShopCenter {
	private static int id;

	public Market(String adress, String rabVreme) {
		super(adress, Validator.rnd(2, 10 + 1), 50, rabVreme);
		super.setName("Market" + (++id));
	}

}
