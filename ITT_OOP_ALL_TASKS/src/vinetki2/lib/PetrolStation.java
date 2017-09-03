package vinetki2.lib;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Random;

import vinetki2.lib.Vehicle.Vehicles;
import vinetki2.lib.Vignette.VignettePeriod;
import vinetki2.lib.Vignette.VignetteVehicle;

/*
 * Всяка бензиностанция има следните характеристики:
 Оборот за деня,
 Списък с винетки, налични за продажба
Бензиностанцията има следните операции :
• при създаване да генерира на произволен принцип 10 000 винетки от
всякакъв тип (за кола, за камион, за автобус, дневни, месечни, годишни).
Изисква се бензиностанцията да поддържа този списък постоянно
сортиран по цена.
• Бензиностанцията има и операция за продажба на винетка за определено
превозно средство и за даден период (дневна, месечна, годишна). След
продажба на винетка останалите трябва да останат, отново в сортирана
последователност.

1. Създаване на бензиностанция с автоматично генерирани винетки. Да се
изведат на екрана, заедно с техните цена и цвят. - 5т.
 */
public class PetrolStation {
	private static final int INITIAL_VIGNETTES = 10_000;
	private static Random rnd = new Random();
	private HashMap<LocalDate,Integer> cash;
	private ArrayList<Vignette> vignettes;
	
	
	
	public PetrolStation(LocalDate date) {
		this.cash = new HashMap<>();
		this.vignettes = new ArrayList<>(INITIAL_VIGNETTES);
		generateVignettes(date);
	}
	public void printVignettes() {
		for(Vignette v:vignettes) {
			System.out.println(v.toString());
		}
	}

	private void generateVignettes(LocalDate date) {
		for (int i = 0; i < INITIAL_VIGNETTES; i++) {
			Vignette v = new Vignette(VignetteVehicle.values()[rnd.nextInt(VignetteVehicle.values().length)],
					VignettePeriod.values()[rnd.nextInt(VignettePeriod.values().length)], date);
			this.vignettes.add(v);
		}
		Collections.sort(this.vignettes, Vignette.COMPARE_BY_PRICE);
	}
	
	Vignette sellVignette(CarDriver driver,Vehicles type,VignettePeriod period,LocalDate date) {
		VignetteVehicle vehicle = null;
		if(type==Vehicles.BUS) {
			vehicle=VignetteVehicle.BLUE;
		}else if(type==Vehicles.CAR) {
			vehicle=VignetteVehicle.RED;
		}else {
			vehicle=VignetteVehicle.GREEN;
		}
		
		Vignette wanted = new Vignette(vehicle, period, date);
		int index=this.vignettes.indexOf(wanted);
		if(index!=-1) {
			wanted = this.vignettes.get(index);
			if(driver.hasCash(wanted.getPrice())) {
				this.vignettes.remove(index);
				addCash(date, wanted.getPrice());
				driver.removeCash(wanted.getPrice());
				return wanted;
			}
		}
		return null;
	}
	void addCash(LocalDate date,int cash) {
		if(this.cash.containsKey(date)) {
			this.cash.put(date,this.cash.get(date)+cash);
		}else {
			this.cash.put(date, cash);
		}
	}
}
