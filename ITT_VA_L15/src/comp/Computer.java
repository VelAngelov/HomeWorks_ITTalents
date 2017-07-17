package comp;

public class Computer {
	int year = 2000;
	// price in Euro
	double price = 500d;
	boolean isNotebook;
	int hardDiskMemory;
	int freeMemory;
	String operationSystem = "Windows XP";

	// Methods:
	void changeOperationSystem(String newOperationSystem) {
		operationSystem = newOperationSystem;
	}

	void useMemory(int memory) {
		if (freeMemory < 0 || freeMemory > hardDiskMemory) {
			System.out.println("You have entered invalid free memory");
		}
		if (freeMemory >= memory) {
			freeMemory -= memory;
		} else {
			System.out.println("Not enough free memory!");
		}
	}

	void getInfo() {
		System.out.println("Computer year:" + year);
		System.out.printf("price: %.2f euro%n",price);
		System.out.println(isNotebook ? "Notebook" : "not a Notebook");
		System.out.printf("Free memory :%d GB from total memory:%d GB%n",freeMemory,hardDiskMemory);
		System.out.println("Operation System:" + operationSystem);
	}

	// Validate year:
	// static void validateYear(int year) {
	// if (year < 1980 || year > 2017) {
	// System.out.println("Incorrect year!");
	// }
	// }
}
