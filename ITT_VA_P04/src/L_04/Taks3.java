package L_04;

import java.util.Scanner;

public class Taks3 {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		System.out.println("Enter integer numbers A and B");
		int a=input.nextInt();
		int b=input.nextInt();
		input.close();
		if(a>b){
			int temp=a;
			a=b;
			b=temp;
		}
		for (int i = a; i <= b; i++) {
			if(i%3==0){
				System.out.println(i);
				i+=2;
			}
		}
	}
}
