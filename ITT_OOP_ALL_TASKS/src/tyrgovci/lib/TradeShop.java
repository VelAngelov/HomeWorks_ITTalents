package tyrgovci.lib;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

/*
 * Търговските обекти съдържат следните характеристики:
• адрес
• работно време
• площ
• данък към държавата.
 */
/*
 * Търговски обекти биват:
1. сергия на пазара – площ между 2 и 10 квадратни метра. Годишен данък
към държавата в размер на 50 лева.
2. магазин в мола – площ между 10 и 100 квадратни метра. Годишен данък
към държавата в размер на 150 лева.
3. будка на улицата – площ между 4 и 6 квадратни метра. Годишен данък към
държавата в размер на 50 лева.
 */
public class TradeShop {
	/** 0-"STAND", 1-"MALL_SHOP", 2-"PAVILION" */
	public static final String[] SHOPS = {"STAND","MALL_SHOP","PAVILION"};
	/** 0-"STAND", 1-"MALL_SHOP", 2-"PAVILION" */
	public static final int[] MIN_AREA = {2, 10, 4};
	/** 0-"STAND", 1-"MALL_SHOP", 2-"PAVILION" */
	public static final int[] MAX_AREA = {10, 100, 6};
	/** 0-"STAND", 1-"MALL_SHOP", 2-"PAVILION" */
	public static final double[] TAX = {50, 150, 50};
	public static final double SELL_PRICE_FACTOR = 1.3;
	
	private String type;
	private String adress;
	private String workingTime;
	private int area;
	private double tax;
	private double cash;
	private ArrayList<Product> products;
	private Trader owner;
	
	private TradeShop(String type, String adress, String workingTime, int area, double tax) {
		this.type = type;
		this.adress = adress;
		this.workingTime = workingTime;
		this.area = area;
		this.tax = tax;
		products = new ArrayList<>();
	}
	
	public static TradeShop createNewStand(String adress, String workingTime) {
		validateString(adress);
		validateString(workingTime);
		int area = generateRandomArea(MIN_AREA[0], MAX_AREA[0]);
		validateArea(area, MIN_AREA[0], MAX_AREA[0]);
		return new TradeShop(SHOPS[0],adress, workingTime, area, TAX[0]);
	}
	
	public static TradeShop createNewMallShop(String adress, String workingTime) {
		validateString(adress);
		validateString(workingTime);
		int area = generateRandomArea(MIN_AREA[1], MAX_AREA[1]);
		validateArea(area, MIN_AREA[1], MAX_AREA[1]);
		return new TradeShop(SHOPS[1],adress, workingTime, area, TAX[1]);
	}
	
	public static TradeShop createNewPavilion(String adress, String workingTime) {
		validateString(adress);
		validateString(workingTime);
		int area = generateRandomArea(MIN_AREA[2], MAX_AREA[2]);
		validateArea(area, MIN_AREA[2], MAX_AREA[2]);
		return new TradeShop(SHOPS[2],adress, workingTime, area, TAX[2]);
	}
	
	public void sellRandomProducts() {
		int numberOfSoldProducts = new Random().nextInt(products.size()+1);
		if(numberOfSoldProducts == products.size()) {
			this.cash += Product.calculateTotalCostOfProducts(products)*SELL_PRICE_FACTOR;
			products = new ArrayList<>();
			return;
		}
		for (int i = 0; i < numberOfSoldProducts; i++) {
			Product p = products.remove(new Random().nextInt(products.size()));
			cash+=p.getCost();
		}
	}
	
	private static int generateRandomArea(int min,int max) {
		return min+new Random().nextInt(max-min+1);
	}
	
	public String getType() {
		return type;
	}
	
	public double getTax() {
		return tax;
	}
	
	public Trader getOwner() {
		return owner;
	}
	
	
	
	@Override
	public String toString() {
		return type + ", adress=" + adress + ", workingTime=" + workingTime + ", area=" + area
				+ ", cash=" + cash + "lv";
	}

	boolean setOwner(Trader trader) {
		if(this.owner == null || trader != null) {
			owner = trader;
			return true;
		}
		return false;
	}
	
	void addProducts(ArrayList<Product> products) {
		this.products.addAll(products);
		Collections.sort(products,Product.COMPARE_BY_PRICE);
	}
	
	private static void validateString(String string) {
		if(string==null || string.isEmpty()) {
			throw new IllegalArgumentException();
		}
	}
	
	private static void validateArea(double area, double areaMin, double areaMax) {
		if(area < areaMin || area > areaMax) {
			throw new IllegalArgumentException("Illegal area");
		}
	}

	double collectMoney() {
		double cash = this.cash;
		this.cash=0;
		return cash;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (!(obj instanceof TradeShop))
			return false;
		TradeShop other = (TradeShop) obj;
		if (adress == null) {
			if (other.adress != null)
				return false;
		} else if (!adress.equals(other.adress))
			return false;
		if (area != other.area)
			return false;
		if (Double.doubleToLongBits(cash) != Double.doubleToLongBits(other.cash))
			return false;
		if (Double.doubleToLongBits(tax) != Double.doubleToLongBits(other.tax))
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
	
	

}
