import java.util.Scanner;

public class P13_Temperature {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		System.out.println("Enter temperature in celsius degrees:");
		byte temp = input.nextByte();
		input.close();
		String weather;
		if (temp < -20) {
			weather = "ice cold";
		} else if (temp < 0) {
			weather = "cold";
		} else if (temp < 15) {
			weather = "cool";
		} else if (temp < 25) {
			weather = "warm";
		} else {
			weather = "hot";
		}
		System.out.printf("The weather is %s.", weather);
	}
}
