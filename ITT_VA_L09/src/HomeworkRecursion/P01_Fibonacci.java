package HomeworkRecursion;

import java.util.Scanner;

public class P01_Fibonacci {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		System.out.println("Enter n ");
		int n = in.nextInt();
		if(n<0) {
			System.out.println("Wrong input!");
			return;
		}
		if(n>46) {
			System.out.println("Result is incorrect!");
		}
		System.out.println(Fib(n, new int[n]));

	}

	static int Fib(int n, int[] memo) {
		if (n == 2) {
			memo[1]=1;
			return 1;
		}
		memo[n - 1] = Fib(n - 1, memo);
		return memo[n - 1] + memo[n - 2];

	}
}
