package L_04;

import java.util.Scanner;

public class Task5 {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		System.out.println("Enter integer positive number:");
		int number=input.nextInt();
		input.close();
		int mask=1;
		//First method,only bitwise operations:
		for (int i = 31; i >=0; i--) {
			if((i+1)%4==0){
				System.out.print(" ");
			}
			if(number>=0){
			System.out.print((number>>i)&mask);
			}
		}
		//Method 2:with String append
	}
}
