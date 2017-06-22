package HomeworkString;

import java.util.Random;
import java.util.Scanner;

public class P11_Hangman {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		Random rnWord = new Random();
		String[] randomStrings = {"konche","programirane","tomografiq","igrachka","sladoled","nevronna mreja","izkustven intelekt",
				"google","nadenichki", "slushalki","laptop","rekursiq","golqm kurs"};
		String original = randomStrings[rnWord.nextInt(randomStrings.length-1)];
		String regex = "[^ ]";
		String text = original.replaceAll(regex, "_");
		char c = 'a';
		System.out.println("Can you suppose the word char by char?");
		System.out.println(text);
		System.out.println("if you want to retire type 0");
		while (text.indexOf("_") != -1) {
			c = in.next().charAt(0);
			if (c == '0') {
				System.out.println(original);
				return;
			}
			regex = regex.substring(0, regex.length() - 1);
			regex += c;
			regex += "]";
			text = original.replaceAll(regex, "_");
			System.out.println(text);
		}
		System.out.println("Congratulations!");

	}
}
