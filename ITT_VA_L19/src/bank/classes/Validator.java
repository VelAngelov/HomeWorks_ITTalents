package bank.classes;

import java.util.Random;

public final class Validator {
	private static Random rnd = new Random();

	private Validator() {
	}

	public static boolean isValidString(String s) {
		return s != null && !s.isEmpty();
	}

	public static int rnd(int from, int to) {
		return from + rnd.nextInt(to);
	}
}
