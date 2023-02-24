package thisiscodingtest;

import java.util.Scanner;

public class 일이될때까지 {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		
		int N = scan.nextInt();
		int K = scan.nextInt();
		
		int count = 0;
		while(true) {
			if (N % K == 0) {
				N = N / K;
				count++;
			} else {
				N--;
				count++;
			}
			
			if (N == 1) break;
		}
			
		System.out.println(count);
	}

}
