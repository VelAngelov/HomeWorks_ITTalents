package L_07;

public class P09 {
	public static void main(String[] args) {
		// positive numbers only!
		int[][] arr = { 
				{ 1, 2, 3, 5 },
				{ 2, 3, 5, 6 },
				{ 2, 5, 3, 6 }, 
				{ 2, 5, 6, 8 } };
		int sumOfArr = 0;
		int maxSumOfArr = 0;
		int index1 = 0, index2 = 0;
		for (int i = 0; i < arr.length - 1; i++) {
			for (int j = 0; j < arr[i].length - 1; j++) {
				sumOfArr = arr[i][j] + arr[i + 1][j] + arr[i][j + 1] + arr[i + 1][j + 1];
				if (sumOfArr > maxSumOfArr) {
					maxSumOfArr = sumOfArr;
					index1 = i;
					index2 = j;
				}
			}
		}
		System.out.println("The sub matrix with max sum "+maxSumOfArr+" is:");
		System.out.println(arr[index1][index2]+" "+arr[index1][index2+1]);
		System.out.println(arr[index1+1][index2]+" "+arr[index1+1][index2+1]);
		
	}
}
