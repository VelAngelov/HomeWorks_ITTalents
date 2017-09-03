package tyrgovci.classes;

import java.util.Random;

public final class Validator {
	private static Random rnd = new Random();

	private Validator() {

	}

	public static boolean validateString(String s) {
		return s != null && !s.isEmpty();
	}

	public static int rnd(int from, int to) {
		if (to > from) {
			return from + rnd.nextInt(to - from);
		}
		return from;
	}
}
