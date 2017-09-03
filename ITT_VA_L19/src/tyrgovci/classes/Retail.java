package tyrgovci.classes;

public class Retail extends Provider {
	private static int id;

	public Retail(String adress, String rabVreme) {
		super("Retail" + (++id), adress, rabVreme);
		super.discount = 0;
	}

}
