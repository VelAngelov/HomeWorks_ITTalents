package L_07;

import java.util.Scanner;

public class P11 {
	public static void main(String[] args) {
		System.out.println("Enter n and m:");
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int m = in.nextInt();
		// a)
		int[][] arr = new int[n][m];
		int counter = 1;
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr[i].length; j++) {
				arr[i][j] = counter;
				counter++;
			}
		}
		System.out.println();
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr[i].length; j++) {
				System.out.print(arr[i][j] + " ");
			}
			System.out.println();
		}
		// b)
		counter = 1;
		int i=0;
		int j=0;
		for (i = 0; i < n; i++) {
			for (j = 0; j < m; j++) {
				arr[j][i] = counter;
				counter++;
			}
		}
		j=0;
		System.out.println();
		for (i = 0; i < arr[j].length; i++) {
			for (j = 0; j < arr.length; j++) {
				System.out.print(arr[i][j] + " ");
			}
			System.out.println();
		}
		// d)
		counter = 1;
		for (i = 0; i < arr[j].length; i++) {
			if (i % 2 == 0) {
				for (j = 0; j < arr.length; j++) {
					arr[j][i] = counter;
					counter++;
				}
			} else {
				for (j = arr.length - 1; j >= 0; j--) {
					arr[j][i] = counter;
					counter++;
				}
			}
		}
		System.out.println();
		for (i = 0; i < arr.length; i++) {
			for (j = 0; j < arr[i].length; j++) {
				System.out.print(arr[i][j] + " ");
			}
			System.out.println();
		}
		// c)
		// above the main diagonal:
		System.out.println("==========");
		counter = 1;
		i = 0; 
		j = 0;
		for (int br = 0; br < arr.length; br++) {
			i = br;
			j = 0;
			while (i >= 0) {
				arr[i][j] = counter;
				i--;
				j++;
				counter++;
			}
		}
		int br = 0;
		if(n==m) {
			br=1;
		}
		j=(int)Math.abs(m-n)+br;
		while (j < arr.length) {
			i = arr.length-1;
			br++;
			while (j < arr.length) {
				arr[i][j] = counter;
				i--;
				j++;
				counter++;
			}
			j = m - n + br;
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
