package music_instruments;

import java.util.Random;

import music_instruments.classes.InstrumentProvider;
import music_instruments.classes.MusicInstrument.KindsInstruments;
import music_instruments.classes.Shop;

/*
 */
public class Demo {
	public static Random rnd = new Random();

	public static void main(String[] args) {
		Shop shop = new Shop();
		for (int i = 0; i < 15; i++) {
			shop.addInstruments(KindsInstruments.values()[rnd.nextInt(KindsInstruments.values().length)],
					2 + rnd.nextInt(2), 500 + rnd.nextInt(1000));
		}
		shop.printCatalogByCount();
		soldRandomInstruments(10, shop);
		shop.printCatalogByCount();
//		shop.printSoldByCount();
//		shop.printMostSoldInstrument();

		// nishki:
		InstrumentProvider provider = new InstrumentProvider(shop, 5000);
		try {
			Thread.sleep(6000);
			provider.stopAutoDelivery();
		} catch (InterruptedException e) {
			System.out.println("oops");
		}
		System.out.println("after providing instruments:");
		shop.printCatalogByCount();
		System.out.println("Some clients buyed instruments:");
		soldRandomInstruments(15, shop);
		shop.printCatalogByCount();
	}

	public static void soldRandomInstruments(int number,Shop shop) {
		// Sold
		for (int i = 0; i < number; i++) {
			System.out.println("Sold " + shop
					.sellInstruments(KindsInstruments.values()[rnd.nextInt(KindsInstruments.values().length)], 1));
		}
	}
}
