package L_04;

import java.util.Scanner;

public class Task6 {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		System.out.println("Enter integer positive number:");
		int number=input.nextInt();
		input.close();
		int counter=0;
		int mask=1;
		for (int i = 31; i >=0; i--) {
			if(number>=0){
			counter+=(number>>i)&mask;
			}
		}
		System.out.printf("The number of bits 1 is:%d",counter);
	}
}
