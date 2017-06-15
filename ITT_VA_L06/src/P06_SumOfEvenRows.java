/*
 Задача 6:
Имате предварително въведени стойности от естествени числа.
Числата са въведени в квадратна таблица с размери 6 реда и 6
колони.
Да се състави програма, чрез която се намира сумата на всички
елементи от редовете с четни номера: 2,4 и 6.
Програмата да извежда и сумата на всеки отделен ред.
Пример:
11,12,13,14,15,16,
21,22,23,24,25,26,
31,32,33,34,35,36,
41,42,43,44,45,46,
51,52,53,54,55,56,
61,62,63,64,65,66
Изход:
21,22,23,24,25,26 сума 141
41,42,43,44,45,46 сума 261
61,62,63,64,65,66 сума 381
Сума на елементите 783 
 */

public class P06_SumOfEvenRows {
	public static void main(String[] args) {
		int[][] arr = { 
				{ 11, 12, 13, 14, 15, 16 }, 
				{ 21, 22, 23, 24, 25, 26 }, 
				{ 31, 32, 33, 34, 35, 36 },
				{ 41, 42, 43, 44, 45, 46 }, 
				{ 51, 52, 53, 54, 55, 56 }, 
				{ 61, 62, 63, 64, 65, 66 } 
		};
		// validation input:
		if (arr.length != 6) {
			System.out.println("Invalid array input!");
			return;
		}
		for (int i = 0; i < arr.length; i++) {
			if (arr[i].length != 6) {
				System.out.println("Invalid array input!");
				return;
			}
		}

		int[] sum = { 0, 0, 0 };
		int counter = 0;
		for (int i = 1; i < arr.length; i += 2) {
			for (int j = 0; j < arr[i].length; j++) {
				sum[counter] += arr[i][j];
				if (j != arr[i].length - 1) {
					System.out.printf("%d, ", arr[i][j]);
				} else {
					System.out.printf("%d  sum = %d", arr[i][j], sum[counter]);
					counter++;
				}
			}
			System.out.println();
		}
	}
}
