package tyrgovci;

import tyrgovci.classes.*;

public class DemoTyrgovci {
	public static void main(String[] args) {
		// 1
		Provider[] providers = new Provider[10];
		for (int i = 0; i < 10; i++) {
			if (Validator.rnd(0, 2) == 0) {
				providers[i] = new Retail(null, null);
			} else {
				providers[i] = new WholeSeller(null, null);
			}
		}
		// 2
		ShopCenter[] shops = new ShopCenter[20];
		int chance;
		for (int i = 0; i < 20; i++) {
			chance = Validator.rnd(0, 3);
			if (chance == 0) {
				shops[i] = new ShopMall(null, null);
			} else if (chance == 1) {
				shops[i] = new Market(null, null);
			} else {
				shops[i] = new Pavilion(null, null);
			}
		}
		// 3
		Trader[] traders = new Trader[3];
		traders[0] = new AT("Petko", null, 100);
		traders[1] = new ET("Ivan", null, 500);
		traders[2] = new TV("Fantastiko", null, 3000);
		// 4
		for (ShopCenter s : shops) {
			if (traders[0].addShop(s)) {
				s.setOwner(traders[0]);
			} else if (traders[1].addShop(s)) {
				s.setOwner(traders[1]);
			} else {
				traders[2].addShop(s);
				s.setOwner(traders[2]);
			}
		}
		// 5
		for (Provider p : providers) {
			if (traders[0].addProvider(p)) {
			} else if (traders[1].addProvider(p)) {
			} else {
				traders[2].addProvider(p);
			}
		}
		for (Trader t : traders) {
			t.obslujiMagazini();
		}
	}
}
