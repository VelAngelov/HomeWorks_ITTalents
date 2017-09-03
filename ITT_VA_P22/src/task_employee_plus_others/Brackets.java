package task_employee_plus_others;

import java.util.Stack;

public class Brackets {
	public static void main(String[] args) {
		String tekst = "{aksjd{lasdj}slakjd{lasjd}{lasjd}}";
		String tekst2 = "{}}{";
		System.out.println(checkTekst(tekst));
		System.out.println(checkTekst(tekst2));
	}

	public static boolean checkTekst(String tekst) {
		Stack<Character> bracket = new Stack<>();
		for (int i = 0; i < tekst.length(); i++) {
			char c = tekst.charAt(i);
			if (c == '{') {
				bracket.push(c);
			} else if (c == '}') {
				if (bracket.isEmpty()) {
					return false;
				}
				if (bracket.peek() == '{') {
					bracket.pop();
				} else {
					bracket.push(c);
				}
			}
		}
		return bracket.isEmpty();
	}

}
