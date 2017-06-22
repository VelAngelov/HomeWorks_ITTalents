package HomeworkRecursion;

/*
 Задача 5:
Да се състави програма, чрез която се въвежда естествено число N.
Програмата да извежда число, чиито цифри са написани в ред обратен
на въведеното число.
Да се извежда съобщение дали въведеното число е палиндром.
Пример: 12321
Изход: 12321 да.
Пример: 12578
Изход: 87521 не.
Използвайте рекурсия
 */
import java.util.Scanner;

public class P05_ReverseNumber {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		System.out.println("Enter integer number:");
		int num = in.nextInt();
		System.out.println(reverse3(num));
		System.out.println(reverse3(1234) == num ? "number is palindrome" : "number is not palindrome");

	}

	// using only n as a input of function:
	// using length of String:
	public static int reverse1(int num) {
		if (num < 10) {
			return num;
		}
		// dividing the number into digits
		int digit = num % 10;
		int decreasedNumberOfDigits = Integer.toString(num).length() - 1;
		num = reverse1(num / 10);

		// concatenating numbers
		int pow = 1;
		for (int j = 0; j < decreasedNumberOfDigits; j++) {
			pow *= 10;
		}
		num += digit * pow;
		return num;
	}

	// using math library only:
	public static int reverse2(int num) {
		if (num < 10) {
			// single digit achieved:
			return num;
		}
		int digit = num % 10;
		int decreasedNumberOfDigits = (int) Math.log10(num);
		int newNumber = digit * (int) Math.pow(10, decreasedNumberOfDigits);
		return reverse2(num / 10) + newNumber;
	}

	// using simple counting numbers:
	public static int reverse3(int num) {
		if (num < 10) {
			return num;
		}
		int digit = num % 10;
		int multiplyer = 10;
		while (multiplyer < num / 10) {
			multiplyer *= 10;
		}
		return reverse3(num / 10) + digit * multiplyer;
	}

	// Other ways to reverse
	// using help parameter in function(mule)
	public static int reverse4(int n, int rev) {
		if (n == 0) {
			return rev;
		}
		rev *= 10;
		rev += n % 10;
		return reverse4(n / 10, rev);
	}

	// using StringBuilder
	public static int reverse5(int num, int i) {
		StringBuilder s = new StringBuilder(Integer.toString(num));
		if (i == s.length() / 2) {
			return Integer.parseInt(s.toString());
		}
		char c = s.charAt(i);
		s.setCharAt(i, s.charAt(s.length() - 1 - i));
		s.setCharAt(s.length() - 1 - i, c);
		i++;
		return reverse5(Integer.parseInt(s.toString()), i);
	}

}
