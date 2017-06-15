
import java.util.Scanner;

public class P13_DecToBin {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		System.out.println("Enter positive integer number");
		int number = in.nextInt();
		int[] arr = new int[31];
		int i = 0;
		if (number == 0) {
			System.out.println(0);
			return;
		}
		while (number != 0) {
			arr[i] = number & 1;
			number = number >> 1;
			i++;
		}
		int[] bin = new int[i];
		for (int j = 0; j < i; j++) {
			bin[j] = arr[i - 1 - j];
		}
		arr = null;
		System.out.println("The number in binary:");
		for (int j = 0; j < i; j++) {
			System.out.print(bin[j]);
		}

	}
}
