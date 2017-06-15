import java.util.Scanner;

public class P17_ZigzagSequence {
	public static void main(String[] args) {
		System.out.println("Ente number of elements n>1:");
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		if (n < 2) {
			System.out.println("Invalid input!");
			return;
		}
		int[] arr = new int[n];
		System.out.println("Enter " + n + " Integer numbers:");
		for (int i = 0; i < n; i++) {
			arr[i] = in.nextInt();
		}
		boolean isZigZag = true;
		for (int i = 0; i < n - 1; i++) {
			if (i % 2 == 0) {
				if (arr[i] >= arr[i + 1]) {
					isZigZag = false;
					break;
				}
			} else {
				if (arr[i] <= arr[i + 1]) {
					isZigZag = false;
					break;
				}
			}
		}
		System.out.println((isZigZag ? "Fulfills" : "Not fulfills") + " the requirements for a zigzagged up sequence");
	}
}
