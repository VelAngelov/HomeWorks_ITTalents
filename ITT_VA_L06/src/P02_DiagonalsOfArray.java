
/*Задача 2:
Имате квадратен двумерен масив от естествени числа, чийто стойности
се въвеждат от конзолата. Да се отпечатат диагоналите на масива.
Пример:
1,4,6,3
5,9,7,2
4,8,1,9
2,3,4,5
Изход:
1 9 1 5
3 7 8 2
*/
import java.util.Scanner;

public class P02_DiagonalsOfArray {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		System.out.println("Enter number of rows:");
		int n = in.nextInt();
		System.out.println("Enter number of columns:");
		int m = in.nextInt();
		if (n < 1 || m < 1) {
			System.out.println("Incorrect input!");
			return;
		}
		if (n != m) {
			System.out.println("The matrix is not square! First diagonal starts at "
					+ "1,1 position, Second diagonal starts at 1," + m + " element");
		}
		int[][] arr = new int[n][m];
		System.out.println("Enter the elements:");
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				System.out.print("a[" + (i + 1) + "][" + (j + 1) + "]=");
				arr[i][j] = in.nextInt();
			}
		}
		System.out.println("First diagonal:");
		for (int i = 0; i < n; i++) {
			System.out.print(arr[i][i]);
		}
		System.out.println("\nSecond diagonal");
		for (int i = 0; i < n; i++) {
			System.out.print(arr[i][n - i - 1]);
		}
	}
}
