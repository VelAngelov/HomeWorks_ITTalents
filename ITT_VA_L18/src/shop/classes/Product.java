package shop.classes;

import shop.classes.stock.*;

public class Product {
	private String name;
	private double price;
	private Quantity stock;

	public Product(String name, String quantity) {
		this.name = name;
		this.stock = new Quantity(quantity);
	}

	public Product(String name, double price, String quantity) {
		this(name, quantity);
		this.price = price;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public String getQuantity() {
		return stock.getQuantity();
	}

	public void setQuantity(String quantity) {
		this.stock.setQuantity(quantity);
	}

	public void addQuantity(String quantity) {
		this.stock.addQuantity(quantity);
	}

	public boolean removeQuantity(String quantity) {
		if (!this.stock.removeQuantity(quantity)) {
			return false;
		}
		return true;
	}

	public String getName() {
		return name;
	}

	public boolean equals(Product product) {
		if (this.name.equals(product.getName())) {
			return true;
		}
		return false;
	}

	@Override
	public String toString() {
		String st = this.stock.getQuantity().replaceAll("[\\d,.]", "");
		return String.format("%s(%s) %.2flv/%s\n", this.name, this.stock.getQuantity(), this.price, st);
	}

	public String toStringProductVsQuantity() {
		return String.format("%s(%s)\n", this.name, this.stock.getQuantity());
	}

}
