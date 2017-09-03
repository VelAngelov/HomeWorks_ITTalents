package tyrgovci.lib;

import java.util.ArrayList;
import java.util.Random;

/*
 * Всеки търговец съдържа в себе си следните характеристики:
• Наименование
• Адрес на регистрация
• Капитал – начална сума за започване на бизнес.
• Търговски обект, където оперира (един или няколко)
• Доставчик, от който зарежда стоки (един или няколко)
 */
/*
 * В София оперират различни видове търговци:
• Амбулантен търговец – той не оперира в определен търговски обект и
работи с един доставчик на дребно.
• ЕТ – едноличен търговец – той оперира само с доставчици на дребно (не
повече от 5) и притежава един търговски обект. ЕТ може да притежава
бутка на улицата или сергия на пазара.
• Търговска верига – работи с много доставчици на дребно и на едро (не
повече от 15) и има много търговски обекти (не повече от 10). Притежава
както будки, така и магазини в моловете.
 */
/*
 * Всеки търговец може да изпълнява следните действия:
• да прави поръчка на определена стойност към доставчик. Поръчката не
може да надвишава 50% от капитала на търговеца. Ако доставчика
направи отстъпка, разликата в парите да се върне обратно на търговеца.
При поръчка на стоки от доставчик, търговеца приема в търговския обект
списък с произволно генериран брой продукти, като всеки продукт има
наименование и произволна цена между 5 и 15 лева. Общата цена на
продуктите представлява стойността на доставката.
• да прибира оборот от търговския обект – 130% от стойността на
поръчаните стоки. (дефакто търговците имат 30% надценка). Оборотът
представлява печалбата от произволен брой продадени артикули.
• да плаща данъци на държавата за съответния търговски обект.
 */
public abstract class Trader {
	/** 0-"AMBULANT",1-"ET",2-"TRADE_CHAIN"*/
	public static final String[] TRADERS = {"AMBULANT_TARDER","ET_TRADER","TRADE_CHAIN"};
	
	private String type;
	private String adress;
	protected double cash;
	protected ArrayList<Provider> providers;
	protected ArrayList<TradeShop> shops;
	private double payedTaxes;
	
	protected Trader(String type, String adress, double cash) {
		this.type = type;
		this.adress = adress;
		this.cash = cash;
		this.providers = new ArrayList<>();
		this.shops = new ArrayList<>();
	}
	
	public static Trader createNewAmbulantTarder(String adress,double cash) {
		validateString(adress);
		validateCash(cash);
		return new AmbulantTrader(adress, cash);
	}
	
	public static Trader createNewETTrader(String adress,double cash) {
		validateString(adress);
		validateCash(cash);
		return new EtTrader(adress, cash);
	}
	
	public static Trader createNewChainTrader(String adress,double cash) {
		validateString(adress);
		validateCash(cash);
		return new ChainTrader(adress, cash);
	}
	
	/** return provider if it is not added*/
	public abstract Provider addProvider(Provider provider);
	
	/** return tradeShop if it is not added*/
	public abstract TradeShop addTradeShop(TradeShop tradeShop);
	
	@Override
	public String toString() {
		return "Trader " + type + ", adress=" + adress;
	}
	
	public void orderProductsForAllShops() {
		//Overrides in AmbulantTrader
		for(TradeShop shop : shops) {
			Provider p = providers.get(new Random().nextInt(providers.size()));
			makeOrderWithProviderForShop(shop, p);
		}
	}
	
	public void collectMoneyFromShops() {
		//Overrides in AmbulantTrader
		for(TradeShop shop : shops) {
			double money = shop.collectMoney();
			System.out.println(this +"collect "+ money+"lv from " + shop );
			this.cash += money;
		}
	}
	public void payTaxForShops() {
		//Overrides in AmbulantTrader
		for(TradeShop shop : shops) {
			double money = shop.getTax();
			System.out.println(this +"pay "+ money+"lv for " +shop);
			this.payedTaxes+=money;
			this.cash -= money;
		}
	}
	
	public void shopsSellProducts() {
		//Overrides in AmbulantTrader
		for(TradeShop shop : shops) {
			shop.sellRandomProducts();
		}
	}
	
	public double getCash() {
		return cash;
	}
	
	public double getPayedTaxes() {
		return payedTaxes;
	}
	
	public String getType() {
		return type;
	}
	
	protected void addProductsInShop(TradeShop shop,ArrayList<Product> products) {
		//Overrides in AmbulantTrader
		System.out.println("Shop:"+shop.getType()+"with owner "+ this + "add products:");
		Product.printProductsWithAscPrice(products);
		shop.addProducts(products);
	}
	
	void addCash(double cash) {
		this.cash += cash;
	}
	
	protected void makeOrderWithProviderForShop(TradeShop shop, Provider provider) {
		double maxCostOfProducts = this.cash*0.5;
		this.cash-=maxCostOfProducts;
		validateCash(this.cash);
		addProductsInShop(shop, provider.productsForCash(this, maxCostOfProducts));
	}
	
	private static void validateString(String string) {
		if(string==null||string.isEmpty()) {
			throw new IllegalArgumentException();
		}
	}
	
	private static void validateCash(double cash) {
		if(cash<0) {
			throw new IllegalArgumentException("cash cant be <0!");
		}
	}

}
