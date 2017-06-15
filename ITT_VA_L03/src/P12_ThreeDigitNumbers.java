
public class P12_ThreeDigitNumbers {
	public static void main(String[] args) {
		int a1,a2,a3;
		for (int i = 100; i < 1000; i++) {
			a1=(i/100)%10;
			a2=(i/10)%10;
			a3=i%10;
			if(a1!=a2&&a1!=a3&&a2!=a3){
				System.out.println(i);
			}
		}
	}
}
