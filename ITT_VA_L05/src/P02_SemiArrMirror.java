import java.util.Arrays;
import java.util.Scanner;

public class P02_SemiArrMirror {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		System.out.println("Enter number of elements:");
		int n = in.nextInt();
		if (n < 1) {
			System.err.println("Incorrect number of elements");
			return;
		}
		int[] arr = new int[n];
		int[] mirrorArr = new int[n];
		System.out.println("Enter elements of array");
		for (int i = 0; i < n; i++) {
			arr[i] = in.nextInt();
			mirrorArr[i] = arr[i];
		}
		for (int i = 0; i < n / 2; i++) {
			mirrorArr[n - 1 - i] = mirrorArr[i];
		}
		System.out.println(Arrays.toString(mirrorArr));
	}
}
