package shop.classes;

public class Shop {
	private String name;
	private String adress;
	private double cash;
	private ListProducts products;

	// OK
	public Shop(String name, String adress, double cash) {
		this.name = name;
		this.adress = adress;
		this.cash = cash;
		this.products = new ListProducts();
	}

	// OK
	public void loadProducts(Product... p) {
		products.addProducts(p);
	}

	// OK
	public boolean checkForProduct(Product product) {
		return products.containsProduct(product);
	}

	// OK
	public Product getProduct(Product product) {
		return products.getProduct(product);
	}

	// OK
	public double checkProductPriceForQuantity(String productName, String quantity) {
		return products.getProductPriceForQuantity(productName, quantity);
	}

	public double calculatePriceForProduct(Product product) {
		String quantity = product.getQuantity().replaceAll("[a-zA-Z]", "");
		double q = Double.parseDouble(quantity);
		return q * product.getPrice();
	}

	// OK
	public String showProductList() {
		StringBuilder sb = new StringBuilder();
		sb.append(String.format("%s have this products:\n", this.name));
		Product[] pr = products.returnProducts();
		for (Product p : pr) {
			sb.append(p.toString());
		}
		return sb.toString();
	}

	public double getCash() {
		return cash;
	}

	public void setCash(double cash) {
		this.cash = cash;
	}

	@Override
	public String toString() {
		return String.format("%s adress:%s\n", name, adress);
	}

}
