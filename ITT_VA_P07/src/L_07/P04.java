package L_07;

import java.util.Arrays;

public class P04 {
	public static void main(String[] args) {
		int[] arr = { 1, 0, 1, 0, 0, 1, 0, 1, 0, 0, 0, 1, 1 };
		int countZero = 0;
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] == 0) {
				countZero++;
			}
		}
		System.out.println(Arrays.toString(arr));
		// sorting
		for (int i = 0; i < arr.length; i++) {
			if (i < countZero) {
				arr[i] = 0;
			} else {
				arr[i] = 1;
			}
		}
		System.out.println("Sorted array:");
		System.out.println(Arrays.toString(arr));
	}
}
