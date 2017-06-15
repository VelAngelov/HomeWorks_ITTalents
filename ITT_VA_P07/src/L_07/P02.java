package L_07;

import java.util.Scanner;

public class P02 {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		System.out.println("Enter number of elements:");
		int n = in.nextInt();
		int[] arr = new int[n];
		System.out.println("Enter elements of array:");
		for (int i = 0; i < arr.length; i++) {
			arr[i] = in.nextInt();
		}
		boolean isJagged = true;
		int temp = arr[0];
		for (int i = 1; i < arr.length - 1; i++) {
			if (i % 2 == 0) {
				if (temp < arr[i]) {
					isJagged = false;
				}
			} else {
				if (temp > arr[i]) {
					isJagged = false;
				}
			}
			temp = arr[i];
		}
		System.out.println(isJagged ? "Jagged" : "not jagged");
	}
}
