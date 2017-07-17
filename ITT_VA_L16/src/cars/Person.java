package cars;

public class Person {
	private String name;
	private int age;
	private String egn;
	private String gender;
	private double weight;
	private double money;
	// private Person[] friends;
	private Car ownCar;

	Person(String name, String egn, String male) {
		this.name = name;
		this.egn = egn;
		this.gender = male;
	}

	Person(String name, int age) {
		this.name = name;
		this.age = age;
	}

	Person() {
		this.age = 0;
		this.weight = 4.0;
	}

	void eat(String food) {
		if (this.money > 1) {
			this.money--;
			System.out.printf("%s is eating %s%n", this.name, food);
		} else {
			System.out.printf("%s have no money for %s, and feels very hungry%n", this.name, food);
		}
	}

	void walk(String to) {
		System.out.printf("%s is walked to %s%n", this.name, to);
	}

	void grownUp() {
		age++;
	}

	void drinkingWater(double liters) {
		if (liters > 1) {
			System.out.println("This is too much water!!!");
		} else {
			System.out.printf("%s is drinking %.2f water.%n", this.name, liters);
		}
	}

	boolean buyCar(Car car) {
		if (car != null) {

			if (this.money > car.getPrice()) {
				if (car.getOwner() != null) {
					car.getOwner().addMoney(car.getPrice());
				}
				this.money -= car.getPrice();
				this.ownCar = car;
				car.setOwner(this);
				System.out.printf("%s successfully buy a new %s for %.2f lv%n", this.name, this.ownCar.getModel(),
						this.ownCar.getPrice());
				return true;
			} else {
				System.out.printf("%s have no money for %s%n", this.name, car.getModel());
				return false;
			}
		} else {
			return false;
		}
	}

	void sellCarForScrap() {
		if (this.ownCar != null) {
			System.out.printf("%s have sold successfully his %s for scrap and gain %.2f lv%n", this.name,
					this.ownCar.getModel(), this.ownCar.calculateCarPriceForScrap(0.25));
			System.out.printf("now %s feels good huh.", this.name);
			this.money += this.ownCar.calculateCarPriceForScrap(0.25);
			this.ownCar = null;
		} else {
			System.out.printf("%s have no car for sale,and feels uncomfortable in this auto morgue%n", this.name);
		}
	}

	void earnMoney(double money) {
		System.out.printf("%s have worked and earn %.2f money.Good job!%n", this.name, money);
		this.money += money;
	}

	void addMoney(double money) {
		this.money += money;
	}

	String getName() {
		return name;
	}

	int getAge() {
		return age;
	}

	void setAge(int age) {
		this.age = age;
	}

	String getEgn() {
		return egn;
	}

	void setEgn(String egn) {
		this.egn = egn;
	}

	String getMale() {
		return gender;
	}

	void setMale(String male) {
		this.gender = male;
	}

	double getWeight() {
		return weight;
	}

	void setWeight(double weight) {
		this.weight = weight;
	}

	double getMoney() {
		return money;
	}

}
