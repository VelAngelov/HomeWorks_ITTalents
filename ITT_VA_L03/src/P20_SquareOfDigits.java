
public class P20_SquareOfDigits {
	public static void main(String[] args) {
		for (int i = 0; i <=9; i++) {
			for (int j = 1; j <=10; j++) {
				System.out.print((j+i)%10+" ");
			}
			System.out.println();
		}
	}
}
