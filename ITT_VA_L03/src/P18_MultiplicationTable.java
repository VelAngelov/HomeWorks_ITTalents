import java.util.Scanner;

public class P18_MultiplicationTable {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		System.out.println("Enter two numbers in the interval [1,9]:");
		int fNumber=input.nextInt();
		int sNumber=input.nextInt();
		input.close();
		if(fNumber>9||fNumber<1||sNumber>9||sNumber<1){
			System.out.println("Bad input!");
			return;
		}
		for (int i = 1; i <= fNumber; i++) {
			for (int j = 1; j <= sNumber; j++) {
				System.out.printf("%d*%d=%d%n",i,j,i*j);
			}
		}
	}
}
