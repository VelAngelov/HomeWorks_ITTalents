package tyrgovci.lib;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Random;

/*
 *  произволно генериран брой продукти, като всеки продукт има
наименование и произволна цена между 5 и 15 лева. Общата цена на
продуктите представлява стойността на доставката.
 */
public class Product {
	/** PRODUCTS*/
	public static final String[] PRODUCTS = {"PRODUCT1","PRODUCT2","PRODUCT3","PRODUCT4","PRODUCT5","PRODUCT6"};
	public static final Comparator<Product> COMPARE_BY_PRICE = (o1,o2)-> (int)(o1.getCost()-o2.getCost());
	public static int serialId;
	private int id;
	private String name;
	private double cost;
	
	private Product(String name, double cost) {
		super();
		id=serialId++;
		this.name = name;
		this.cost = cost;
	}
	
	public static Product generateProductWithName(String name) {
		if(name==null||name.isEmpty()) {
			throw new IllegalArgumentException();
		}
		return new Product(name, 5+new Random().nextInt(11));
	}
	
	public static Product generateRandomProduct() {
		return new Product(PRODUCTS[new Random().nextInt(PRODUCTS.length)].toLowerCase(), 5+new Random().nextInt(11));
	}
	
	public static double calculateTotalCostOfProducts(ArrayList<Product> products) {
		double cost=0;
		for(Product p:products) {
			cost+=p.getCost();
		}
		return cost;
	}
	
	public static void printProductsWithAscPrice(ArrayList<Product> products) {
		Collections.sort(products,COMPARE_BY_PRICE);
		for(Product p:products) {
			System.out.println(p);
		}
	}
	
	public double getCost() {
		return cost;
	}
	
	public String getName() {
		return name;
	}

	@Override
	public String toString() {
		return name + ", cost=" + cost + "lv";
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (!(obj instanceof Product))
			return false;
		Product other = (Product) obj;
		if (id != other.id)
			return false;
		return true;
	}

	
}
