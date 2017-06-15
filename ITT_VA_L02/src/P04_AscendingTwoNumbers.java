import java.util.Scanner;

public class P04_AscendingTwoNumbers {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		System.out.println("Enter two numbers:");
		int a = input.nextInt();
		int b = input.nextInt();
		input.close();
		// with if:
		if (a > b) {
			System.out.println("[" + b + "," + a + "]");
		} else {
			System.out.println("[" + a + "," + b + "]");
		}
		// with arithmetical operations:
		System.out.println("[" + (((a + b - Math.abs(a - b))) / 2) + "," + (((a + b + Math.abs(a - b))) / 2) + "]");
	}
}
