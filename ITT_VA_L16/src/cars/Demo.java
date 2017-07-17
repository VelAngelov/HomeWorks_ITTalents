package cars;

public class Demo {
	public static void main(String[] args) {
		Car honda = new Car("Honda Accord", true, "grey");
		honda.setPrice(6000);
		Car bmv = new Car("BMW X5", true, "black");
		bmv.setPrice(36000);
		Person vilio = new Person("Vilio", 26);
		vilio.earnMoney(50000);
	
		CarShop myCarShop = new CarShop(5);
		myCarShop.addCar(honda);
		myCarShop.addCar(bmv);
		myCarShop.showAllCarsInTheShop();
		myCarShop.sellNextCar(vilio);
		myCarShop.showAllCarsInTheShop();
		
	}
}
