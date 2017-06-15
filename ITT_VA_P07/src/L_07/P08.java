package L_07;

public class P08 {
	public static void main(String[] args) {
		boolean[][] arr = { { false, false, true }, { false, false, true }, { true, false, true } };
		boolean isThereTrueAboveSecondDiagonal = false;
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr[i].length; j++) {
				if (i + j < arr[i].length-1) {
					isThereTrueAboveSecondDiagonal=isThereTrueAboveSecondDiagonal||arr[i][j];
				}
			}
		}
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr[i].length; j++) {
				System.out.print(arr[i][j]+" ");
			}
			System.out.println();
		}
		if(isThereTrueAboveSecondDiagonal) {
			System.out.println("There is true above the main diagonal!");
		}else {
			System.out.println("There is not true above the main diagonal!");
		}
	}
}
