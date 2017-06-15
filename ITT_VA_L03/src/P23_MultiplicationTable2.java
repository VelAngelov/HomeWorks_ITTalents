
public class P23_MultiplicationTable2 {
	public static void main(String[] args) {
		int i=1,j=1;
		while(i<=9){
			j=i;
			while(j<=9){
				System.out.printf("%d*%d=%d,\t", i,j,i*j);
				j++;
			}
			i++;
			System.out.println();
		}
	}
}
