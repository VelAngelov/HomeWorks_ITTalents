package vinetki;

import vinetki.classes.*;

public class DemoVinetki {
	public static void main(String[] args) {
		// 1
		Station petrol = new Station("01/01/2017", 10000);
		// System.out.println(petrol);
		// 2:
		Driver[] drivers = new Driver[20];
		for (int i = 0; i < drivers.length; i++) {
			drivers[i] = new Driver("Driver" + i, Rnd.rnd(8000, 10000), petrol);
		}
		// 3
		Vehicle[] vehicles = new Vehicle[200];
		int chance;
		for (int i = 0; i < vehicles.length; i++) {
			chance = Rnd.rnd(0, 3);
			if (chance == 0) {
				vehicles[i] = new Car("05.03.2002");
			} else if (chance == 1) {
				vehicles[i] = new Bus("15.03.1999");
			} else {
				vehicles[i] = new Truck("26.08.1995");
			}
		}
		for (int i = 0; i < drivers.length; i++) {
			for (int j = 0; j < 10; j++) {
				drivers[i].addVehicle(vehicles[i * 10 + j]);
			}
		}
		// 4
		String date = "15/01/2017";
		String[] validnosti = { "day", "month", "year" };
		for (int i = 0; i < drivers.length; i += 3) {
			chance = Rnd.rnd(0, 3);
			for (int j = 0; j < 3 && (j + i < drivers.length); j++) {
				if (chance == j) {
					for (int k = 0; k < 5; k++) {
						drivers[i + j].buyVinetkaByIndex(k, validnosti[chance], date);
					}
				} else {
					drivers[i + j].buyVinetki(validnosti[chance], date);
				}
			}
		}
		// 5
		for (Driver d : drivers) {
			System.out.println(d);
		}
		// 6
		// System.out.println(petrol);
		// 7:
		String today = "18/01/2017";
		int validYear;
		int validMonth;
		int validDay;
		for (Vehicle v : vehicles) {
			if (v.getType().equals("truck")) {
				Vinetka vinetka = v.getVinetka();
				if (vinetka == null) {
					System.out.println("Truck withous vinetka");
				} else {
					System.err.println();
//					validYear = Integer.parseInt(vinetka.getValidnost().substring(7));
//					validYear = Integer.parseInt(vinetka.getValidnost().substring(7));
//					validYear = Integer.parseInt(vinetka.getValidnost().substring(7));
				}
			}
		}
	}
}
