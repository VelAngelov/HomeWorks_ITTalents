import java.util.Scanner;

public class P06_SumNumbersFromOneToN {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int n;
		//input verification
		do {
			System.out.println("Enter integer N(N>1):");
			n = input.nextInt();
			if (n < 1) {
				System.out.println("Bad input!");
			}
		} while (n < 1);
		input.close();
		//calculating the sum
		int sum = 0;
		for (int i = 1; i <= n; i++) {
			sum += i;
		}
		System.out.printf("The sum of integers from 1 to %d is %d%n", n, sum);
		
		// Arithmetic progression: sum=(1+n)*n/2;
		sum = (n * n + n) / 2;
		System.out.printf("Result must be: %d", sum);
	}
}
