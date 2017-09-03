package shop.lib;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

public class ProductStorage implements Iterable<Product> {
	private HashMap<String, Product> products;

	public ProductStorage() {
		products = new HashMap<>();
	}

	public double containsProduct(String productName) {
		if (!products.containsKey(productName)) {
			return -1;
		}
		Product p = products.get(productName);
		return p.getQuontity();
	}

	public boolean containsProductByQuantity(String productName, double quantity) {
		return quantity > 0 && quantity < containsProduct(productName);
	}

	public void addProduct(Product p) {
		if (p == null) {
			return;
		}
		if (products.containsKey(p.getName())) {
			products.get(p.getName()).addQuantity(p.getQuontity());
			return;
		}
		products.put(p.getName(), p);
	}

	public void addProducts(HashMap<String, Product> product) {
		if (product == null) {
			return;
		}
		for (Product p : products.values()) {
			addProduct(p);
		}
	}

	public HashMap<String, Product> removeAllProducts() {
		HashMap<String, Product> products = this.products;
		this.products = new HashMap<String, Product>();
		return products;
	}

	public Product getProductByQuantity(String productName, double quantity) {
		double availableQuantity = containsProduct(productName);
		Product p = products.get(productName);
		if (quantity > 0 && quantity < availableQuantity) {
			String units = p.getUnits();
			if (units.equals(Product.UNIT[0])) {
				p.removeQuantity(quantity);
				return new ProductByKilo(p.getName(), p.getPrice(), quantity);
			} else {
				p.removeQuantity((int) quantity);
				return new ProductByPiece(p.getName(), p.getPrice(), (int) quantity);
			}
		}
		return null;
	}

	public Product removeProductByName(String productName) {
		return products.remove(productName);
	}

	@Override
	public Iterator<Product> iterator() {
		ArrayList<Product> list = new ArrayList<Product>(products.values());
		return list.iterator();
	}

}
