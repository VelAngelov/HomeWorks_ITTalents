import java.util.Scanner;

public class P24_Palindrome {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		System.out.println("Enter number in the interval [10,30000]");
		int number=input.nextInt();
		input.close();
		if(number>30000||number<10){
			System.out.println("Invalid input!");
			return;
		}
		//we will construct the mirror number:
		String mirrorNum="";
		int copyNumber=number;
		do{
			mirrorNum+=copyNumber%10;
			copyNumber/=10;
		}while(copyNumber!=0);
		System.out.println(mirrorNum);
		if(number==Integer.parseInt(mirrorNum)){
			System.out.println("Palindrome");
		}else{
			System.out.println("not a Palindrome!");
		}
		
		
	}
}
