package shop.lib;

public class Buyer {
	private String name;
	private Shop shop;
	private double cash;
	private Cart cart;
	private ProductStorage products;

	public Buyer(String name, double cash) {
		this.name = name;
		this.cash = cash;
		this.products = new ProductStorage();
	}

	public double containsProductInCart(String productName) {
		return cart.containsProduct(productName);
	}

	public void addProductInCart(String productName, double quantity) {
		cart.addProduct(shop.getProductByNameAndQuantity(productName, quantity));
	}

	public boolean removeProductByName(String productName) {
		return cart.removeProductByName(productName);
	}

	public boolean goToShop(Shop shop) {
		if (shop == null) {
			return false;
		}
		this.shop = shop;
		this.cart = new Cart(this);
		return true;
	}

	public boolean containsMoney(double money) {
		return money >= 0 && (money < cash);
	}

	double removeMoney(double money) {
		this.cash -= money;
		return money;
	}

	void addProduct(Product p) {
		products.addProduct(p);
	}

	public void payForProducts() {
		cart.payForProducts();
	}

	Shop getShop() {
		return shop;
	}

	public String getName() {
		return this.name;
	}

}
