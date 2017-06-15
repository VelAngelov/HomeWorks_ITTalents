
public class P07_SumOfEvenPositions_v2 {
	public static void main(String[] args) {
		int[][] arr = { 
				{ 11, 12, 13, 14, 15, 16 }, 
				{ 21, 22, 23, 24, 25, 26 }, 
				{ 31, 32, 33, 34, 35, 36 },
				{ 41, 42, 43, 44, 45, 46 }, 
				{ 51, 52, 53, 54, 55, 56 }, 
				{ 61, 62, 63, 64, 65, 66 } 
		};
		// validation
		if (arr.length != 6) {
			System.out.println("Incorrect input!");
			return;
		}

		for (int i = 0; i < arr.length; i++) {
			if (arr[i].length != 6) {
				System.out.println("Incorrect input!");
				return;
			}
		}
		
		int[] sumOfEvenInRow = new int[arr.length];
		int i = 0, j = 0;
		while (i < arr.length) {
			sumOfEvenInRow[i] += arr[i][j];
			System.out.print(arr[i][j]);
			if (j >= arr[i].length - 2) {
				System.out.printf(" the sum is: %d%n", sumOfEvenInRow[i]);
				i++;
				if (i % 2 == 0) {
					j = 0;
				} else {
					j = 1;
				}
			} else {
				System.out.print(", ");
				j += 2;
			}
		}
	}
}
