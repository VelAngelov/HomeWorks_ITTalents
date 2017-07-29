package shop.classes;

public class ListProducts {
	private static final int INI_LIST_SPACE = 10;
	private Product[] products;
	private int freeSpace;

	// OK
	public ListProducts() {
		this.products = new Product[INI_LIST_SPACE];
		this.freeSpace = INI_LIST_SPACE;
	}

	// OK
	public void addProduct(Product product) {
		if (product == null) {
			return;
		}
		if (!this.containsProduct(product) && freeSpace == 0) {
			// if we haven't such a product in the list and no space:
			expanSpace();
		}
		addNextProduct(product);
	}

	// OK
	public void addProducts(Product... products) {
		for (Product p : products) {
			addProduct(p);
		}
	}

	// OK
	private void addNextProduct(Product product) {
		if (product == null) {
			return;
		}
		if (this.containsProduct(product)) {
			// if list have such a product:
			addStockToProduct(product, product.getQuantity());
			return;
		}
		// if list have not such a product:
		products[products.length - freeSpace--] = product;
	}

	// OK
	public boolean containsProduct(Product product) {
		for (Product p : products) {
			if (p != null && p.equals(product)) {
				return true;
			}
		}
		return false;
	}

	// OK
	private void addStockToProduct(Product product, String quantity) {
		for (Product p : products) {
			if (p != null && p.equals(product)) {
				p.addQuantity(quantity);
				break;
			}
		}
	}

	// OK
	private Product removeProductByQuantityFromList(Product product) {
		if (product == null && !this.containsProduct(product)) {
			return null;
		}
		// there is such a product:
		for (int i = 0; i < products.length - freeSpace; i++) {
			if (products[i].equals(product)) {
				// we have found the product,now set the price for it:
				product.setPrice(products[i].getPrice());
				boolean isRemoved = products[i].removeQuantity(product.getQuantity());
				if (!isRemoved) {
					// we must obtain only product available quantity!
					product.setQuantity(products[i].getQuantity());
					// there is no more from this product!We remove it.
					return this.removeProductFromList(product);
				}
				// there is such a product and quantity,and we have remove it
				// from the product list!:
				break;
			}
		}
		return product;
	}

	// OK
	private Product removeProductFromList(Product product) {
		if (product == null) {
			return null;
		}
		boolean isRemoved = false;
		Product removed = null;
		for (int i = 0; i < products.length - freeSpace; i++) {
			if (!isRemoved && products[i].equals(product)) {
				isRemoved = true;
				removed = products[i];
				products[i] = null;
			}
			if (isRemoved && i < products.length - freeSpace - 1) {
				products[i] = products[i + 1];
			}
		}
		freeSpace++;
		return removed;
	}

	// OK
	public Product getProduct(Product product) {
		return removeProductByQuantityFromList(product);
	}

	// OK
	public Product viewProduct(Product product) {
		if (product == null) {
			return null;
		}
		if (this.containsProduct(product)) {
			for (Product p : products) {
				return p;
			}
		}
		return null;
	}

	// OK
	private void expanSpace() {
		freeSpace = products.length * 2;
		Product[] newProducts = new Product[freeSpace];
		for (Product p : products) {
			newProducts[newProducts.length - freeSpace--] = p;
		}
		this.products = newProducts;
	}

	// OK
	public double getProductPriceForQuantity(String productName, String quantity) {
		Product product = new Product(productName, quantity);
		double q = Double.parseDouble(quantity.replaceAll("[a-zA-Z]", ""));
		for (Product p : products) {
			if (p.equals(product)) {
				return p.getPrice() * q;
			}
		}
		return 0d;
	}

	// OK
	public Product[] returnProducts() {
		Product[] pr = new Product[products.length - freeSpace];
		for (int i = 0; i < products.length - freeSpace; i++) {
			pr[i] = products[i];
		}
		return pr;
	}

}
