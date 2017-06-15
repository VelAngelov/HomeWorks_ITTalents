import java.util.Scanner;

public class P15_SumNumbersFromOneToN2 {
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
		int i=1;
		do{
			sum += i;
			i++;
		}while(i<=n);
		System.out.printf("The sum of integers from 1 to %d is %d%n", n, sum);

	}
}
