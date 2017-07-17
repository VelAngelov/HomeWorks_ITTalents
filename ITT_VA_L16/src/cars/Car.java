package cars;

public class Car {
	private String model;
	private int maxSpeed;
	private double currentSpeed;
	private String color;
	private int currentGear;
	private int maxGear = 5;
	private Person owner;
	private double price;
	private double weightKg;
	private boolean isSportCar;

	Car() {
	}

	Car(String model, boolean isSportCar, String color) {
		this.model = model;
		this.isSportCar = isSportCar;
		this.setColor(color);
		this.weightKg = 1100;
		this.price = calculateCarPriceForScrap(1.25) + (isSportCar ? 500 : 0);
	}

	boolean ismoreExpensive(Car car) {
		if (this.price > car.price) {
			return true;
		} else {
			return false;
		}
	}

	void accelerate() {
		if (currentSpeed + 5 <= maxSpeed) {
			currentSpeed += 5;
		} else {
			currentSpeed = maxSpeed;
			System.out.println("You have reached max speed");
		}
	}

	void ChangeGearUp() {
		if (currentGear < maxGear) {
			currentGear++;
		} else {
			System.out.println("You have reached max gear!");
		}
	}

	void changeGearDown() {
		if (currentGear > 0) {
			currentGear--;
		} else {
			currentGear = 0;
			System.out.println("You are now on R!");
		}
	}

	void changeGear(int nextGear) {
		if (nextGear >= 0 && nextGear < 6) {
			this.currentGear = nextGear;
		} else {
			System.out.println("not valid gear");
		}
	}

	double calculateCarPriceForScrap(double metalPriceLv) {
		double coef = 0.8;
		if (this.isSportCar) {
			coef += 0.1;
		}
		return coef * this.weightKg * metalPriceLv;
	}

	String getColor() {
		return color;
	}

	double getPrice() {
		return this.price;
	}

	Person getOwner() {
		return owner;
	}

	void setPrice(double price) {
		this.price = price;
	}

	String getModel() {
		return model;
	}

	void setOwner(Person owner) {
		this.owner = owner;
	}

	void changeOwner(Person person) {
		this.owner = person;
	}

	void setColor(String newColor) {
		String colors = "Black Gray Grey White Red Orange Yellow Green Blue Purple Brown Magenta Tan "
				+ "Cyan Olive Maroon Navy Aquamarine Turquoise Silver Lime Teal Indigo Violet Pink";
		colors.toLowerCase();
		if (colors.indexOf(newColor.toLowerCase()) != -1) {
			color = newColor;
		} else {
			color = "Grey";
		}
	}

	String getInfo() {
		StringBuilder info = new StringBuilder();
		if (this.model != null) {
			info.append(String.format("Model: %s" + (isSportCar ? " sport car%n" : "%n"), model));
		}
		if (this.maxSpeed != 0) {
			info.append(String.format("Max speed %d%n", maxSpeed));
		}
		if (this.color != null) {
			info.append(String.format("Color %s%n", color));
		}
		if (this.owner != null) {
			info.append(String.format("Owner %s%n", owner.getName()));
		}
		if (this.price != 0) {
			info.append(String.format("Price %.2f%n", price));
		}
		if (this.weightKg != 0) {
			info.append(String.format("Weight %.2f%n", weightKg));
		}
		return info.toString();
	}
}
