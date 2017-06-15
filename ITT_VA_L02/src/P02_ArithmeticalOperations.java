import java.text.DecimalFormat;
import java.util.Scanner;

public class P02_ArithmeticalOperations {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		System.out.println("Enter integer A:");
		int aInt = input.nextInt();
		System.out.println("Enter integer B:");
		int bInt = input.nextInt();

		int sumInt = aInt + bInt;
		int differenceInt = aInt - bInt;
		int multiplyInt = aInt * bInt;
		int remainderInt = aInt % bInt;
		int divisionInt = aInt / bInt;
		System.out.printf("Sum:%d%nDifference:%d%nMultiply:%d%nRemainder:%d%n" + "Division:%d%n", sumInt, differenceInt,
				multiplyInt, remainderInt, divisionInt);
		// with doubles:
		System.out.println("Enter fraction number A:");
		double aDouble = input.nextDouble();
		System.out.println("Enter fraction number B:");
		double bDouble = input.nextDouble();
		input.close();
		DecimalFormat df = new DecimalFormat("#.##");
		double sumDouble = aDouble + bDouble;
		double differenceDouble = aDouble - bDouble;
		double multiplyDouble = aDouble * bDouble;
		double remainderDouble = aDouble % bDouble;
		double divisionDouble = aDouble / bDouble;
		System.out.printf("Sum:%s%nDifference:%s%nMultiply:%s%nRemainder:%s%n" + "Division:%s%n", df.format(sumDouble),
				df.format(differenceDouble), df.format(multiplyDouble), df.format(remainderDouble),
				df.format(divisionDouble));
	}

}
