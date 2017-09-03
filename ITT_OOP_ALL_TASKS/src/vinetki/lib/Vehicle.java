package vinetki.lib;

import java.time.LocalDate;
import java.util.Random;

public class Vehicle {
	private String colorVignette;
	private String model;
	private Vignette vignette;
	private String yearOfCreation;
	private Driver owner;
	public static final String[] MODELS = { "CAR", "BUS", "TRUCK" };

	public Vehicle(String model, String yearOfCreation) {
		this.model = model;
		this.yearOfCreation = yearOfCreation;
		setColorVignette();
	}

	private boolean setColorVignette() {
		if (this.model.equals(MODELS[0])) {
			colorVignette = Vignette.COLORS[0];
		} else if (this.model.equals(MODELS[1])) {
			colorVignette = Vignette.COLORS[1];
		} else if (this.model.equals(MODELS[2])) {
			colorVignette = Vignette.COLORS[2];
		} else {
			return false;
		}
		return true;
	}

	public String getColorVignette() {
		return colorVignette;
	}

	public String getModel() {
		return model;
	}

	public static Vehicle rndVehicle() {
		String[] years = { "1991", "1992", "1995", "1998", "2000", "2002", "2005", "2007", "2010", "2012", "2015" };
		return new Vehicle(MODELS[new Random().nextInt(MODELS.length)], years[new Random().nextInt(years.length)]);
	}

	void setOwner(Driver owner) {
		this.owner = owner;
	}

	int setVignette(Vignette vignette, LocalDate date) {
		this.vignette = vignette;
		return vignette.setToVehicle(date, this);
	}

	public boolean isValidVignetteForDate(LocalDate date) {
		if (vignette == null) {
			return false;
		}
		return vignette.isValid(date);
	}

	public String info(LocalDate date) {
		StringBuilder sb = new StringBuilder();
		sb.append(String.format("Model:%s, %s,", model, yearOfCreation));
		if (vignette == null) {
			sb.append("no vignette");
		} else {
			sb.append(String.format("Vignette setDate:%s,type:%s-expireDate:%s(%s)", vignette.getDate().toString(),
					vignette.getPeriod(), vignette.getExpire().toString(),
					vignette.isValid(date) ? "valid" : "not valid"));
		}
		return sb.toString();
	}

	public Driver getOwner() {
		return owner;
	}
}
