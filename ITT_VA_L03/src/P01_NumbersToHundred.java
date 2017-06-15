
public class P01_NumbersToHundred {
	public static void main(String[] args) {
		for (int i = 1; i <= 100; i++) {
			System.out.printf("%03d "+((i%20==0)?"%n":""),i);
		}
	}
}
