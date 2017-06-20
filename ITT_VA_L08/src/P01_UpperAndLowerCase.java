import java.util.Scanner;
/*
 Задача 1:
Да се състави програма, чрез която се въвеждат два низа съдържащи
до 40 главни и малки букви.
Като резултат на екрана да се извеждат низовете само с главни и само
с малки букви.
Пример: Abcd Efgh
Изход: ABCD abcd EFGH efgh
 */

public class P01_UpperAndLowerCase {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		System.out.println("Enter first text");
		String text1;
		do {
			text1 = in.next();
			if (text1.length() > 40) {
				System.out.println("Enter text below 40 characters");
			}
		} while (text1.length() > 40);
		System.out.println("Enter second text");
		String text2;
		do {
			text2=in.next();
			if (text2.length() > 40) {
				System.out.println("Enter text below 40 characters");
			}
		} while (text2.length() > 40);
		System.out.println("First text in Upper case:");
		System.out.println(text1.toUpperCase());
		System.out.println("First text in Lower case:");
		System.out.println(text1.toLowerCase());
		System.out.println("Second text in Upper case:");
		System.out.println(text2.toUpperCase());
		System.out.println("Second text in Lower case:");
		System.out.println(text2.toLowerCase());
	}
}
