package HomeworkRecursion;

import java.util.Scanner;

public class P02_ProductOfTwoNumbers {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		System.out.println("Enter two natural numbers a,b:");
		int a = in.nextInt();
		int b = in.nextInt();
		if (a < 0 || b < 0) {
			System.out.println("Wrong input!");
		}
		System.out.printf("The produc is : %d",product(a, b));

	}

	static int product(int a, int b) {
		if (b == 0) {
			return 0;
		}
		if (b == 1) {
			return a;
		}
		return a + product(a, b - 1);
	}
}
