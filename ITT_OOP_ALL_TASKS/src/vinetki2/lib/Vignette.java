package vinetki2.lib;

import java.time.LocalDate;
import java.util.Comparator;

import vinetki2.lib.Vehicle.Vehicles;

/*
 * Всяка винетка има следните характеристики:
 Дата на издаване – ден, месец и година
 Цвят
 Срок на валидност – дневна, месечна или годишна.
 * Винетките биват три вида – за кола, за камион, за автобус. Всички винетки за
коли са с един и същ цвят. Аналогично и за камиони и автобуси.
Операциите, които се изпълняват върху винетките са :
• да се залепи на стъклото,
• да й се вземе цената.
Цената на дневна винетка за кола е 5 лв, за камион – 7 лв., за автобус – 9 лв.
Цените за месец се получават като цените за седмица се умножат по 10.
Цените за година се получават като месечните цени се умножат по 6.
Операцията за залепване връща като резултат колко време отнема една винетка
да се залепи – 5 секунди за кола, 10 за камион и 20 за автобус.
 */
public class Vignette {
	public static final Comparator<Vignette> COMPARE_BY_PRICE = (o1,o2)-> o1.getPrice()-o2.getPrice();
	public enum VignetteVehicle{
		/** CAR*/
		RED(Vehicles.CAR,5),
		/** BUS*/
		BLUE(Vehicles.BUS,7),
		/** TRUCK*/
		GREEN(Vehicles.TRUCK,9);
		private Vehicles type;
		private int priceForWeek;
		private VignetteVehicle(Vehicles v,int priceForWeek) {
			this.type = v;
			this.priceForWeek=priceForWeek;
		}
		public int getPriceForWeek() {
			return priceForWeek;
		}
		public Vehicles getType() {
			return type;
		}
	}
	public enum VignettePeriod{
		WEEK(1,7),MONTH(10,30),YEAR(10*6,365);
		private int coeficient;
		private int periodInDays;
		private VignettePeriod(int coeficient,int periodInDays) {
			this.coeficient = coeficient;
			this.periodInDays = periodInDays;
		}
		public int getCoeficient() {
			return coeficient;
		}
		public int getPeriodInDays() {
			return periodInDays;
		}
	}
	private VignetteVehicle color;
	private VignettePeriod period;
	private LocalDate dateOfExsecute;
	
	private LocalDate dateExpire;
	private int price;
	
	public Vignette(VignetteVehicle type, VignettePeriod period, LocalDate dateOfExsecute) {
		this.color = type;
		this.period = period;
		this.dateOfExsecute = dateOfExsecute;
		
		this.price = period.getCoeficient()*(type.getPriceForWeek());
		this.dateExpire = dateOfExsecute.plusYears(1);
	}
	/** return -1 if operation is unsuccesfull;*/
	public int setOnVehicle(Vehicle v,LocalDate date) {
		if(this.color.getType()!=v.getType()) {
			return -1;
		}
		if(date.plusDays(this.period.getPeriodInDays()).isBefore(dateExpire)) {
			this.dateExpire = date.plusDays(this.period.getPeriodInDays());
		}
		v.setVignette(this);
		if(this.color.getType()==Vehicles.CAR) {
			return 5;
		}else if(this.color.getType()==Vehicles.BUS){
			return 10;
		}
		return 20;
	}
	public Vehicles aplicableFor() {
		return this.color.getType();
	}
	public boolean isExpired(LocalDate date) {
		return date.isAfter(this.dateExpire);
	}
	public int getPrice() {
		return price;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (!(obj instanceof Vignette))
			return false;
		Vignette other = (Vignette) obj;
		if (period != other.period)
			return false;
		if (price != other.price)
			return false;
		if (color != other.color)
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "Vignette color=" + color + ", period=" + period + ", dateOfExsecute=" + dateOfExsecute + ", dateExpire="
				+ dateExpire + ", price=" + price + "lv";
	}
	
	
	
}
