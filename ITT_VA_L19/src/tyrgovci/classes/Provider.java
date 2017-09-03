package tyrgovci.classes;

import java.util.ArrayList;

public abstract class Provider extends Entity {
	protected double discount;

	public Provider(String name, String adress, String rabVreme) {
		super(adress);
		super.setRabVreme(rabVreme);
		super.setName(name);
	}

	private ArrayList<Product> generateProductsForCash(int cash) {
		ArrayList<Product> products = new ArrayList<Product>();
		int cashLeft = cash;
		Product p = new Product();
		while (cashLeft > p.getCash()) {
			cashLeft -= p.getCash();
			products.add(p);
			p = new Product();
		}
		return products;
	}

	public ArrayList<Product> izpylniPorychka(Trader trader, int cash) {
		ArrayList<Product> products = generateProductsForCash(cash);
		int totalCash = 0;
		for (Product p : products) {
			totalCash += p.getCash();
		}
		int discaunt = (int) (this.discount * totalCash);
		trader.setCash(trader.getCash() - totalCash);
		trader.addCash(discaunt);
		return products;
	}

	@Override
	public String getRabVreme() {
		return super.getRabVreme();
	}
}
