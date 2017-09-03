package tyrgovci.classes;

public class TV extends Trader {

	public TV(String name, String adress, int capital) {
		super(name, adress, capital);
	}

	@Override
	public boolean addProvider(Provider provider) {
		if (providers.size() < 15) {
			return super.addProvider(provider);
		}
		return false;
	}

}
