import java.util.Scanner;

public class P07_ArrayToArray {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		System.out.println("Enter number of elemtns of arr:");
		int n = in.nextInt();
		if (n < 1) {
			System.out.println("Invalid input!");
			return;
		}
		int[] arr = new int[n];
		System.out.println("Enter elements of arr:");
		for (int i = 0; i < n; i++) {
			arr[i] = in.nextInt();
		}
		int[] arr2 = new int[n];
		arr2[0] = arr[0];
		arr2[n - 1] = arr[n - 1];
		for (int i = 1; i < n - 1; i++) {
			arr2[i] = arr[i - 1] + arr[i + 1];
		}
		System.out.print("[");
		for (int i = 0; i < n; i++) {
			if (i < n - 1) {
				System.out.print(arr2[i] + ", ");
			} else {
				System.out.println(arr2[i] + "]");
			}
		}
	}
}
