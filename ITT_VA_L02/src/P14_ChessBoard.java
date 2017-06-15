import java.util.Scanner;

public class P14_ChessBoard {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		System.out.println("enter coordinates of two fields");

		byte x1 = input.nextByte();
		byte y1 = input.nextByte();
		byte x2 = input.nextByte();
		byte y2 = input.nextByte();
		input.close();

		boolean isEqualColor = (x1 + y1) % 2 == (x2 + y2) % 2;
		if (isEqualColor) {
			System.out.println("The colors of the field are equal");
		} else {
			System.out.println("The colors of the field are not equal");
		}
	}
}
