package vinetki2.lib;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Random;

import vinetki2.lib.Vignette.VignettePeriod;

/*
 * Шофьорът има следните характеристики:
 Име,
 Списък с превозни средства, за които отговаря,
 Пари,
 Бензиностанция, от която пазарува.
Шофьорите могат да си купуват винетки за всички превозни средства, които
управляват. Освен това могат да купуват и винетка само за определено превозно
средство по номер (примерно първото) и за определен срок.
Когато шофьор купува винетка, той се обръща към бензиностанцията, в която
пазарува и изпълнява съответната операция.
Това намалява парите му и освен това той задава новата винетка на съответното
превозно средство, за което я е купил.
Последната операция, която извършват шофьорите, е по даден ден, месец и
година – текуща дата, да върнат списък с всички свои превозни средства с
изтекли винетки

5. Да се изведе информация за всички шофьори – колко коли карат, колко от
техните превозни средства имат винетка с изтичащ срок за дадена дата и колко
пари са им останали. - 15т.
 */
public class CarDriver {
	public static Random rnd = new Random();
	private String name;
	private ArrayList<Vehicle> vehicles;
	private int cash;
	private PetrolStation station;
	
	public CarDriver(String name, int cash, PetrolStation station) {
		this.name = name;
		this.cash = cash;
		this.station = station;
		this.vehicles = new ArrayList<>();
	}
	
	public void buyVignetteForAllVehicles(LocalDate date) {
		for (int i = 0; i < vehicles.size(); i++) {
			buyVignetteForVehicleNumberForPeriodAndSet(i, VignettePeriod.values()[rnd.nextInt(VignettePeriod.values().length)],date);
		}
	}
	
	public void buyVignetteForVehicleNumberForPeriodAndSet(int numberInList,VignettePeriod period,LocalDate date) {
		if(this.station==null) {
			System.out.println("Driver is not in petrolStation !");
			return;
		}
		Vehicle vehicle = this.vehicles.get(numberInList);
		buyAndSetVignetteFromPetrolStationForVehicle(vehicle, period, date);
	}
	
	public void goToPetrolStation(PetrolStation station) {
		this.station = station;
	}
	
	void buyAndSetVignetteFromPetrolStationForVehicle(Vehicle v,VignettePeriod period,LocalDate date) {
		Vignette vignette=station.sellVignette(this, v.getType(), period, date);
		setVignetteToVehicle(v,vignette,date);
		return;
	}
	
	void setVignetteToVehicle(Vehicle vehicle,Vignette vignette,LocalDate date){
		vignette.setOnVehicle(vehicle, date);
	}
	
	public ArrayList<Vehicle> withExpiredVignette(LocalDate date){
		ArrayList<Vehicle> expared = new ArrayList<>();
		for(Vehicle v:this.vehicles) {
			if(v.isExpiredVignetteForDate(date)) {
				expared.add(v);
			}
		}
		return expared;
	}

	boolean hasCash(int price) {
		return this.cash>price;
	}

	void removeCash(int price) {
		this.cash-=price;
	}

	public void addVehicle(Vehicle v) {
		this.vehicles.add(v);
	}

	@Override
	public String toString() {
		return  name + ", vehiclesNumber=" + vehicles.size() + ", cash=" + cash + "lv";
	}

	public void printInfo() {
		StringBuilder sb = new StringBuilder(this.toString());
		for(Vehicle v:vehicles) {
			sb.append("\n\t"+v);
		}
		System.out.println(sb);
	}
}
