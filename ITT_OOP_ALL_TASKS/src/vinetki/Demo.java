package vinetki;

import java.time.LocalDate;
import java.util.Random;

import vinetki.lib.Driver;
import vinetki.lib.PetrolStation;
import vinetki.lib.Vehicle;

public class Demo {
	public static void main(String[] args) {
		// 1.
		PetrolStation petrol = new PetrolStation();
		// petrol.printVignettes();
		// 2.
		Driver[] drivers = new Driver[20];
		for (int i = 0; i < drivers.length; i++) {
			drivers[i] = Driver.rndDriver(petrol, 30000);
		}
		// 3.
		Vehicle[] vehicles = new Vehicle[200];

		for (int i = 0; i < vehicles.length; i++) {
			vehicles[i] = Vehicle.rndVehicle();
		}
		for (int i = 0; i < drivers.length; i++) {
			for (int j = 0; j < 10; j++) {
				drivers[i].addVehicle(vehicles[i * 10 + j]);
			}
		}
		// 4.
		LocalDate present = LocalDate.of(2016, 1, 1);
		int chance;
		for (int i = 0; i < drivers.length; i += 3) {
			chance = new Random().nextInt(3);
			for (int j = 0; j < 3 && (j + i < drivers.length); j++) {
				if (chance == j) {
					for (int k = 0; k < 5; k++) {
						drivers[i + j].buyVignetteForVehicle(new Random().nextInt(10), present);
					}
				} else {
					drivers[i + j].buyVignetteForAll(present);
				}
			}
		}
		// 5.
		present = present.plusDays(100);
		System.out.println(present.toString());
		for (Driver d : drivers) {
			System.out.println(d.info(present));
		}
		// 6.
		// petrol.printVignettes();
		// 7.
		for (int i = 0; i < vehicles.length; i++) {
			if (vehicles[i].getModel().equals(Vehicle.MODELS[2])) {
				if (!vehicles[i].isValidVignetteForDate(present)) {
					System.out.println(vehicles[i].info(present) + "-Owner: " + vehicles[i].getOwner().getName());
				}
			}
		}
		System.out.println("petrol station cash:" + petrol.getCash());
	}
}
