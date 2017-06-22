package HomeworkString;

import java.util.Scanner;

public class P03_isPalindrome {
	public static void main(String[] args) {
		System.out.println("Enter text in one line:");
		Scanner in = new Scanner(System.in);
		String text = in.nextLine();
		boolean isPalindrome = true;
		for (int i = 0; i < text.length()/2; i++) {
			if(text.charAt(i)!=text.charAt(text.length()-1-i)) {
				isPalindrome=false;
				break;
			}
		}
		System.out.println(isPalindrome? "text is palindrome":"text is not palindrome");
	}
}
