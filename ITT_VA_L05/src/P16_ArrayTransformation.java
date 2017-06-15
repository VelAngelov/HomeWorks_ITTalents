import java.text.DecimalFormat;


public class P16_ArrayTransformation {
	public static void main(String[] args) {
		double[] arr = { -1.12, -2.43, 3.1, 4.2, 0, 6.4, -7.5, 8.6, 9.1, -4 };
		double[] arrTransform = new double[arr.length];
		for (int i = 1; i <= arr.length; i++) {
			if (arr[i - 1] < -0.231) {
				arrTransform[i - 1] = i * i + 41.25;
			} else {
				arrTransform[i - 1] = i * arr[i - 1];
			}
		}
		System.out.println("Initial array");
		System.out.print("[");
		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i] == (int) arr[i] ? (int) arr[i] : String.format("%s", arr[i]));
			System.out.print((i == arr.length - 1) ? "]" : ", ");
		}
		System.out.println("\nTransformed array:");
		DecimalFormat dF = new DecimalFormat("0.##");
		System.out.print("[");
		for (int i = 0; i < arrTransform.length; i++) {
			System.out.print(dF.format(arrTransform[i]));
			System.out.print((i == arrTransform.length - 1) ? "]" : ", ");
		}
	}
}
