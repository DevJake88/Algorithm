package thisiscodingtest;

import java.util.Arrays;
import java.util.Scanner;

public class 숫자카드게임 {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		
		int N = scan.nextInt();
		int M = scan.nextInt();
		
		int[][] arr = new int[N][M];
		for(int i=0; i<N; i++) {
			for(int j=0; j<M; j++) {
				arr[i][j] = scan.nextInt();
			}
		}
		
		int[] minArr = new int[N];
		int result = Integer.MIN_VALUE;
		for(int i=0; i<N; i++) {
			Arrays.sort(arr[i]);
			result = Math.max(result, arr[i][0]);
		}
		System.out.println(result);
	}

}

/*
3 3
3 1 2
4 1 4
2 2 2
*/

/*
2 4
7 3 1 8
3 3 3 4
*/