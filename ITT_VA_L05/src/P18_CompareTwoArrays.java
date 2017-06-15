import java.util.Arrays;
import java.util.Scanner;

public class P18_CompareTwoArrays {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		System.out.println("Enter number of elements of first array:");
		int elArr1 = in.nextInt();
		if (elArr1 < 1) {
			System.out.println("Invalid number of elements!");
			return;
		}
		System.out.println("Entet number of elements of second array:");
		int elArr2 = in.nextInt();
		if (elArr2 < 1) {
			System.out.println("Invalid number of elements!");
			return;
		}
		int[] arr1 = new int[elArr1];
		System.out.println("Enter " + elArr1 + " integer elements for array 1:");
		for (int i = 0; i < elArr1; i++) {
			arr1[i] = in.nextInt();
		}
		int[] arr2 = new int[elArr2];
		System.out.println("Enter " + elArr1 + " integer elements for array 1:");
		for (int i = 0; i < elArr2; i++) {
			arr2[i] = in.nextInt();
		}
		int elArr3 = elArr1 > elArr2 ? elArr1 : elArr2;
		int[] arr3 = new int[elArr3];
		int i = 0;
		while (i < elArr1 && i < elArr2) {
			arr3[i] = arr1[i] > arr2[i] ? arr1[i] : arr2[i];
			i++;
		}
		while (i < elArr1) {
			arr3[i] = arr1[i];
			i++;
		}
		while (i < elArr2) {
			arr3[i] = arr2[i];
			i++;
		}
		System.out.println("arr1:\n" + Arrays.toString(arr1));
		System.out.println("arr2:\n" + Arrays.toString(arr2));
		System.out.println("arr3:\n" + Arrays.toString(arr3));

	}
}
