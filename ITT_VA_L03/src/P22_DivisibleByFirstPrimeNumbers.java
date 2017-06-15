import java.util.Scanner;

public class P22_DivisibleByFirstPrimeNumbers {
	public static void main(String[] args) {
		System.out.println("Input start number:");
		Scanner input = new Scanner(System.in);
		int startNumber=input.nextInt();
		input.close();
		if(startNumber<1||startNumber>999){
			System.out.println("Bad input!");
			return;
		}
		
		int count=1;
		while(count<=10){
			startNumber++;
			if(startNumber%2==0||startNumber%3==0||startNumber%5==0){
				System.out.printf("%d:%d, ",count,startNumber);
				count++;
			}
		}
		
	}
}
