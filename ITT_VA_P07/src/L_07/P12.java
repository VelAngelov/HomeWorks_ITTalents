package L_07;

import java.util.Scanner;

public class P12 {
	public static void main(String[] args) {
		System.out.println("Enter n and m:");
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int m = in.nextInt();
		int[][] arr = new int[n][m];
		int counter = 1;
		int i=0;
		int j=0;
		for (i = 0; i < m; i++) {
			for (j = 0; j < n; j++) {
				arr[j][i] = counter;
				counter++;
			}
		}
		System.out.println();
		for (i = 0; i < arr.length; i++) {
			for (j = 0; j < arr[i].length; j++) {
				System.out.print(arr[i][j] + " ");
			}
			System.out.println();
		}
	}

}
