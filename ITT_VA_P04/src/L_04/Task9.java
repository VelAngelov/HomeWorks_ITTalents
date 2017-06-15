package L_04;

import java.util.Scanner;

public class Task9 {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		System.out.println("Enter n:");
		int n=input.nextInt();
		input.close();
		if(n<0){
			System.out.println("Wrong input!");
			return;
		}
		for (int i = 0; i < n; i++) {
			for (int j = -n+1; j < n; j++) {
				if(j==i||j==-i||i==n-1){						
					System.out.print("*");
				}else{
					System.out.print(" ");
				}
			}
			System.out.println();
		}
	}
}
