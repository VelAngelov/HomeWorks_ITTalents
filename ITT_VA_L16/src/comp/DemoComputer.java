package comp;

public class DemoComputer {
	public static void main(String[] args) {
		Computer[] computers = new Computer[3];

		computers[0] = new Computer(2015, 350, true, 512, 215, "Windows 7");
		computers[1] = new Computer(2015, 1100, false, 1024, 800, "Windows 10");
		computers[2] = new Computer(2017, 2000, false, 2048, 1800, "Windows 10");
		for (int i = 0; i <computers.length-1; i++) {
			for (int j = i+1; j < computers.length; j++) {
				switch (computers[i].comparePrice(computers[j])) {
				case 1:
					System.out.println("\n\nThe price of this computer is greater than the second:\nfirst computer:");
					computers[j].getInfo();
					System.out.println("Second computer:");
					computers[i].getInfo();
					break;
				case 0:
					System.out.println("\n\nEquivalent prices of the next two computers!");
					computers[i].getInfo();
					computers[j].getInfo();
					break;
				case -1:
					System.out.println("\n\nThe price of this computer is greater than the second:\nfirst computer:");
					computers[j].getInfo();
					System.out.println("Second computer:");
					computers[i].getInfo();
					break;
				default:
					System.out.println("Error!");
				}
			}
		}
	
	}
}
