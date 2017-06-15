package L_07;
//Recursion
import java.util.Scanner;

public class BonusP_recursion {
	public static int counter = 1;

	public static void main(String[] args) {
		System.out.println("Enter n and m:");
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int m = in.nextInt();
		int[][] arr = new int[n][m];
		fillArray(arr, 0, 0);
		printArr(arr);
	}

	public static void fillArray(int[][] arr, int row, int col) {
		if (row < 0 || row >= arr.length || col < 0 || col >= arr[0].length) {
			// out of bounds!
			return;
		}
		if (arr[row][col] != 0) {
			// not an empty space for filling
			return;
		}
		arr[row][col] = counter;
		counter++;
		
		fillArray(arr, row+1, col);
		fillArray(arr, row, col+1);
		fillArray(arr, row-1, col);
		fillArray(arr, row, col-1);
	}
	public static void printArr(int[][] arr) {
		System.out.println();
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr[i].length; j++) {
				System.out.print(arr[i][j] + " ");
			}
			System.out.println();
		}
	}
}
