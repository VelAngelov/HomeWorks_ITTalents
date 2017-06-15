package L_04;

import java.util.Scanner;

public class Task4 {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		System.out.println("Enter positive integer number n>1:");
		int n=input.nextInt();
		input.close();
		if(n<1){
			System.out.println("wrong input!");
			return;
		}else if(n==1){
			System.out.println("not a prime,not a composite");
			return;
		}
		boolean isPrime=true;
		for (int i = 2; i <=(int)Math.ceil(Math.sqrt(n)); i++) {
			if(n%i==0){
				isPrime=false;
				break;
			}
		}
		System.out.println(isPrime?"Prime":"Composite"+" number");
	}

}
