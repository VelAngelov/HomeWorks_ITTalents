import java.util.Scanner;

public class P06_EqualArrays {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		System.out.println("Enter number of elements of first arr:");
		int index1 = in.nextInt();
		System.out.println("Enter number of elements of second arr:");
		int index2 = in.nextInt();
		if ((index1 < 1) || (index2 < 1)) {
			System.out.println("Incorrect numer of elements!");
			return;
		}
		int[] arr1 = new int[index1];
		int[] arr2 = new int[index2];
		System.out.println("Inicialization of first array");
		for (int i = 0; i < index1; i++) {
			arr1[i] = in.nextInt();
		}
		System.out.println("Inicialization of second array:");
		for (int i = 0; i < index2; i++) {
			arr2[i] = in.nextInt();
		}
		if (index1 != index2) {
			System.out.println("Arrays have diferent number of elements!");
		} else {
			boolean isEqual = true;
			for (int i = 0; i < index1; i++) {
				if (arr1[i] != arr2[i]) {
					isEqual = false;
					break;
				}
			}
			System.out.print("The arrays have equal number of elements");
			System.out.print(isEqual ? " and equal elements" : " but not equal elements on the same position!");
		}
	}
}
