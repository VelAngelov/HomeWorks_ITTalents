import java.util.Scanner;

public class P10_NearToTheAverage {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int[] arr = new int[7];
		double average = 0d;
		System.out.println("Enter integer elements of array");
		for (byte i = 0; i < 7; i++) {
			arr[i] = in.nextInt();
			average += arr[i];
		}
		average /= 7;
		double difference = arr[0] - average;
		difference = difference > 0 ? difference : -difference;
		byte indexOfElementWithMinimalDifference = 0;
		for (byte i = 1; i < 7; i++) {
			if (arr[i] > average) {
				if (difference > (arr[i] - average)) {
					difference = arr[i] - average;
					indexOfElementWithMinimalDifference = i;
				}
			} else {
				if (difference > (average - arr[i])) {
					difference = (average - arr[i]);
					indexOfElementWithMinimalDifference = i;
				}
			}
		}
		System.out.printf("Average value: %.2f%nNearest element:%d", average, arr[indexOfElementWithMinimalDifference]);

	}
}
