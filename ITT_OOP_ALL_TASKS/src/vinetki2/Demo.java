package vinetki2;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Random;

import vinetki2.lib.PetrolStation;
import vinetki2.lib.Vehicle.Vehicles;
import vinetki2.lib.Vignette.VignettePeriod;
import vinetki2.lib.*;

/*
 * 1. Създаване на бензиностанция с автоматично генерирани винетки. Да се
изведат на екрана, заедно с техните цена и цвят. - 5т.
2. Създаване на 20 шофьора с произволни имена. Да им се дадат произволна
стойност пари. Да им се зададе бензиностанция, от която да пазаруват винетки. -
5т.
3. Създаване на 200 превозни средства от произволен тип (кола, автобус,
камион) и на всеки шофьор да се дадат по 10 от тях като всяко превозно средство
се управлява от един шофьор. - 10т.
4. Всеки 3-ти шофьор на произволен принцип за някои превозни средства да
купи 5 винетки за произволно генериран срок (ден, месец, година). Останалите
шофьори да купят винетки за всичките си превозни средства за произволно
генериран срок. - 10т.
5. Да се изведе информация за всички шофьори – колко коли карат, колко от
техните превозни средства имат винетка с изтичащ срок за дадена дата и колко
пари са им останали. - 15т.
6. Да се изведат всички останали винетки в бензиностанцията в сортиран по цена
ред. -5т.
7. Да се изведат всички камиони, които имат изтекли винетки за дадена дата.
 */
public class Demo {
	public static Random rnd = new Random();
	public static void main(String[] args) {
		//1
		PetrolStation stancia = new PetrolStation(LocalDate.now());
//		stancia.printVignettes();
		//2
		ArrayList<CarDriver> drivers = new ArrayList<>();
		for (int i = 0; i < 20; i++) {
			drivers.add(new CarDriver("Driver"+i, 5000+rnd.nextInt(15000), stancia));
		}
		//3
		ArrayList<Vehicle> vehicles = new ArrayList<>();
		for (int i = 0; i < 200; i++) {
			CarDriver d = drivers.get(i/10);
			Vehicle v = new Vehicle("Mercedes", LocalDate.of(1995, 4, 15),
					Vehicles.values()[rnd.nextInt(Vehicles.values().length)], null, d);
			d.addVehicle(v);
			vehicles.add(v);
		}
		//4
		/*
		 * 4. Всеки 3-ти шофьор на произволен принцип за някои превозни средства да
купи 5 винетки за произволно генериран срок (ден, месец, година). Останалите
шофьори да купят винетки за всичките си превозни средства за произволно
генериран срок. - 10т.
		 */
		LocalDate newDate = LocalDate.now().plusDays(52);
		for (int i = 0; i < 20; i++) {
			CarDriver d = drivers.get(i);
			if(i%3==0) {
				for (int j = 0; j < 5; j++) {
					d.buyVignetteForVehicleNumberForPeriodAndSet(rnd.nextInt(10), VignettePeriod.values()[rnd.nextInt(VignettePeriod.values().length)],
							newDate);
				}
			}else {
				d.buyVignetteForAllVehicles(newDate);
			}
		}
		//5
		for (CarDriver d:drivers) {
			d.printInfo();
		}
		//6
//		stancia.printVignettes();
		//7
		newDate= newDate.plusDays(20);
		System.out.println(newDate);
		for(Vehicle v:vehicles) {
			if(v.getType().equals(Vehicles.TRUCK)&&v.isExpiredVignetteForDate(newDate)) {
				System.out.println(v);
			}
		}
		
	}
}
