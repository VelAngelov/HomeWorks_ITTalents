import java.util.Scanner;

public class P25_Factorial {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		System.out.println("Enter number:");
		int n = input.nextInt();
		input.close();
		if (n < 0) {
			System.out.println("Invalid n!");
		} else if (n == 0) {
			System.out.println(1);
		} else if (n > 20 && n < 171) {
			System.out.println("Approximate calculation using Stirling's formula:");
			double factorialDouble = Math.sqrt(2 * Math.PI * n) * Math.pow(n / Math.E, n);
			System.out.println(factorialDouble);
		} else if (n > 170) {
			System.out.println("really big number");
		} else {
			long factorial = 1;
			while (n > 0) {
				factorial *= n;
				n--;
			}
			System.out.println(factorial);
		}
	}
}