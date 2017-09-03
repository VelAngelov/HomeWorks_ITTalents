package vinetki2.lib;

import java.time.LocalDate;

import vinetki2.lib.Vehicle.Vehicles;

/*
 * Всяко превозно средство има следните характеристики:
 Модел на превозното средство ,
 Винетка, която е залепена на стъклото му,
 Година на производство.
Превозните средства биват : кола, автобус, камион

3. Създаване на 200 превозни средства от произволен тип (кола, автобус,
камион) и на всеки шофьор да се дадат по 10 от тях като всяко превозно средство
се управлява от един шофьор. - 10т.
 */
public class Vehicle {
	public enum Vehicles{
		CAR,BUS,TRUCK
	}
	
	private String model;
	private LocalDate manufactorDay;
	private Vehicles type;
	private Vignette vignette;
	private CarDriver owner;
	
	public Vehicle(String model, LocalDate manufactorDay, Vehicles type, Vignette vignette, CarDriver owner) {
		this.model = model;
		this.manufactorDay = manufactorDay;
		this.type = type;
		this.vignette = vignette;
		this.owner = owner;
	}

	public Vehicles getType() {
		return type;
	}
	
	public boolean isExpiredVignetteForDate(LocalDate date) {
		if(this.vignette==null) {
			return true;
		}
		return this.vignette.isExpired(date);
	}

	@Override
	public String toString() {
		return "Vehicle [model=" + model + ", manufactorDay=" + manufactorDay + ", type=" + type + ", vignette="
				+ vignette + ", owner=" + owner + "]";
	}

	void setVignette(Vignette vignette2) {
		this.vignette = vignette2;
	}
	
}
