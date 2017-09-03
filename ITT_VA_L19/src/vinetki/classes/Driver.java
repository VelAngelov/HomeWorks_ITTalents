package vinetki.classes;

import java.util.ArrayList;

public class Driver {
	String name;
	double cash;
	Station station;
	ArrayList<Vehicle> vehicles;

	public Driver(String name, double cash, Station station) {
		this.name = name;
		this.cash = cash > 0 ? cash : 0;
		this.station = station;
		this.vehicles = new ArrayList<Vehicle>();
	}

	public void addVehicle(Vehicle v) {
		this.vehicles.add(v);
	}

	public boolean buyVinetkaByIndex(int index, String validnost, String date) {
		if (index >= vehicles.size()) {
			return false;
		}
		Vehicle vehicle = vehicles.get(index);
		String typeVehicle = vehicle.getType();
		Vinetka vinetka = this.station.sellVinetka(typeVehicle, validnost);
		cash -= vinetka.price;
		station.cash += vinetka.price;
		vehicle.setVinetka(vinetka);
		return true;
	}

	public void buyVinetki(String validnost, String date) {
		for (int i = 0; i < vehicles.size(); i++) {
			buyVinetkaByIndex(i, validnost, date);
		}
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append(String.format("Driver:%s\nVehicles:\n", this.name));
		for (Vehicle v : vehicles) {
			sb.append(v + "\n");
		}
		sb.append("cash:" + cash + "lv\n");
		return sb.toString();
	}
}
