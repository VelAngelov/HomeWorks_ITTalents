package HomeworkRecursion;
/*
 Задача 4:
Да се състави програма, чрез която по въведени начална и крайна
цифра се извеждат на всеки нов ред следната последователност
(триъгълник от знаци):
Пример: 1, 9
Изход:
11
2
1 2 3
... до
1 2 3 4 5 6 7 8 9
Използвайте рекурсия
 */
public class P04_Numbers {
	public static void main(String[] args) {
		printRowsToNumber(1, 9);
	}

	static void printRow(int i, int max) {
		if (i > max) {
			return;
		}
		System.out.print(i+" ");
		printRow(i+1, max);
	}
	static void printRowsToNumber(int i,int max) {
		if(i>max) {
			return;
		}
		printRow(1, i);
		System.out.println();
		printRowsToNumber(i+1, max);
	}
}
