import java.util.Scanner;

public class P01_IsBetween {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		System.out.println("Enter A:");
		double a = input.nextDouble();
		System.out.println("Enter B:");
		double b = input.nextDouble();
		System.out.println("Enter C:");
		double c = input.nextDouble();
		boolean isCBetweenAandB = (c >= a && c <= b) || (c <= a && c >= b);
		if (isCBetweenAandB) {
			System.out.printf("c=%f is between %f and %f", c, a, b);
		} else {
			System.out.printf("c=%f is not between %f and %f", c, a, b);
		}
		input.close();
	}

}
