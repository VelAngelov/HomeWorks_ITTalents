import java.util.Scanner;
/*
Задача 8:
Да се състави програма, чрез която се въвежда ред от символи
(стринг, низ).
Програмата да изведе на екрана дали въведения стринг е палиндром,
т.е. дали четен отляво-надясно и отдясно-наляво е един и същ.
Вход: капак
Изход: да.
Вход: тенджера
Изход: не.

 */
public class P08_Palindrome {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		String text = in.nextLine();
		boolean isPalindrome = true;
		for (int i = 0; i < text.length()/2; i++) {
			if(text.charAt(i)!=text.charAt(text.length()-1-i)) {
				isPalindrome = false;
				break;
			}
		}
		System.out.println(isPalindrome? "Palindrome":"not Palindrome");
	}
}
