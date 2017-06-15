package L_07;

import java.util.Scanner;

public class P03 {
	public static void main(String[] args) {
		System.out.println("Enter ch=:");
		Scanner in = new Scanner(System.in);

		char ch = in.next().charAt(0);

		System.out.println("Enter number of elements fro the arr:");
		char[] arr = new char[in.nextInt()];
		System.out.println("Enter elements of the arr without(\\n,\\t,\\...):");
		int count = 0;
		for (int i = 0; i < arr.length; i++) {
			arr[i] = in.next().charAt(0);
			if (ch == arr[i]) {
				count++;
			}
		}
		if (count == 0) {
			System.out.println("There is no such character in the array!");
		} else {
			int[] index = new int[count];
			int br = 0;
			for (int i = 0; i < arr.length; i++) {
				if (ch == arr[i]) {
					index[br] = i;
					br++;
				}
			}
			System.out.println("The character is at positions:");
			for (int i = 0; i < br; i++) {
				System.out.print((index[i] + 1) + " ");
			}
		}
	}
}
