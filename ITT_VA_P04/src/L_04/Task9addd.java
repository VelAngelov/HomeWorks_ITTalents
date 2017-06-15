package L_04;

import java.util.Scanner;

public class Task9addd {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		System.out.println("Enter number:");
		int n=input.nextInt();
		if(n<0){
			System.out.println("Wrong input!");
			return;
		}else if(n%2==0){
			n++;
		}
		int tabulation=n;
		boolean isStar;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < 7*tabulation; j++) {
				isStar=(j==i)||(j==n-i-1);
				//isStar=isStar||((j>=n)&&(j<n+tabulation)&&(i==n/2))||((j>=n)&&(j<n+tabulation)&&(j==tabulation+n/2));
				isStar=isStar||(j==1*tabulation+i)||(j==1*tabulation+n-i-1);
				isStar=isStar||(j==2*tabulation+i)||(j==2*tabulation+n-i-1);
				isStar=isStar||((j>=n+2*tabulation)&&(j<n+3*tabulation)&&(i==n/2))||((j>=n+2*tabulation)&&(j<n+3*tabulation)&&(j==3*tabulation+n/2));
				isStar=isStar||(j==4*tabulation+i)||(j==4*tabulation+n-i-1);
				isStar=isStar||(j==5*tabulation+i)||(j==5*tabulation+n-i-1);
				isStar=isStar||(j==6*tabulation+i)||(j==6*tabulation+n-i-1);
				if(isStar){
					System.out.print("*");
				}else{
					System.out.print(" ");
				}
			}
			System.out.println();
		}
	}
}
