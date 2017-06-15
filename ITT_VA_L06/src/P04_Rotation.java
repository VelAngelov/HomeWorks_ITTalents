/*
Имате предварително въведени стойности на елементи в двумерен
масив - естествени числа.
Да се състави програма, чрез която се извеждат стойностите на
елементите в двумерен масив след обръщането му на +90 градуса.
Пример:
1,2,3,4
5,6,7,8
9,10,11,12
13,14,15,16
Изход
13,9,5,1
14,10,6,2
15,11,7,3
16,12,8,4
*/

public class P04_Rotation {
	public static void main(String[] args) {
		int[][] arr = {
				{1,2,3,4},
				{5,6,7,8},
				{9,10,11,12},
				{13,14,15,16}
		};
		//max length of row
		int max = 0;
		for (int k = 0; k < arr.length; k++) {
			if(max < arr[k].length) {
				max = arr[k].length;
			}
		}
		for (int i = 0; i < max; i++) {
			for ( int j = arr.length-1; j >= 0; j--) {
				if(i < arr[j].length) {
					System.out.print(arr[j][i] + ", ");
				}
				else {
					//if array have different length of rows
					System.out.print(" ");
				}
			}
			System.out.println();
		}
	}
}
