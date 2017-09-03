package music_instruments;

import java.util.Random;

import music_instruments.lib.MusicalShop;
import music_instruments.lib.instruments.MusicalInstrument;

public class Demo {
	public static void main(String[] args) {
		MusicalShop shop = new MusicalShop();
		//generate instruments
		for (int i = 0; i <100; i++) {
			shop.addNewInstrument(MusicalInstrument.createRandomInstrument(200+new Random().nextInt(2000)));
		}
		//for sale lists:
		System.out.println("=====================================");
		shop.printForSaleInstrumentByType();
		System.out.println("=====================================");
		shop.printForSaleInstrumentByName();
		System.out.println("=====================================");
		shop.printForSaleInstrumentByPrice(true);
		System.out.println("=====================================");
		shop.printForSaleInstrumentByPrice(false);
		
		//Sell instrument:
		System.out.println("SELL INSTRUMENTS");
		for(int i = 0; i<2;i++) {
			shop.buyMusicalInstrumentByName(MusicalInstrument.STRINGS[new Random().nextInt(MusicalInstrument.STRINGS.length)]);
			shop.buyMusicalInstrumentByName(MusicalInstrument.PERCUSSION[new Random().nextInt(MusicalInstrument.PERCUSSION.length)]);
			shop.buyMusicalInstrumentByName(MusicalInstrument.BRASS[new Random().nextInt(MusicalInstrument.BRASS.length)]);
			shop.buyMusicalInstrumentByName(MusicalInstrument.ELECTRONIC[new Random().nextInt(MusicalInstrument.ELECTRONIC.length)]);
			shop.buyMusicalInstrumentByName(MusicalInstrument.KEYBOARDS[new Random().nextInt(MusicalInstrument.KEYBOARDS.length)]);
		}
		
		//info cash in shop:
		System.out.println("TOTAL CASH IN SHOP");
		System.out.println(shop.getCash()+"lv");
		
		//top sold items:
		System.out.println("=====================================");
		shop.printSoldInstrumentsByNumberOfSales();
		System.out.println("=====================================");
		shop.printInstrumentsByPriceEarnFromSale();
	}
}
