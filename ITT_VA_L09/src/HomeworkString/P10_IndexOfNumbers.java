package HomeworkString;

import java.util.Scanner;

public class P10_IndexOfNumbers {
	public static void main(String[] args) {
		int n,m;
		System.out.println("Enter n:(n>0)");
		n=validateIntegerNatural();
		System.out.println("Enter m:(m<=n,m>0):");
		m =validateIntegerNatural(n);
		//found the first index of sequence with numbers.
		//need to be approved for number with sequential digits(12,23,34...123,234...1234...)
		String s =numbersToN(n);
		System.out.println("index " + s.indexOf(String.format("%d", m)));
	}
	public static String numbersToN(int n) {
		if (n < 1) {
			return "Bad input!";
		}
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i <= n; i++) {
			sb.append(String.format("%d", i));
		}
		return sb.toString();
	}
	public static int validateIntegerNatural() {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		while(n<1) {
			System.out.println("Enter integer number bigger than 0!");
			n = in.nextInt();
		}
		return n;
	}
	public static int validateIntegerNatural(int upperBound) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		while(n<1||n>upperBound) {
			System.out.println("Enter integer number bigger than 0! and smaller than " + upperBound);
			n = in.nextInt();
		}
		return n;
	}
}
