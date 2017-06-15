import java.util.Scanner;

public class P10_IsPrime {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		System.out.println("Enter integer n>1:");
		int number=input.nextInt();
		input.close();
		boolean isPrime=true;
		
		//validation of input:
		if(number==1){
			System.out.println("1 is not prime or composite number!");
			return;
		}else if(number<1){
			throw new IllegalArgumentException("Bad input!");
		}
		
		for (int i = 2; i <=(int)(Math.ceil(Math.sqrt(number))); i++) {
			if(number%i==0){
				isPrime=false;
				break;
			}
		}
		
		System.out.printf("%d is %s number",number,isPrime?"prime":"composite");
	}
}
