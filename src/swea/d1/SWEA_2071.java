package swea.d1;

import java.util.Scanner;

public class SWEA_2071 {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int tc = scan.nextInt();
		for(int t=0; t<tc; t++) {			
			int result = 0;
			for(int i=0; i<10; i++) {
				int inputNum = scan.nextInt();
				result += inputNum;
			}
			int sol = (int) Math.round(result/(10.0));
			System.out.println("#" + (t+1) + " " + sol);
		}
	}
}
