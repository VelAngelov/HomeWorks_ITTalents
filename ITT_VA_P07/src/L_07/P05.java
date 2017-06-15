package L_07;

import java.util.Scanner;

public class P05 {
	public static void main(String[] args) {
		System.out.println("Enter dimensions of matrix n x m:");
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int m = in.nextInt();
		double[][] matrix = new double[n][m];
		System.out.println("Enter elements of matrix:");
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				System.out.print("arr[" + i + "][" + j + "]=");
				matrix[i][j] = in.nextDouble();
			}
		}
		double sumRow = 0;
		double maxSum;
		for (int i = 0; i < matrix[0].length; i++) {
			sumRow += matrix[0][i];
		}
		maxSum = sumRow;
		sumRow = 0;
		int row = 0;
		for (int i = 1; i < matrix.length; i++) {
			for (int j = 0; j < matrix[i].length; j++) {
				sumRow += matrix[i][j];
			}
			if (sumRow > maxSum) {
				maxSum = sumRow;
				row = i;
			}
			sumRow = 0;
		}
		System.out.printf("The max sum of row is %.2f%non row %d", maxSum, row);
	}
}
