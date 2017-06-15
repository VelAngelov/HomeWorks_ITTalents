package L_07;

import java.util.Scanner;

public class P14 {
	public static void main(String[] args) {
		System.out.println("Enter n and m:");
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int m = in.nextInt();
		int[][] arr = new int[n][m];
		
		// positions
		int i = 0, j = 0;
		
		// vector of movement
		int[] r = { -1, 1 };
		boolean isOutOfBound = false;
		
		// filler of the array
		int counter = 1;
		int startingPositionsWhenLineBreak = 0;

		// Method:
		while (startingPositionsWhenLineBreak < n + m - 1) {
			while (!isOutOfBound) {
				arr[i][j] = counter++;
				i += r[0];
				j += r[1];
				isOutOfBound = i < 0 || i >= n || j < 0 || j >= m;
			}
			startingPositionsWhenLineBreak++;
			if (startingPositionsWhenLineBreak < n - 1) {
				i = startingPositionsWhenLineBreak;
				j = 0;
			} else {
				i = n - 1;
				j = startingPositionsWhenLineBreak - i;
			}
			isOutOfBound = false;
		}

		// printing array
		System.out.println();
		for (i = 0; i < arr.length; i++) {
			for (j = 0; j < arr[i].length; j++) {
				System.out.print(arr[i][j] + " ");
			}
			System.out.println();
		}
	}
}
