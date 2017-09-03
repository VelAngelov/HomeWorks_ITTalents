package tyrgovci.lib;

import java.util.ArrayList;

/*
 * Доставчиците съдържат следните характеристики:
• наименование
• адрес
• работно време
 */
/*
 * Доставчиците могат да бъдат на дребно и на едро. Доставчиците на стоки на едро
имат отстъпка от 15 процента от цената на всички стоки.
 */
public class Provider {
	//Equals!
	/** 0-"RETAILER",1-"SUPPLIER" */
	public static final String[] PROVIDERS = {"RETAILER","SUPPLIER"};
	
	private String type;
	private String adress;
	private String workingTime;
	private double discount;
	
	private Provider(String type, String adress, String workingTime,double discount) {
		this.type = type;
		this.adress = adress;
		this.workingTime = workingTime;
	}
	
	public static Provider createNewRetailer(String adress,String workingTime) {
		validateString(adress);
		validateString(workingTime);
		return new Provider(PROVIDERS[0], adress, workingTime,0);
	}
	
	public static Provider createNewSuplier(String adress,String workingTime) {
		validateString(adress);
		validateString(workingTime);
		return new Provider(PROVIDERS[1], adress, workingTime,0.15);
	}
	
	ArrayList<Product> productsForCash(Trader trader,double cash){
		ArrayList<Product> products = generateProductsForCash(cash);
		double costOfProducts = Product.calculateTotalCostOfProducts(products);
		double discount = makeDiscount(costOfProducts);
		double totalCost = costOfProducts-discount;
		trader.addCash(cash-totalCost);
		return products;
	}
	
	public String getType() {
		return type;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (!(obj instanceof Provider))
			return false;
		Provider other = (Provider) obj;
		if (adress == null) {
			if (other.adress != null)
				return false;
		} else if (!adress.equals(other.adress))
			return false;
		if (type == null) {
			if (other.type != null)
				return false;
		} else if (!type.equals(other.type))
			return false;
		if (workingTime == null) {
			if (other.workingTime != null)
				return false;
		} else if (!workingTime.equals(other.workingTime))
			return false;
		return true;
	}

	private static void validateString(String string) {
		if(string==null || string.isEmpty()) {
			throw new IllegalArgumentException();
		}
	}
	
	private ArrayList<Product> generateProductsForCash(double cash){
		ArrayList<Product> products = new ArrayList<>();
		int attempts = 0;
		final int MAX_ATTEMPTS = 3;
		while(cash > 0 && attempts < MAX_ATTEMPTS) {
			Product p = Product.generateRandomProduct();
			if(cash-p.getCost()<0) {
				attempts++;
				continue;
			}
			products.add(p);
			cash-=p.getCost();
		}
		return products;
	}
	
	private double makeDiscount(double cash) {
		return cash*discount;
	}
	
}
