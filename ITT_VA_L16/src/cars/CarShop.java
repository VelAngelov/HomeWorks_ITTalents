package cars;

public class CarShop {
	private Car[] cars;

	CarShop(int capacity) {
		cars = new Car[capacity];
	}

	boolean addCar(Car car) {
		int i = 0;
		while (i < cars.length) {
			if (cars[i] == null && car != null) {
				cars[i] = car;
				return true;
			} else {
				i++;
			}
		}
		return false;
	}

	int lastCarInShopId() {
		int i = 0;
		while (i < cars.length) {
			if (cars[i] == null) {
				return i - 1;
			} else {
				i++;
			}
		}
		return i;

	}

	Car getNextCar() {
		int id = lastCarInShopId();
		if (id == -1) {
			System.out.println("There are no cars in the shop!");
			return new Car();
		}
		return cars[id];
	}

	boolean removeNextCar() {
		int id = lastCarInShopId();
		if (id == -1) {
			return false;
		}
		cars[id] = null;
		return true;
	}

	void sellNextCar(Person person) {
		boolean isBought = person.buyCar(getNextCar());
		if (isBought) {
			 this.removeNextCar();
		}
	}

	void showAllCarsInTheShop() {
		int i = 0;
		while (i < cars.length) {
			if (cars[i] == null) {
				return;
			} else {
				System.out.println(cars[i].getInfo());
				i++;
			}
		}
	}

}
