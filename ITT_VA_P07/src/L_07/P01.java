package L_07;

import java.util.Scanner;

public class P01 {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		System.out.println("Enter number of elements:");
		int n = in.nextInt();
		int[] arr = new int[n];
		boolean isPositive = true;
		// input arr:
		System.out.println("Enter elemets of array:");
		for (int i = 0; i < n; i++) {
			arr[i] = in.nextInt();
		}
		for (int i = 0; i < n; i++) {
			if (arr[i] < 0) {
				isPositive = false;
				break;
			}
		}

		System.out.println(isPositive ? "There in no negative numbers" : "There is negative numbers");
	}
}
