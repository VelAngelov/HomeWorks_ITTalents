package HomeworkString;

public class P07_printDoubleArr {
	public static void main(String[] args) {
		double[][] arr = { 
				{ 12.3216, 132.113, 233.654, 21.231, 313.31554 },
				{ 123.231, 16.654, 684.321, 864.3214, 321.231 },
				{ 654.231, 123.654, 546.312, 123.321, 978.654 } };
		System.out.println(doubleArrToString(arr));
	}

	public static String doubleArrToString(double[][] arr) {
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr[i].length; j++) {
				sb.append(String.format("%.2f\t", arr[i][j]));
			}
			sb.append("\n");
		}
		return sb.toString();
	}
}
