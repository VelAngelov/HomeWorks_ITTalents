import java.util.Scanner;

public class P19_NumbersManipolation {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		System.out.println("Enter integer number in the interval [10,99]");
		int n = input.nextInt();
		input.close();
		if(n<10||n>99){
			System.out.println("Bad input!");
			return;
		}
		while (n != 1) {
			if (n % 2 == 0) {
				n = n >> 1;					//equivalent to n/2
				System.out.print(n+" ");
			} else {
				n = n * 3 + 1;
				System.out.print(n+" ");
			}
		}
		
	}
}
