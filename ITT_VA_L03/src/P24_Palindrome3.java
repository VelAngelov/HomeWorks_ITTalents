import java.util.Scanner;

public class P24_Palindrome3 {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		System.out.println("Enter number in the interval [10,30000]");
		int number=input.nextInt();
		input.close();
		if(number>30000||number<10){
			System.out.println("Invalid input!");
			return;
		}
		String numberString=Integer.toString(number);
		int i=0,j=numberString.length()-1;
		boolean isPalindrome=true;
		do{
			if(numberString.charAt(i)!=numberString.charAt(j)){
				isPalindrome=false;
				break;
			}
			i++;
			j--;
		}while(i<=j);
		System.out.println(isPalindrome?"The number is palindrome":"The number is not a palindrome");
	}
}
