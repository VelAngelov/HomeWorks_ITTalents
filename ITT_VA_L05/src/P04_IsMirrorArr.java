import java.util.Scanner;

public class P04_IsMirrorArr {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		System.out.println("Enter number of elements of the arr:");
		int n = in.nextInt();
		if (n < 1) {
			System.err.println("Incorrect number of elements!");
			return;
		}
		int[] arr = new int[n];
		System.out.println("Enter integer elements of array:");
		for (int i = 0; i < n; i++) {
			arr[i] = in.nextInt();
		}
		boolean isMirror = true;
		for (int i = 0; i < n / 2; i++) {
			if (arr[i] != arr[n - 1 - i]) {
				isMirror = false;
				break;
			}
		}
		System.out.println(isMirror ? "The array is mirror" : "The array is not mirror");
	}
}
