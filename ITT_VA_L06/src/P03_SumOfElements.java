/*
Задача 3:
Имате двумерен масив от числа, чийто стойности са въведени
предварително. Да се отпечатат сумата на елементите на масива,
както и средноаритметичното на тези числа.
*/

public class P03_SumOfElements {
	public static void main(String[] args) {
		int[][] arr = { 
				{ 12, 15, 3 },
				{ 18, 12, 3, 8 },
				{ 2, 1, 5, 7 },
				{ 3, 8, 6, 4 } 
		};
		int sum = 0;
		int numberOfElementsInArray = 0;
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr[i].length; j++) {
				sum += arr[i][j];
			}
			numberOfElementsInArray += arr[i].length;
		}
		double average = (sum*1d) / numberOfElementsInArray;
		System.out.printf("Sum of elements:%d%nAverage value %.2f", sum, average);
	}
}
