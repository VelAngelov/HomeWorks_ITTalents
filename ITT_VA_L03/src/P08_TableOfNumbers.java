import java.util.Scanner;

public class P08_TableOfNumbers {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		System.out.println("Enter integer N(N>0):");
		int n=input.nextInt();
		input.close();
		//Validation of input:
		
		if(n<1){
			throw new IllegalArgumentException("Bad input!");
		}
		
		int br=0;
		for (int i = n-1; i < 3*n-1; i+=2) {
			for (int j = 0; j < n; j++) {
				System.out.print(n-1+br);
			}
			System.out.println();
			br+=2;
		}
	}
}
