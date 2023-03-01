package swea.d1;

import java.util.Scanner;

public class SWEA_2070 {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int T = scan.nextInt();

		for (int i = 0; i < T; i++) {
			int num1 = scan.nextInt();
			int num2 = scan.nextInt();

			char result;
			if (num1 > num2)
				result = '>';
			else if (num1 == num2)
				result = '=';
			else
				result = '<';

			System.out.println("#" + (i + 1) + " " + result);
		}
	}

}
