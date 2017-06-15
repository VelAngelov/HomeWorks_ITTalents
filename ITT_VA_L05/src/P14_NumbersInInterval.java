import java.util.Arrays;

public class P14_NumbersInInterval {
	public static void main(String[] args) {
		double[] arr = { 7.1, 8.5, 0.2, 3.7, 0.99, 1.4, -3.5, -110, 212, 341, 1.2 };
		int count = 0;
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] >= -2.99 && arr[i] <= 2.99) {
				count++;
			}
		}
		double[] newArr = new double[count];
		count = 0;
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] >= -2.99 && arr[i] <= 2.99) {
				newArr[count] = arr[i];
				count++;
			}
		}
		System.out.println("Elements in interval [-2.99; 2,99]:");
		System.out.println(Arrays.toString(newArr));
	}
}
