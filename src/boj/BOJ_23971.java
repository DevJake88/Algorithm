package boj;

import java.util.Scanner;

public class BOJ_23971 {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int H = scan.nextInt();
		int W = scan.nextInt();
		int N = scan.nextInt();
		int M = scan.nextInt();
		
		int r = (int) Math.ceil(H/(N+1.0));
		int c = (int) Math.ceil(W/(M+1.0));
		
		System.out.println(r*c);
	}
}
