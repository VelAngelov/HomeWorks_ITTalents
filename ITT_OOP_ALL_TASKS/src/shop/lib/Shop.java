package shop.lib;

public class Shop {
	private String name;
	private String adress;
	private double cash;
	private ProductStorage products;

	public Shop(String name, String adress, double cash) {
		this.name = name;
		this.adress = adress;
		this.cash = cash;
		products = new ProductStorage();
	}

	public void addProduct(Product p) {
		products.addProduct(p);
	}

	public String getName() {
		return name;
	}

	public String getAdress() {
		return adress;
	}

	public double getCash() {
		return cash;
	}

	void addMoney(double money) {
		this.cash += money;
	}

	public Product getProductByNameAndQuantity(String productName, double quantity) {
		return products.getProductByQuantity(productName, quantity);
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		for (Product p : products) {
			sb.append(p + "\n");
		}
		return sb.toString();
	}
}
