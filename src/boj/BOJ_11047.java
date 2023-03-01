package boj;

import java.util.Scanner;

public class BOJ_11047 {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int N = scan.nextInt();
		int K = scan.nextInt();

		int[] arr = new int[N];
		for (int i = 0; i < N; i++) {
			arr[i] = scan.nextInt();
		}

		int count = 0;
		for (int i = N - 1; i >= 0; i--) {
			if (K >= arr[i]) {
				count += K / arr[i];
				K = K % arr[i];
			}
		}
		System.out.println(count);

	}

}
