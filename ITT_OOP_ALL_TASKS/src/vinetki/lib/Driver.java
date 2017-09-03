package vinetki.lib;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Random;

public class Driver {
	private static int id;
	private String name;
	private double cash;
	private PetrolStation station;
	private ArrayList<Vehicle> vehicles;

	public Driver(String name, double cash, PetrolStation station) {
		this.name = name;
		this.cash = cash;
		this.station = station;
		this.vehicles = new ArrayList<Vehicle>(20);
	}

	public static Driver rndDriver(PetrolStation station, double minCash) {
		return new Driver("Driver" + (++id), minCash + new Random().nextInt(2000), station);
	}

	public void addVehicle(Vehicle vehicle) {
		this.vehicles.add(vehicle);
		vehicle.setOwner(this);
	}

	double payForVignette(Vignette vignette) {
		if (vignette != null && cash > vignette.getPrice()) {
			this.cash -= vignette.getPrice();
			return vignette.getPrice();
		}
		return 0;
	}

	public boolean buyVignetteForVehicle(int index, LocalDate date) {
		if (vehicles.size() < index || index < 0) {
			return false;
		}
		Vehicle vehicle = vehicles.get(index);
		String color = vehicle.getColorVignette();
		Vignette v = station.buyVignetteByColor(color, this);
		// time for set return!
		if (v != null) {
			vehicle.setVignette(v, date);
			return true;
		}
		System.out.println("Driver have not enough money!");
		return false;
	}

	public void buyVignetteForAll(LocalDate date) {
		for (int i = 0; i < vehicles.size(); i++) {
			buyVignetteForVehicle(i, date);
		}
	}

	public String info(LocalDate date) {
		StringBuilder sb = new StringBuilder();
		sb.append(String.format("Name:%s Cash:%.2f\n", name, cash));
		for (Vehicle v : vehicles) {
			sb.append("\t" + v.info(date) + "\n");
		}
		return sb.toString();
	}

	public String getName() {
		return name;
	}

}
