package tyrgovci.classes;

public class AT extends Trader {

	public AT(String name, String adress, int capital) {
		super(name, adress, capital);
	}

	@Override
	public boolean addShop(ShopCenter shop) {
		if (super.shops.size() >= 1) {
			return false;
		}
		return super.addShop(shop);
	}

	@Override
	public boolean addProvider(Provider provider) {
		if (providers.size() < 1) {
			return super.addProvider(provider);
		}
		return false;
	}
}
