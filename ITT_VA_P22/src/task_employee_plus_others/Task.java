package task_employee_plus_others;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.TreeMap;

public class Task {
	static HashMap<Character, Integer> charsacters = new HashMap<>((int) (31 / 0.75) + 1);
	static TreeMap<Integer, Queue<Character>> chars = new TreeMap<>();
	static int tekstSize;

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		System.out.println("Enter tekst:");
		String tekst = in.nextLine();
		in.close();
		// replace spaces:
		tekst = tekst.replaceAll("\\s", "");
		tekst = tekst.toLowerCase();
		tekstSize = tekst.length();
		// counting
		for (int i = 0; i < tekst.length(); i++) {
			putChar(tekst.charAt(i));
		}
		System.out.println(charsacters);
		// arrange by count:
		for (HashMap.Entry<Character, Integer> entry : charsacters.entrySet()) {
			putEntry(entry.getValue(), entry.getKey());
		}
		for (int i : chars.descendingKeySet()) {
			while (!chars.get(i).isEmpty()) {
				System.out.print(chars.get(i).poll());
				System.out.println(" " + i);

			}
		}

	}

	public static void putChar(char c) {
		if (charsacters.containsKey(c)) {
			charsacters.put(c, charsacters.get(c) + 1);
			return;
		}
		charsacters.put(c, 1);
	}

	public static void putEntry(int count, char c) {
		if (chars.containsKey(count)) {
			chars.get(count).offer(c);
			return;
		}
		chars.put(count, new LinkedList<>());
		chars.get(count).offer(c);
	}
}
