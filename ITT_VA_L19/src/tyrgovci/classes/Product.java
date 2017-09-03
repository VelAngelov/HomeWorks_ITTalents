package tyrgovci.classes;

import java.util.Comparator;

public class Product implements Comparator<Product> {
	private static int id;
	private int cash;
	private String name;

	public Product() {
		id++;
		this.cash = Validator.rnd(5, 10 + 1);
		this.name = "Product" + id;
	}

	public int getCash() {
		return cash;
	}

	public String getName() {
		return name;
	}

	@Override
	public String toString() {
		return String.format("%s(%dlv)", this.name, this.cash);
	}

	@Override
	public int compare(Product o1, Product o2) {
		return o2.cash - o1.cash;
	}
}
