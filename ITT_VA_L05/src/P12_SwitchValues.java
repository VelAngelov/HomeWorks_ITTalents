import java.util.Arrays;
import java.util.Scanner;

public class P12_SwitchValues {
	public static void main(String[] args) {
		int[] arr = new int[7];
		Scanner in = new Scanner(System.in);
		System.out.println("Enter 7 integer elements of arr:");
		for (int i = 0; i < 7; i++) {
			arr[i] = in.nextInt();
		}
		// switch using new variable
		int temp = arr[0];
		arr[0] = arr[1];
		arr[1] = temp;

		// switch using arithmetic operations:
		arr[2] = arr[2] + arr[3];
		arr[3] = arr[2] - arr[3];
		arr[2] = arr[2] - arr[3];

		// switch using multiplication
		// !ATENTION not working for zero!
		arr[4] = arr[4] * arr[5];
		arr[5] = arr[4] / arr[5];
		arr[4] = arr[4] / arr[5];

		// switch using bitwise operators
		// arr[4] = arr[4] ^ arr[5];
		// arr[5] = arr[4] ^ arr[5];
		// arr[4] = arr[4] ^ arr[5];
		System.out.println("array after switch elements:");
		System.out.println(Arrays.toString(arr));
	}
}
