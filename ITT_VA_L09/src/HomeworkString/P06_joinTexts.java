package HomeworkString;

import java.util.Scanner;

public class P06_joinTexts {
	public static void main(String[] args) {
		System.out.println("Enter text using separator \" \"");
		Scanner in = new Scanner(System.in);
		String[] text = in.nextLine().split(" ");
		//concatenate:
		String newString=null;
		newString=newString.join("", text);
		System.out.println(newString);
	}
}
