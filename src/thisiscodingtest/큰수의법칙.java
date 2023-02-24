package thisiscodingtest;

import java.util.Arrays;
import java.util.Scanner;

public class 큰수의법칙 {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int N = scan.nextInt();
		int M = scan.nextInt();
		int K = scan.nextInt();

		int[] arr = new int[N];

		for (int i = 0; i < N; i++)
			arr[i] = scan.nextInt();
		
		Arrays.sort(arr);
		int Max1 = arr[N - 1];
		int Max2 = arr[N - 2];

		int result = 0;
		int k = 0;
		for (int i = 0; i < M; i++) {
			k++;
			if (k == K) {
				result += Max2;
				k = 0;
			} else {
				result += Max1;
			}
		}

		System.out.println(result);
	}

}

/*
 test case
 
 5 8 3 
 2 4 5 4 6
 */