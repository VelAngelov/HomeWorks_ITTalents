/*Задача 5:
Да се състави програма, при която предварително са въведени
естествени числа в двумерен масив 4*4 елемента.
Програмата да извежда резултат от проверката какво е съотношението
на най-голямата сума по редове спрямо най-голямата сума по колони.
Пример:
1,2,3,4
5,6,7,8
9,10,11,12
13,14,15,16
Изход:
най-голяма сума по редове 58
най-голяма сума по колони 40
Максималната сума по редове е > от максималната сума по колони
*/

public class P05_SumOfRowsSumOfColomns {
	public static void main(String[] args) {
		int[][] arr = {
				{ 1, 2, 3, 4 }, 
				{ 5, 6, 7, 8 }, 
				{ 9, 10, 11, 12 }, 
				{ 13, 14, 15, 16 } 
		};
		// verification:
		for (int i = 0; i < arr.length; i++) {
			if (arr.length != 4 || arr[i].length != 4) {
				System.out.println("Array is not 4x4!,enter it again!");
				return;
			}
		}
		int[] sumRows = { 0, 0, 0, 0 }, sumColumns = { 0, 0, 0, 0 };
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr[i].length; j++) {
				sumRows[i] += arr[i][j];
				sumColumns[j] += arr[i][j];
			}
		}
		int maxSumRows = sumRows[0], maxSumColumns = sumColumns[0];
		for (int i = 1; i < arr.length; i++) {
			if (maxSumColumns < sumColumns[i]) {
				maxSumColumns = sumColumns[i];
			}
			if (maxSumRows < sumRows[i]) {
				maxSumRows = sumRows[i];
			}
		}
		System.out.printf("Max sum of rows: %d%nMax sum of columns: %d%n", maxSumRows, maxSumColumns);
		System.out.print("Max sym of rows" + (maxSumRows >= maxSumColumns ? ">=" : "<") + "Max sum of columns");
	}
}
