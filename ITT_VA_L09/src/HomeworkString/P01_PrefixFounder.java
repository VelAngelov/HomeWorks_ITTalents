package HomeworkString;

import java.util.Scanner;

public class P01_PrefixFounder {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		System.out.println("Enter main text:");
		String text = in.nextLine();
		System.out.println("Enter text which may be a prefix of the first");
		String prefix = in.next();
		if(text.substring(0,prefix.length()).equals(prefix)) {
			System.out.println("the word is prefix of the text");
		}else {
			System.out.println("the word is not a prefix of the text");
		}
	}
	
}
