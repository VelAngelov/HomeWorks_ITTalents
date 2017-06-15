package L_07;

import java.util.Scanner;

public class P06 {
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
		System.out.println("The main diagonal is:");
		for (int i = 0; i < n; i++) {
			System.out.print(matrix[i][i]+" ");
		}
	}
}
