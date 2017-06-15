/*
Задача 7:
Имате предварително въведени стойности от естествени числа,
въведени в квадратна таблица с размери 6 реда и 6 колони.
Да се състави програма , чрез която се намира сумата на всички
елементи, чиято сума на индекси за ред и колона е четно число.
Програмата да извежда формираните суми за всеки отделен ред на
квадратната таблица, както и общата сума от тези елементи.
Да се използва само един цикъл.
Пример:
11,12,13,14,15,16,
21,22,23,24,25,26,
31,32,33,34,35,36,
41,42,43,44,45,46,
51,52,53,54,55,56,
61,62,63,64,65,66
Изход:
11, ,13, ,15, , сума от елементите за реда: 39
22, ,24, ,26, сума от елементите за реда: 72
31, ,33, ,35, , сума от елементите за реда: 99
42, ,44, ,46, сума от елементите за реда: 132
51, ,53, ,55, , сума от елементите за реда: 159
62, ,64, ,66 сума от елементите за реда: 192
Сума на елементите: 693
„
*/
public class P07_SumOfEvenPositions {
	public static void main(String[] args) {
		int[][] arr = { { 11, 12, 13, 14, 15, 16 }, { 21, 22, 23, 24, 25, 26 }, { 31, 32, 33, 34, 35, 36 },
				{ 41, 42, 43, 44, 45, 46 }, { 51, 52, 53, 54, 55, 56 }, { 61, 62, 63, 64, 65, 66 } };
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
		int maxCounter = arr.length * arr[0].length;
		int[] sumOfEvenInRow = new int[arr.length];
		int i, j;
		// first way
		for (int k = 0; k < maxCounter; k++) {
			i = (k / 6) % 6;
			j = k % 6;
			if ((i + j) % 2 == 0) {
				sumOfEvenInRow[i] += arr[i][j];
				System.out.print(arr[i][j]);
				if (j >= arr[i].length - 2) {
					System.out.printf(" the sum is: %d%n", sumOfEvenInRow[i]);
				} else {
					System.out.print(", ");
				}
			}
		}
		// second way
//		i = 0;
//		j = 0;
//		while (i < 6) {
//			sumOfEvenInRow[i] += arr[i][j];
//			System.out.print(arr[i][j]);
//			if (j >= 6 - 2) {
//				System.out.printf(" the sum is: %d%n", sumOfEvenInRow[i]);
//				i++;
//				if (i % 2 == 0) {
//					j = 0;
//				} else {
//					j = 1;
//				}
//			} else {
//				System.out.print(", ");
//				j += 2;
//			}
//		}
	}
}
