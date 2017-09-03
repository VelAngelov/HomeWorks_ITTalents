package tyrgovci.classes;

public class ShopMall extends ShopCenter {
	private static int id;

	public ShopMall(String adress, String rabVreme) {
		super(adress, Validator.rnd(10, 100), 150, rabVreme);
		super.setName("ShopMall" + (++id));
	}

}
