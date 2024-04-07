package swea.d1;

import java.util.Scanner;

public class SWEA_2058 {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int N = scan.nextInt();
		String str = Integer.toString(N);
		
		int sum = 0;
		for(int i=0; i<str.length(); i++) {
			int n = str.charAt(i) - '0';
			sum += n;
		}
		System.out.println(sum);
	}

}
