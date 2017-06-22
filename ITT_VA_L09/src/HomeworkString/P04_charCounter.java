package HomeworkString;

import java.util.Scanner;

public class P04_charCounter {
	public static void main(String[] args) {
		String text;
		System.out.println("Enter text:");
		Scanner in = new Scanner(System.in);
		text = in.nextLine();
		printCharsFromCountLowerCaseInArrayFromText(countLowerCaseInArrayFromText(text));
	}

	public static int[] countLowerCaseInArrayFromText(String text) {
		text = text.toLowerCase();
		//clear text from other characters:
		text = text.replaceAll("[^a-z]+", "");
		int[] arr = new int[26];
		char c;
		for (int i = 0; i < text.length(); i++) {
			c = text.charAt(i);
			c -= 'a';
			arr[c]++;
		}
		return arr;
	}

	public static void printCharsFromCountLowerCaseInArrayFromText(int[] arr) {
		char c;
		for (int i = 0; i < 26; i++) {
			if (arr[i] != 0) {
				c = 'a';
				c += i;
				System.out.printf("%c %dtimes%n",c,arr[i]);
			}
		}
	}
}
