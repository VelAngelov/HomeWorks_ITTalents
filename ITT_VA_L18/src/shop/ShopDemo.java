package shop;

import shop.classes.*;

public class ShopDemo {
	public static void main(String[] args) {
		Product[] products = new Product[8];
		products[0] = new Product("Cheese", 5.15, "100kg");
		products[1] = new Product("Meat", 15, "500kg");
		products[2] = new Product("Eggs", 0.2, "100p");
		products[3] = new Product("Olives", 4.52, "50kg");
		products[4] = new Product("Banana", 2.90, "20kg");
		products[5] = new Product("Avocado", 1.05, "20p");
		products[6] = new Product("Book", 20, "25p");
		products[7] = new Product("Beer", 1.6, "120p");

		Shop fantastiko = new Shop("Fantastiko", "Simeonovsko shose", 5000d);
		fantastiko.loadProducts(products);

		Shopper vilio = new Shopper("Velichko", 2000);
		vilio.addToCart("Cheese", "105kg");
		vilio.goToShop(fantastiko);
		vilio.addToCart("Cheese", "105kg");
		vilio.removeProductFromCart("Cheese", "75kg");
		System.out.println(vilio.showItemsInTheCart());

		vilio.addToCart("Tomatoes", "2kg");
		vilio.addToCart("Beer", "2p");
		vilio.addToCart("Banana", "3p");
		vilio.addToCart("Meat", "15kg");
		vilio.payForProductInCart();

		System.out.println();

		System.out.println(vilio.showMyProducts());

		System.out.println();
		System.out.println(vilio.showItemsInTheCart());

		System.out.println();
		System.out.println(fantastiko.showProductList());

		System.out.println();
		vilio.addToCart("Meat", "150kg");
		vilio.payForProductInCart();
		
		System.out.println(vilio.showMyProducts());
		System.out.println();
		System.out.println(vilio.showItemsInTheCart());

		System.out.println();
		System.out.println(fantastiko.showProductList());
	}
}
