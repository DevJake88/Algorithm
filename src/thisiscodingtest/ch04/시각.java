package thisiscodingtest.ch04;

import java.util.Scanner;

public class 시각 {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int N = scan.nextInt();
		int count = 0;
		
		for(int i=0; i<N+1; i++) {
			for(int j=0; j<60; j++) {
				for(int k=0; k<60; k++) {
					String str = Integer.toString(i) + Integer.toString(j) + Integer.toString(k);
					if (str.contains("3")) count++;
				}
			}
		}
		
		System.out.println(count);
	}

}
