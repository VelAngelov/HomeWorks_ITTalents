package comp;

public class DemoComputer {
	public static void main(String[] args) {
		Computer myLaptop = new Computer();
		myLaptop.year = 2015;
		myLaptop.hardDiskMemory = 512;
		myLaptop.freeMemory = 215;
		myLaptop.operationSystem = "Windows 10";
		myLaptop.isNotebook = true;
		myLaptop.price = 350;
		myLaptop.changeOperationSystem("Windows 7");

		Computer myComputer = new Computer();
		myComputer.year = 2015;
		myComputer.hardDiskMemory = 1024;
		myComputer.freeMemory = 800;
		myComputer.operationSystem = "Windows 10";
		myComputer.isNotebook = false;
		myComputer.price = 1100;
		myComputer.useMemory(100);
		
		myLaptop.getInfo();
		System.out.println();
		myComputer.getInfo();
		
	}
}
