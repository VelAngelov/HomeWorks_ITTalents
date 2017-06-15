import java.util.Scanner;

public class P01_MinNumberDevisibleByThree {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		System.out.println("Enter number of elements:");
		int n = input.nextInt();
		if (n < 1) {
			System.out.println("Illegal number of elemtns!");
			return;
		}
		int[] arr = new int[n];
		System.out.println("Enter elements of array:");
		int countDevisibleByThree = 0;
		int minDevisibleByThree = 0;
		for (int i = 0; i < n; i++) {
			arr[i] = input.nextInt();
			if (arr[i] % 3 == 0) {
				countDevisibleByThree++;
				minDevisibleByThree = arr[i];
			}
		}
		if (countDevisibleByThree == 0) {
			System.out.println("no elements devisible by 3!");
			return;
		}
		for (int i = 0; i < n; i++) {
			if ((arr[i] % 3 == 0) && (arr[i] <= minDevisibleByThree)) {
				minDevisibleByThree = arr[i];
			}
		}
		System.out.printf("Min number devisible by three is %d", minDevisibleByThree);
	}
}
