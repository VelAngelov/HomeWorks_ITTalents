package shop.classes;

import shop.classes.stock.Quantity;

public class Shopper {
	private String name;
	private Shop shop;
	private ListProducts cart;
	private ListProducts ownedProducts;
	private double cash;

	// OK
	public Shopper(String name, double cash) {
		this.name = name;
		this.cash = cash;
		this.cart = new ListProducts();
		this.ownedProducts = new ListProducts();
	}

	// OK
	public void goToShop(Shop shop) {
		if (shop == null) {
			System.out.printf("%s cant find the shop.\n", this.name);
			return;
		}
		System.out.printf("%s go to %s", this.name, shop.toString());
		this.shop = shop;
	}

	// OK
	public String getName() {
		return name;
	}

	// OK
	public boolean addToCart(String productName, String quantity) {
		if (shop == null) {
			System.out.println("First go in the shop with person.goToShop(shop)!");
			return false;
		}
		Product p = new Product(productName, quantity);
		if (!this.shop.checkForProduct(p)) {
			System.out.printf("%s can't find %s\n", this.name, p.getName());
			return false;
		}
		System.out.printf("%s wants to add %s(%s) in the cart,", this.name, p.getName(), p.getQuantity());
		p = shop.getProduct(p);

		if (p == null) {
			System.out.println("unecspected error!");
		} else if (new Quantity(p.getQuantity()).equalQuantity(quantity)) {
			System.out.printf(" and put %s(%s) in the cart.\n", p.getName(), p.getQuantity());
		} else if (p.getQuantity().replaceAll("[\\d,.]", "").equals(quantity.replaceAll("[\\d,.]", ""))) {
			System.out.printf("but there is only %s in the shop.\n\t\t%s deside to add as available in the cart.\n",
					p.getQuantity(), this.name);
		} else {
			System.out.printf("%s cant buy %s.Try to buy with another quantity!\n",this.name,quantity);
			return false;
		}
		cart.addProduct(p);
		return true;
	}

	// OK
	public String showItemsInTheCart() {
		StringBuilder sb = new StringBuilder();
		sb.append(String.format("And now %s have this items in the cart:\n", this.getName()));
		Product[] pr = cart.returnProducts();
		for (Product p : pr) {
			sb.append(p.toString());
		}
		return sb.toString();
	}

	// OK
	public String showMyProducts() {
		StringBuilder sb = new StringBuilder();
		sb.append(String.format("And now %s have %.2flv\n", this.getName(), this.getCash()));
		Product[] pr = ownedProducts.returnProducts();
		for (Product p : pr) {
			sb.append(p.toStringProductVsQuantity());
		}
		return sb.toString();
	}

	// OK
	public void payForProductInCart() {
		System.out.printf("%s go to the cash desk.Its time to pay for products\n", this.name);
		Product[] pr = cart.returnProducts();
		for (Product p : pr) {
			double priceForProduct = this.shop.calculatePriceForProduct(p);

			if (this.cash >= priceForProduct) {
				this.ownedProducts.addProduct(p);
				payWithCash(priceForProduct);
				System.out.printf("%s buy %s(%s) for %.2flv\n", this.name, p.getName(), p.getQuantity(),
						priceForProduct);
			} else {
				System.out.printf("%s have no %.2f lv to pay for,and leave the product in the cash desk\n", this.name,
						priceForProduct);
				this.shop.loadProducts(p);
			}
		}
		this.cart = new ListProducts();
	}

	public void removeProductFromCart(String productName, String quantity) {
		Product p = new Product(productName, quantity);
		p = this.cart.getProduct(p);
		System.out.printf("%s remove %s(%s) from the cart\n", this.name, p.getName(), p.getQuantity());
		this.shop.loadProducts(p);
	}

	// OK
	public void payWithCash(double cash) {
		this.cash -= cash;
	}

	public void setCash(double cash) {
		this.cash = cash;
	}

	public double getCash() {
		return cash;
	}

}
