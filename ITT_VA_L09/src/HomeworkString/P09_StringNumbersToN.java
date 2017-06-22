package HomeworkString;

import java.util.Scanner;

public class P09_StringNumbersToN {
	public static void main(String[] args) {
		System.out.println("Enter number n>0:");
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		if (n < 1) {
			System.out.println("Bad input!");
			return;
		}
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i <= n; i++) {
			sb.append(String.format("%d", i));
		}
		System.out.println(sb.toString());
	}
}
