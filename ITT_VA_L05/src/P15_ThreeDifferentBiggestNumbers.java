
import java.util.Scanner;

public class P15_ThreeDifferentBiggestNumbers {
	public static int differentNumbers = 3;

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		System.out.println("Enter number of elemtns n>3 n:");
		int n = in.nextInt();
		if (n < 3) {
			System.out.println("Incorrect number of elements!");
			return;
		}
		System.out.println("Enter " + n + " real numbers");
		double[] arr = new double[n];
		for (int i = 0; i < n; i++) {
			arr[i] = in.nextDouble();
		}
		int count = differentNumbers;
		for (int i = 0; (i < count) && (i < n); i++) {
			for (int j = i + 1; j < n; j++) {
				if (Math.abs(arr[i]) < Math.abs(arr[j])) {
					double temp = arr[i];
					arr[i] = arr[j];
					arr[j] = temp;
				}
			}
			if ((i > 0) && (arr[i - 1] == arr[i])) {
				count++;
			}
		}
		System.out.println("The desired elements are:");
		int countPrintedNumbers = 0;
		for (int i = 0; (i < count) && (i < n); i++) {
			if ((i > 0) && (arr[i - 1] == arr[i])) {
				continue;
			} else {
				System.out.print(/*arr[i] == (int) arr[i] ? (int) arr[i] + " " :*/ String.format("%s ", arr[i]));
				countPrintedNumbers++;
			}
		}
		if (countPrintedNumbers < differentNumbers) {
			System.out.println();
			System.out.printf("only %d diferent numbers found in the array!", countPrintedNumbers);
		}
	}
}
