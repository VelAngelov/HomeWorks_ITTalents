package vinetki.lib;

import java.time.LocalDate;
import java.util.Random;

public class Vignette implements Comparable<Vignette> {
	private LocalDate date;
	private String color;
	private String period;
	private double price;
	private LocalDate expire;

	public static final String[] PERIODS = { "DAY", "WEEK", "MONTH", "YEAR" };
	// Colors respond to Car,Bus,Truck:
	public static final String[] COLORS = { "GREEN", "BLUE", "BLACK" };

	private Vignette(String color, String period) {
		this.color = color;
		this.period = period;
		calculatePrice(color, period);
	}

	private void calculatePrice(String color, String period) {
		int ratio = calculateRatioForPriceByPeriod(period);
		this.price = ratio * priceForOneDayByColor(color);
	}

	private int priceForOneDayByColor(String color) {
		if (color.equals("GREEN")) {
			return 5;
		} else if (color.equals("BLUE")) {
			return 20;
		} else if (color.equals("BLACK")) {
			return 10;
		} else {
			return 0;
		}
	}

	private int calculateRatioForPriceByPeriod(String period) {
		if (period.equals(PERIODS[0])) {
			// for one day
			return 1;
		} else if (period.equals(PERIODS[1])) {
			// for one week
			return 1 * 5;
		} else if (period.equals(PERIODS[2])) {
			// for one month
			return 1 * 5 * 4;
		} else if (period.equals(PERIODS[3])) {
			return 1 * 5 * 4 * 10;
		} else {
			return -1;
		}
	}

	// calculating period of expire:
	private boolean calculateExpireDay(String period) {
		if (period.equals(PERIODS[0])) {
			this.expire = date.plusDays(1);
		} else if (period.equals(PERIODS[1])) {
			this.expire = date.plusDays(7);
		} else if (period.equals(PERIODS[2])) {
			this.expire = date.plusMonths(1);
		} else if (period.equals(PERIODS[3])) {
			this.expire = date.plusYears(1);
		} else {
			return false;
		}
		return true;
	}

	@Override
	public int compareTo(Vignette o) {
		return (int) ((this.price - o.price) * 100);
	}

	public static Vignette rndVignette() {
		int color = new Random().nextInt(COLORS.length);
		int period = new Random().nextInt(PERIODS.length);
		return new Vignette(COLORS[color], PERIODS[period]);
	}

	public double getPrice() {
		return price;
	}

	public LocalDate getExpire() {
		return expire;
	}

	@Override
	public String toString() {
		return String.format("Vignette price:%.2f color:%s period:%s", price, color, period);
	}

	int setToVehicle(LocalDate date, Vehicle vehicle) {
		if (this.color.equals(vehicle.getColorVignette())) {
			this.date = date;
			calculateExpireDay(period);
			if (vehicle.getModel().equals(Vehicle.MODELS[0])) {
				return 5;
			} else if (vehicle.getModel().equals(Vehicle.MODELS[1])) {
				return 20;
			} else if (vehicle.getModel().equals(Vehicle.MODELS[2])) {
				return 10;
			}
		}
		return -1;
	}

	public String getColor() {
		return color;
	}

	public LocalDate getDate() {
		return date;
	}
	public String getPeriod() {
		return period;
	}
	public boolean isValid(LocalDate date) {
		return expire.compareTo(date)>0;
	}

}
