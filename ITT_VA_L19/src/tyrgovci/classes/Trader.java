package tyrgovci.classes;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

public abstract class Trader extends Entity {
	protected ArrayList<ShopCenter> shops;
	protected ArrayList<Provider> providers;
	protected ArrayList<Product> buyedProducts;

	public Trader(String name, String adress, int capital) {
		super(adress);
		super.setName(name);
		super.setCash(capital > 0 ? capital : 0);
		this.shops = new ArrayList<ShopCenter>();
		this.providers = new ArrayList<Provider>();
		this.buyedProducts = new ArrayList<Product>();
	}

	public void payBillForShop(ShopCenter shop) {
		this.cash -= shop.getBill();
	}

	public void priberiOborot() {
		if (shops.size() > 0) {
			for (ShopCenter s : shops) {
				this.cash += s.getCash();
				s.setCash(0);
			}
		}
	}

	public void napraviPoruchka(Provider provider, int cost) {
		if (cost <=0) {
			System.out.printf("%s nqma pari za porychka!", this.getName());
			return;
		}
		ArrayList<Product> products = provider.izpylniPorychka(this, cost);
		StringBuilder sb = new StringBuilder();
		sb.append(String.format("Napravena e porychka ot %s kym %s,producti:\n", this.getName(), provider.getName()));
		Collections.sort(products, new Product());
		for (Product p : products) {
			sb.append(p + "\n");
		}
		System.out.println(sb.toString());
		this.buyedProducts.addAll(products);
	}

	public void obslujiMagazini() {
		for (ShopCenter s : shops) {
			// prodava productite v magazina
			if (s.sellProducts()) {
				int cashFromShop = s.getCash();
				s.setCash(0);
				this.addCash(cashFromShop);
				System.out.printf("%s vzima ot %s pechalba ot:%dlv\n", this.getName(), s.getName(), cashFromShop);
			} else {
				System.out.printf("%s is empty!\n", s.getName());
			}

			// plashta danyk za magazina;
			this.payBillForShop(s);
			System.out.printf("%s plati danyci za %s\n ", this.getName(), s.getName());
			// zarejda magazina;
			Provider p = this.providers.get(Validator.rnd(0, this.providers.size()));
			napraviPoruchka(p, (int) (this.cash * 0.5));
			s.addProductForSale(this.buyedProducts);
		}
	}

	// to Override
	public boolean hasShops() {
		if (shops.size() > 0) {
			return true;
		}
		return false;
	}

	public boolean addShop(ShopCenter shop) {
		this.shops.add(shop);
		return true;
	}

	public boolean addProvider(Provider provider) {
		this.providers.add(provider);
		return true;
	}
}
