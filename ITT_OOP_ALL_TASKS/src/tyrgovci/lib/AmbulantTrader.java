package tyrgovci.lib;

import java.util.ArrayList;
import java.util.Random;

/*
 * • Амбулантен търговец – той не оперира в определен търговски обект и
работи с един доставчик на дребно.
 */
class AmbulantTrader extends Trader{
	
	private ArrayList<Product> products;
	
	AmbulantTrader(String adress, double cash) {
		super(Trader.TRADERS[0], adress, cash);
		products =new ArrayList<>();
	}

	@Override
	public Provider addProvider(Provider provider) {
		if(provider==null) {
			return null;
		}
		if(providers.size() == 1) {
			return provider;
		}
		if(provider.getType().equals(Provider.PROVIDERS[1])) {
			return provider;
		}
		providers.add(provider);
		return null;
	}

	@Override
	public TradeShop addTradeShop(TradeShop tradeShop) {
		return tradeShop;
	}
	
	@Override
	protected void addProductsInShop(TradeShop shop, ArrayList<Product> products) {
		System.out.println(this + "add products:");
		Product.printProductsWithAscPrice(products);
		this.products.addAll(products);
	}
	
	@Override
	public void collectMoneyFromShops() {
		System.out.println("I don't collect money form shops!");
	}
	
	@Override
	public void payTaxForShops() {
		System.out.println("I do not have my own store to pay taxes!");
	}
	
	public void sellRandomProducts() {
		int numberOfSoldProducts = new Random().nextInt(products.size()+1);
		if(numberOfSoldProducts == products.size()) {
			super.cash += Product.calculateTotalCostOfProducts(products)*TradeShop.SELL_PRICE_FACTOR;
			products = new ArrayList<>();
			return;
		}
		for (int i = 0; i < numberOfSoldProducts; i++) {
			Product p = products.remove(new Random().nextInt(products.size()));
			super.cash+=p.getCost();
		}
	}
	@Override
	public void shopsSellProducts() {
		sellRandomProducts();
	}
	@Override
	public void orderProductsForAllShops() {
		makeOrderWithProviderForShop(null, providers.get(0));
	}
	
}
