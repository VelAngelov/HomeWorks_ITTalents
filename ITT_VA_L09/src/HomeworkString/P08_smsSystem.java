package HomeworkString;

import java.util.Scanner;

public class P08_smsSystem {
	public static void main(String[] args) {
		System.out.println("Ecample:");
		String example = "528882";
		System.out.println(example + " means " +transferFromNumbersToString(example));
		System.out.println("Enter sequence of numbers(symbols different from 2-9 will be ignored!)");
		Scanner in = new Scanner(System.in);
		String number = in.nextLine();
		System.out.println(transferFromNumbersToString(validateInput(number)));
	}
	public static String validateInput(String numbers) {
		String regex = "[^2-9]+";
		return numbers.replaceAll(regex, "");
	}

	public static String transferFromNumbersToString(String numbers) {
		char[][] chars = { { 'a', 'b', 'c' }, { 'd', 'e', 'f' },{'g','h','i'}, { 'j', 'k', 'l' }, { 'm', 'n', 'o' },
				{ 'p', 'q', 'r', 's' }, { 't', 'u', 'v' }, { 'w', 'x', 'y', 'z' } };
		StringBuilder sms = new StringBuilder();
		char c;
		int count = 0;
		int digit = 2;
		for (int i = 0; i < numbers.length() - 1; i++) {
			if (numbers.charAt(i) == numbers.charAt(i + 1)) {
				count++;
			} else {
				digit = numbers.charAt(i) - '2';
				count = count % chars[digit].length;
				c = chars[digit][count];
				sms.append(c);
				count=0;
			}
		}
		if(count==0) {
			//add last char:
			digit = numbers.charAt(numbers.length()-1) - '2';
			count = 0;
			c = chars[digit][count];
			sms.append(c);
		}
		return sms.toString();
	}
}
