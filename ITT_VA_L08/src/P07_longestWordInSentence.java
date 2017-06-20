import java.util.Scanner;

/*
 Задача 7:
Да се състави програма, която чете набор от думи разделени с
интервал.
Като резултат да се извеждат броя на въведените думи, както и броя
знаци в най-дългата дума.
Пример: asd fg hjkl
Изход: 3 думи, най-дългата е с 4 символа
 */
public class P07_longestWordInSentence {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		System.out.println("Enter several words divided by space");
		String text = in.nextLine();
		String[] arrStrings = text.split(" ");
		int maxLetters = 0;
		for (int i = 0; i < arrStrings.length; i++) {
			if (maxLetters < arrStrings[i].length()) {
				maxLetters = arrStrings[i].length();
			}
		}
		System.out.printf("%d words, longest with %d symbols",arrStrings.length,maxLetters);
	}
}
