package tyrgovci;

import java.util.Random;

import tyrgovci.lib.Provider;
import tyrgovci.lib.TradeShop;
import tyrgovci.lib.Trader;

/*
 * 1. Създава 10 доставчика на произволен принцип – на дребно и на едро.
2. Създава 20 търговски обекта на произволен принцип – сергии, магазини и
будки.
3. Създава един амбулантен търговец с капитал 100 лева, един ЕТ с капитал500 лева и една търговска верига с капитал 3000 лева.
4. Подава на търговците съответни търговски обекти на произволен
принцип.
5. Да се извика метод, който приема списък от създадените търговци и за
всеки търговец се започва търговска дейност. Търговската дейност
представлява:
+ поръчка на стоки от доставчик за всеки търговски обект. Да се извежда
на екрана списъка със стоки, сортиран по цена в нарастващ ред.
+ прибиране на оборот от всеки търговски обект – да се извежда на
екрана общата сума на печалбата. След продажба списъкът с
останалите стоки в магазина трябва отново да е сортиран по цена.
+ плащане на месечен данък към държавата за всеки търговски обект.
6. Да се изпише текущия паричен баланс на всеки обект след упражняването
на търговска дейност.
7. Да се изведе търговецът с най-голям брой продадени стоки за месеца.
8. Да се изведе търговецът с най-голям размер на изплатения данък към
държавата.
 */
public class Demo {
	public static void main(String[] args) {
		
		Provider[] providers = new Provider[20];
		for (int i = 0; i < providers.length; i++) {
			if(new Random().nextBoolean()) {
				providers[i] = Provider.createNewRetailer("adress"+i, "8:00-22:00");
			}else {
				providers[i] = Provider.createNewSuplier("adress"+i, "8:00-22:00");
			}
		}
		
		TradeShop[] shops = new TradeShop[20];
		for (int i = 0; i < shops.length; i++) {
			int rnd = new Random().nextInt(3);
			switch (rnd) {
			case 0:
				shops[i] = TradeShop.createNewPavilion("adress"+i, "8:00-22:00");
				break;
			case 1:
				shops[i] = TradeShop.createNewMallShop("adress"+i, "8:00-22:00");
				break;
			default:
				shops[i] = TradeShop.createNewStand("adress"+i, "8:00-22:00");
				break;
			}
		}
		
		Trader[] traders = new Trader[3];
		traders[0] = Trader.createNewAmbulantTarder("AdressAmbulantTrader", 100);
		traders[1] = Trader.createNewETTrader("AdressETTrader", 500);
		traders[2] = Trader.createNewChainTrader("AdressChainTrader", 3000);
		
		for (int i = 0; i < shops.length; i++) {
			TradeShop shop = shops[i];
			int attmepts = 0;
			while(shop!=null&&attmepts<10) {
				int rnd = new Random().nextInt(3);
				if(rnd==0) {
					shop = traders[0].addTradeShop(shop);
				}else if(rnd==1){
					shop = traders[1].addTradeShop(shop);
				}else {
					shop = traders[2].addTradeShop(shop);
				}
				attmepts++;
			}
		}

		for (int i = 0; i < providers.length; i++) {
			Provider provider = providers[i];
			int attmepts = 0;
			while(provider != null && attmepts<10) {
				int rnd = new Random().nextInt(3);
				if(rnd==0) {
					provider = traders[0].addProvider(provider);
				}else if(rnd==1) {
					provider = traders[1].addProvider(provider);
				}else {
					provider = traders[2].addProvider(provider);
				}
				attmepts++;
			}
		}
		
		playTraders(traders);
		
		
		int indexMaxBalance = 0;
		int indexMaxTaxtPayed = 0;
		for (int i = 0; i < traders.length; i++) {
			System.out.println(traders[i].getType() + " balance "+ traders[i].getCash() + "lv");
			if(traders[indexMaxBalance].getCash() < traders[i].getCash()) {
				indexMaxBalance = i;
			}
			if(traders[indexMaxTaxtPayed].getPayedTaxes() < traders[i].getPayedTaxes()) {
				indexMaxTaxtPayed = i;
			}
		}
		
		System.out.println(traders[indexMaxBalance] + "Max Balance = " + traders[indexMaxBalance].getCash()+"lv");
		System.out.println(traders[indexMaxTaxtPayed] + "Max tax payed = " + traders[indexMaxTaxtPayed].getPayedTaxes()+"lv");
		
	}
	public static void playTraders(Trader[] traders) {
		for(Trader t:traders) {
			//1
			t.orderProductsForAllShops();
			t.shopsSellProducts();
			//2
			t.collectMoneyFromShops();
			//3
			t.payTaxForShops();
		}
	}
}
