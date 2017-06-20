import java.util.Scanner;

/*
Задача 2:
Да се състави програма, чрез която от клавиатурата се въвеждат
последователно две думи с дължина 10-20 знака.
Програмата да размени първите им 5 знака и да изведе дължината на
по-дългата, както и новото им съдържание.
Пример: uchilishe uchenik
Изход: 9 uchenishe
 */
public class P02_StringManipulation {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		System.out.println("Enter first word");
		String firstWord = in.next();
		while (firstWord.length() > 20 || firstWord.length() < 5) {
			System.out.println("Enter again first word /10-20 characters/");
			firstWord = in.next();
		}
		System.out.println("Enter second word");
		String secondWord = in.next();
		while (secondWord.length() > 20 || secondWord.length() < 5) {
			System.out.println("Enter ain socond word /10-20 characters/");
			secondWord = in.next();
		}
		StringBuilder sb;
		if(firstWord.length()>secondWord.length()) {
			sb = new StringBuilder(Integer.toString(firstWord.length()));
			sb.append(" ");
			sb.append(secondWord.substring(0,5));
			sb.append(firstWord.substring(5));
		}else {
			sb = new StringBuilder(Integer.toString(secondWord.length()));
			sb.append(" ");
			sb.append(firstWord.substring(0,5));
			sb.append(secondWord.substring(5));
		}
		System.out.print(sb.toString());
	}
}
