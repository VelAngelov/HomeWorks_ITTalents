package tyrgovci.classes;

public class WholeSeller extends Provider {
	private static int id;

	public WholeSeller(String adress, String rabVreme) {
		super("WholeSeller" + (++id), adress, rabVreme);
		super.discount = 0.15;
	}

}
