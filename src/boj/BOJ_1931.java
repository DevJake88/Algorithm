package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
//import java.util.Scanner;
import java.util.StringTokenizer;

public class BOJ_1931 {
	public static void main(String[] args) throws IOException {
//		Scanner scan = new Scanner(System.in);
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

//		int N = scan.nextInt();
		int N = Integer.parseInt(br.readLine());

		int[][] arr = new int[N][2];

		StringTokenizer st;

		for (int i = 0; i < N; i++) {
//			arr[i][0] = scan.nextInt();
//			arr[i][1] = scan.nextInt();
			st = new StringTokenizer(br.readLine(), " ");
			arr[i][0] = Integer.parseInt(st.nextToken());
			arr[i][1] = Integer.parseInt(st.nextToken());
		}

		Arrays.sort(arr, new Comparator<int[]>() {

			@Override
			public int compare(int[] o1, int[] o2) {
				if (o1[1] == o2[1]) {
					return o1[0] - o2[0];
				}
				return o1[1] - o2[1];
			}
		});

		int count = 0;
		int endTime = 0;

		for (int i = 0; i < N; i++) {
			if (endTime <= arr[i][0]) {
				count++;
				endTime = arr[i][1];
			}
		}

		System.out.println(count);

	}
}