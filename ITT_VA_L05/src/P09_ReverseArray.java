import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Scanner;

public class P09_ReverseArray {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		System.out.println("Enter number of elements:");
		int n = in.nextInt();
		if (n < 1) {
			System.out.println("Incorrect number of elements!");
			return;
		}
		System.out.println("Enter integer elements of the arr:");
		int[] arr = new int[n];
		for (int i = 0; i < n; i++) {
			arr[i] = in.nextInt();
		}
		// using new array:
		int[] arr2 = new int[n];
		for (int i = 0; i < n; i++) {
			arr2[i] = arr[n - 1 - i];
		}
		System.out.println("original array:");
		System.out.println(Arrays.toString(arr));
		System.out.println(Arrays.toString(arr2));
		// without using new array:
		for (int i = 0; i < n / 2; i++) {
			arr[i] = arr[i] ^ arr[n - 1 - i];
			arr[n - 1 - i] = arr[i] ^ arr[n - 1 - i];
			arr[i] = arr[i] ^ arr[n - 1 - i];
		}
		System.out.println("reversed original array:");
		System.out.println(Arrays.toString(arr));
	}
}
