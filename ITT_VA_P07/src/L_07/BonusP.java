package L_07;

import java.util.Scanner;

public class BonusP {
	public static void main(String[] args) {
		System.out.println("Enter n and m:");
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int m = in.nextInt();
		int[][] arr = new int[n][m];

		// filler of the array
		int counter = 1;

		boolean isOutOfBaunds = false;
		boolean isMoved = true;

		// position of pointer:
		int i = 0;
		int j = 0;
		arr[i][j]=counter++;
		while (isMoved) {
			isMoved = false;
			
			// move down
			isOutOfBaunds = i+1 < 0 || i+1 >= n || j < 0 || j >= m;
			while (!isOutOfBaunds && arr[i + 1][j] == 0) {
				i++;
				arr[i][j] = counter++;
				isMoved=true;
				isOutOfBaunds = i+1 < 0 || i+1 >= n || j < 0 || j >= m;
			}
			
			// move right
			isOutOfBaunds = i < 0 || i >= n || j+1 < 0 || j+1 >= m;
			while (!isOutOfBaunds && arr[i][j+1] == 0) {
				j++;
				arr[i][j] = counter++;
				isMoved=true;
				isOutOfBaunds = i < 0 || i >= n || j+1 < 0 || j+1 >= m;
			}
			
			// move up
			isOutOfBaunds = i-1 < 0 || i-1 >= n || j < 0 || j >= m;
			while (!isOutOfBaunds && arr[i-1][j] == 0) {
				i--;
				arr[i][j] = counter++;
				isMoved=true;
				isOutOfBaunds = i-1 < 0 || i-1 >= n || j < 0 || j >= m;
			}
			
			// move left
			isOutOfBaunds = i < 0 || i >= n || j-1 < 0 || j-1 >= m;
			while (!isOutOfBaunds && arr[i][j-1] == 0) {
				j--;
				arr[i][j] = counter++;
				isMoved=true;
				isOutOfBaunds = i < 0 || i >= n || j-1 < 0 || j-1 >= m;
			}
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
