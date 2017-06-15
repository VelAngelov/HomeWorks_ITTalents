import java.util.Scanner;

public class P07_Decisions {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		System.out.println("Enter hours:");
		int hours = Integer.parseInt(input.nextLine()); // ?
		System.out.println("Enter money:");
		double cash = Double.parseDouble(input.nextLine());
		System.out.println("Enter am I healthy");
		boolean isHealthy = Boolean.valueOf(input.nextLine());
		boolean iHaveMoney = cash > 10;
		input.close();
		if (isHealthy) {
			if (iHaveMoney) {
				System.out.println("I will go to cinema with friends");
			} else {
				System.out.println("I will go to cafe");
			}
		} else {
			if (iHaveMoney) {
				System.out.println("I will buy medicine");
			} else {
				System.out.println("I will drink tea");
			}
		}
	}
}
