import java.util.Arrays;
import java.util.Scanner;

/*
Задача 9:
Да се състави програма, чрез която по въведен низ съдържащ букви,
цифри, знак минус '-' се извежда сборът на въведените числа като се
отчита знакът '-' пред съответното число.
Вход: asd-12sdf45-56asdf100
Изход:
-12
45
-56
100
Сума = 77
 */
public class P09_FindNumbersInString {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		System.out.println("Enter sentence:");
		String text = in.nextLine();

		// replace all letters with symbol " "
		String regex = "[a-zA-Z]+";
		text = text.replaceAll(regex, " ");
		text = text.trim();
		
		// replace with "" if there is sequence of -- symbols
		// Example:(----51)==51 but (---51)==-51!
		regex = "--";
		text = text.replace(regex, "");

		// add symbol " " before "-"
		StringBuilder sb = new StringBuilder(text);
		for (int i = 1; i < text.length(); i++) {
			if (sb.charAt(i) == '-') {
				sb.insert(i, " ");
			}
		}
		text = sb.toString();

		// split by intervals
		regex = "[\\s]+";
		String[] numbersString = text.split(regex);
//		System.out.println(Arrays.toString(numbersString));
		//Obtaining numbers in array and printing
		int[] numbers = new int[numbersString.length];
		int sum = 0;
		for (int i = 0; i < numbersString.length; i++) {
			if (numbersString[i].charAt(0) == '-') {
				numbers[i] = -Integer.parseInt(numbersString[i].substring(1));
			} else {
				numbers[i] = Integer.parseInt(numbersString[i]);
			}
			System.out.println(numbers[i]);
			sum += numbers[i];
		}
		System.out.printf("Sum is %d", sum);
	}
}
