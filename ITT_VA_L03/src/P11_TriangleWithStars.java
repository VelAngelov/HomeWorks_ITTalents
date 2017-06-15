import java.util.Scanner;

public class P11_TriangleWithStars {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		System.out.println("Enter n>0:");
		int n=input.nextInt();
		input.close();
		if(n<1){
			System.out.println("Bad input!");
			return;
		}
		//filled triangle:
		for (int i = 0; i < n; i++) {
			for (int j = 1; j < 2*n; j++) {
				if((j>=n-i)&&(j<=n+i)){
					System.out.print("*");
				}else{
					System.out.print(" ");
				}
			}
			System.out.println();
		}
		System.out.println();
		//Not filled triangle:
		for (int i = 0; i < n; i++) {
			for (int j = 1; j < 2*n; j++) {
				if((j==n-i)||(j==n+i)||i==n-1){
					System.out.print("*");
				}else{
					System.out.print(" ");
				}
			}
			System.out.println();
		}
		System.out.println();
		//alternative method for filled triangle:
		//we have symmetric figure=>switch to another coordinate system:
		for (int i = 0; i < n; i++) {
			for (int j = -n+1; j <= n-1; j++) {
				if(Math.abs(j)<=i){						//or Math.abs(j)==i||i==n-1 for not filled triangle
					System.out.print("*");
				}else{
					System.out.print(" ");
				}
			}
			System.out.println();
		}
	}
}
