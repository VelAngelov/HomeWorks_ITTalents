import java.util.Scanner;

public class P08_LongestSequenceOfEqualNumbers {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		System.out.println("Enter number of elements:");
		int n = in.nextInt();
		if (n < 1) {
			System.out.println("Invalid input!");
			return;
		}
		int[] arr = new int[n];
		System.out.println("Enter elements of array:");
		for (int i = 0; i < n; i++) {
			arr[i] = in.nextInt();

		}
		int counter = 1;
		int biggestCounter = 1;
		int index = 0;
		for (int i = 0; i < n - 1; i++) {
			if (arr[i] == arr[i + 1]) {
				counter++;
				if (counter > biggestCounter) {
					biggestCounter = counter;
					index = i;
				}
			} else {
				counter = 1;
			}
		}
		System.out.println("The longest subsequence of equal elements are:");
		for (int i = 0; i < biggestCounter; i++) {
			System.out.print(arr[index]);
		}
	}
}
