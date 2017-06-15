import java.util.Scanner;

public class P11_PositiveDevisibleBy5 {
	public static void main(String[] args) {
		int[] arr = new int[7];
		Scanner in = new Scanner(System.in);
		System.out.println("Enter 7 integer elements:");
		for (int i = 0; i < 7; i++) {
			arr[i] = in.nextInt();
		}
		System.out.println("The elements are:");
		int count = 0;
		for (int i = 0; i < 7; i++) {
			if ((arr[i] > 5) && (arr[i] % 5 == 0)) {
				System.out.print(arr[i] + " ");
				count++;
			}
		}
		System.out.printf("-%d times.", count);
	}
}
