package comp;

public class Computer {
	private int year = 2000;
	// price in Euro
	private double price = 500d;
	private boolean isNotebook;
	private int hardDiskMemory;
	private int freeMemory;
	private String operationSystem;

	Computer() {
		this.isNotebook = false;
		this.operationSystem = "Windows XP";
	}

	Computer(int year, double price, int hardDiskMemory, int freeMemory) {
		this();
		if (year > 1980 && year < 2018) {
			this.year = year;
		} else {
			this.year = 2017;
		}
		if (price >= 0) {
			this.price = price;
		} else {
			this.price = 0;
		}
		if (freeMemory >= 0) {
			this.freeMemory = freeMemory;
		} else {
			this.freeMemory = 0;
		}
		if (hardDiskMemory > 0 && hardDiskMemory >= freeMemory) {
			this.hardDiskMemory = hardDiskMemory;
		} else {
			this.hardDiskMemory = this.freeMemory;
		}
	}

	Computer(int year, double price, boolean isNotebook, int hardDiskMemory, int freeMemory, String operationSystem) {
		this(year, price, hardDiskMemory, freeMemory);
		this.isNotebook = isNotebook;
		String operationSystems = "Windows XP,Windows 95,Windows 7, Windows 10,Windows 8,Windows Vista,MacOS,Unix,Ubuntu,Linux";
		if (operationSystems.contains(operationSystem)) {
			this.operationSystem = operationSystem;
		} else {
			System.out.println("Cant change operation system!");
		}
	}

	// Methods:
	public void changeOperationSystem(String newOperationSystem) {
		String operationSystems = "Windows XP,Windows 95,Windows 7, Windows 10,Windows 8,Windows Vista,MacOS,Unix,Ubuntu,Linux";
		if (operationSystems.contains(newOperationSystem)) {
			this.operationSystem = newOperationSystem;
		} else {
			System.out.println("Cant change operation system!");
		}
	}

	public void useMemory(int memory) {
		if (freeMemory < 0 || freeMemory > hardDiskMemory) {
			System.out.println("You have entered invalid free memory");
		}
		if (freeMemory >= memory) {
			freeMemory -= memory;
		} else {
			System.out.println("Not enough free memory!");
		}
	}

	public void getInfo() {
		System.out.println("Computer year:" + year);
		System.out.printf("price: %.2f euro%n", price);
		System.out.println(isNotebook ? "Notebook" : "not a Notebook");
		System.out.printf("Free memory :%d GB from total memory:%d GB%n", freeMemory, hardDiskMemory);
		System.out.println("Operation System:" + operationSystem);
	}

	public double getPrice() {
		return price;
	}

	int comparePrice(Computer c) {
		if(this.price>c.getPrice()) {
			return -1;
		}else if(this.price == c.getPrice()) {
			return 0;
		}else {
			return 1;
		}
	}
}
