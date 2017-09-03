package shop.lib;

public abstract class Product implements Comparable<Product> {
	/*
	 * Продуктите могат да се продават на килограм или на бройка. Няма продукти,
	 * които да се продават както на килограм, така и на брой.
	 */
	private String name;
	private double price;
	private double quontity;
	private String units;
	public static final String[] UNIT = { "kg", "piece" };

	public Product(String name, double pricePerUnit, double quantity, String units) {
		this.name = name;
		this.price = pricePerUnit;
		this.quontity = quantity;
		this.units = units;
	}

	public String getName() {
		return name;
	}

	public double getPrice() {
		return price;
	}

	public double getTotalPrice() {
		return price * quontity;
	}

	public double getQuontity() {
		if (units.equals("piece")) {
			return (int) quontity;
		}
		return quontity;
	}

	public String getUnits() {
		return units;
	}

	void addQuantity(double quantity) {
		if (quantity < 0) {
			return;
		}
		this.quontity += quantity;
	}

	/**
	 * 
	 * @param quantity
	 * @return Product or null;
	 */
	Product removeQuantity(double quantity) {
		if (quantity >= 0 && quantity < this.quontity) {
			if (units.equals("kg")) {
				this.quontity -= quantity;
				return new ProductByKilo(this.name, this.price, quantity);
			} else {
				this.quontity -= (int) quantity;
				return new ProductByPiece(this.name, this.price, (int) quontity);
			}
		}
		return null;
	}

	@Override
	public int compareTo(Product o) {
		int result = this.name.compareTo(o.name);
		if (result == 0) {
			result = (int) (100 * (this.price - o.price));
		}
		return 0;
	}

	@Override
	public String toString() {
		if (units.equals("kg")) {
			return name + ", quontity=" + quontity + units + ", price=" + getTotalPrice() + "lv";
		}
		return name + ", quontity=" + (int) quontity + "p." + ", price=" + getTotalPrice() + "lv";
	}

}
