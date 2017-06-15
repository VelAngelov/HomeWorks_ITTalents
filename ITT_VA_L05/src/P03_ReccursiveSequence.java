import java.util.Scanner;

public class P03_ReccursiveSequence {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		System.out.println("Enter integers for first and second elements:");
		int[] arr = new int[10];
		arr[0] = in.nextInt();
		arr[1] = arr[0];
		for (int i = 2; i < 10; i++) {
			arr[i] = arr[i - 1] + arr[i - 2];
		}
		System.out.print("[");
		for (int i = 0; i < 10; i++) {
			if (i < 9) {
				System.out.print(arr[i] + ", ");
			} else {
				System.out.println(arr[i] + "]");
			}
		}
	}
}
