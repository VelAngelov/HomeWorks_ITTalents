package tyrgovci.classes;

public class ET extends Trader {

	public ET(String name, String adress, int capital) {
		super(name, adress, capital);
	}

	@Override
	public boolean addShop(ShopCenter shop) {
		if (shops.size() < 1 && (shop.getName().startsWith("Market") || shop.getName().startsWith("Pavilion"))) {
			return super.addShop(shop);
		}
		return false;
	}

	@Override
	public boolean addProvider(Provider provider) {
		if (providers.size() < 5 && provider.getName().startsWith("Retail")) {
			return super.addProvider(provider);
		}
		return false;
	}

}
