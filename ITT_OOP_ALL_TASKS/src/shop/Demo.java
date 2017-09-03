package shop;

import shop.lib.Buyer;
import shop.lib.Product;
import shop.lib.ProductByKilo;
import shop.lib.ProductByPiece;
import shop.lib.Shop;

public class Demo {
	public static void main(String[] args) {
		/*
		 * 1. Създаване на магазин с предварително подадена вместимост от
		 * продукти;
		 */
		Shop shop = new Shop("Fantastiko", "Simeonovsko shose", 50000);

		/*
		 * 2. Създаване на различни видове стоки на килограм –Месо, Сирене,
		 * Риба. Всяка стока се създава с наименование, цена и количество;
		 */
		Product[] products = new Product[10];
		products[0] = new ProductByKilo("Svinsko meso", 15, 200);
		products[1] = new ProductByKilo("Banani", 2.5, 500);
		products[2] = new ProductByKilo("Sirene", 10, 200);
		products[3] = new ProductByKilo("Maslini", 5, 200);
		products[4] = new ProductByKilo("Portokali", 1.5, 200);

		/*
		 * 3. Създаване на различни видове стоки на бройка –Бира, Книга, Стол.
		 * Всяка стока се създава с наименование, цена и количество;
		 */
		products[5] = new ProductByPiece("Bira", 1.5, 200);
		products[6] = new ProductByPiece("Riba", 6, 200);
		products[7] = new ProductByPiece("Hlqb", 1.5, 200);
		products[8] = new ProductByPiece("Shokolad", 1.8, 200);
		products[9] = new ProductByPiece("Proteinov bar", 2.7, 200);
		/* 4. Добавяне на стоките в магазина; */
		for (int i = 0; i < products.length; i++) {
			shop.addProduct(products[i]);
		}
		System.out.println("==========Products In Fantastiko===========");
		System.out.println(shop);
		System.out.println("==========End===========");
		/*
		 * 5. Създаване на купувачи с предварително подадени магазин, брой
		 * продукти за пазаруване и пари в наличност.
		 */
		Buyer pesho = new Buyer("pesho", 10000);
		Buyer ivan = new Buyer("ivan", 1000);
		ivan.goToShop(shop);
		pesho.goToShop(shop);
		/* 6. Добавяне на стоки към количката на купувачите; */
		ivan.addProductInCart("Svinsko meso", 5.2);
		ivan.addProductInCart("Hlqb", 1);
		ivan.addProductInCart("Bira", 5);
		ivan.addProductInCart("Shokolad", 5);
		/* 7. Премахване на стоки от количката на купувачите; */
		pesho.addProductInCart("Svinsko meso", 100);
		pesho.removeProductByName("Svinsko meso");
		/* 8. Плащане от страна на купувачите на касата на магазина; */
		ivan.payForProducts();
		pesho.payForProducts();

		/*
		 * 9. Визуализиране на наличностите в магазина преди и след като е
		 * пазарувал купувача.
		 */
		System.out.println("==========Products In Fantastiko===========");
		System.out.println(shop);
		System.out.println("==========End===========");

	}
}
