package L_07;

import java.util.Scanner;

public class P07 {
	public static void main(String[] args) {
		System.out.println("Enter dimensions of matrix n x n:");
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int[][] matrix = new int[n][n];
		System.out.println("Enter elements of matrix:");
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				System.out.print("arr[" + i + "][" + j + "]=");
				matrix[i][j] = in.nextInt();
			}
		}
		int prod = 1;
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[i].length; j++) {
				if (j < i) {
					prod *= matrix[i][j];
				}
			}
		}
		System.out.println("The product of elements below main diagonal is:"+prod);
	}
}
