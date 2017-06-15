import java.util.Scanner;

public class P14_NumbersDevisibleBySeven {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		System.out.println("Enter integer number N,N must be in [10,200]:");
		int n = input.nextInt();
		input.close();
		if (n > 200 || n < 10) {
			System.out.println("Bad input");
			return;
		}
		for (int i = n; i > 6; i--) {
			if (i % 7 == 0) {
				System.out.println(i);
				i -= 6;
			}
		}
	}
}
