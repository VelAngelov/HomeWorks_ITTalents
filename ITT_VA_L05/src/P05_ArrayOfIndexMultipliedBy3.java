
public class P05_ArrayOfIndexMultipliedBy3 {
	public static void main(String[] args) {
		int[] arr = new int[10];
		for (int i = 0; i < 10; i++) {
			arr[i] = 3 * i;
		}
		System.out.print("[");
		for (int i = 0; i < 10; i++) {
			if (i < 10 - 1) {
				System.out.print(arr[i] + ", ");
			} else {
				System.out.println(arr[i] + "]");
			}
		}
	}
}
