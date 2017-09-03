package tyrgovci.classes;

public class Pavilion extends ShopCenter {
	private static int id;

	public Pavilion(String adress, String rabVreme) {
		super(adress, Validator.rnd(5, 6 + 1), 50, rabVreme);
		super.setName("Pavilion" + (++id));
	}

}
