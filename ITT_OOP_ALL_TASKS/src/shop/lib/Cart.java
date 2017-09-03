package shop.lib;

import java.util.HashMap;

public class Cart {
	private ProductStorage products;
	private Buyer buyer;
	private Shop shop;

	public Cart(Buyer buyer) {
		products = new ProductStorage();
		this.buyer = buyer;
		this.shop = this.buyer.getShop();
	}

	public double containsProduct(String productName) {
		return products.containsProduct(productName);
	}

	public boolean removeProductByName(String productName) {
		Product p = products.removeProductByName(productName);
		if (p != null) {
			this.buyer.getShop().addProduct(p);
			return true;
		}
		return false;
	}

	public void payForProducts() {
		HashMap<String, Product> removed = removeAllProducts();
		for (Product p : removed.values()) {
			if (this.buyer.containsMoney(p.getTotalPrice())) {
				buyer.addProduct(p);
				shop.addMoney(buyer.removeMoney(p.getTotalPrice()));
				System.out.println(buyer.getName() + " buyed " + p);
			} else {
				System.out.println("Sorry you have not enough money for this product!");
				shop.addProduct(p);
			}
		}
	}

	HashMap<String, Product> removeAllProducts() {
		return products.removeAllProducts();
	}

	public void addProduct(Product p) {
		this.products.addProduct(p);
	}

}
