package L_07;

public class P10 {
	public static void main(String[] args) {
		// first way is to sort and count
		// fastest method is direct count
		int[] arr = { 4, 1, 1, 4, 2, 3, 4, 4, 1, 2, 4, 9, 3 };
		int number;
		int count = 1;
		int maxCount = 1;
		int index=0;
		for (int i = 0; i < arr.length; i++) {
			number = arr[i];
			for (int j = i + 1; j < arr.length; j++) {
				if (number == arr[j]) {
					count++;
				}
			}
			if (maxCount < count) {
				maxCount = count;
				index = i;
			}
			count=1;
		}
		System.out.println(arr[index]+"->"+maxCount+" times");
	}
}
