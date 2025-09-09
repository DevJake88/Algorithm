package boj;

import java.util.Scanner;

public class BOJ_12865 {
    public static void main(String[] args) {
        // 4 7
        // 6 13
        // 4 8
        // 3 6
        // 5 12
        Scanner scan = new Scanner(System.in);
        int N = scan.nextInt();
        int K = scan.nextInt();
        int[] weight = new int[N];
        int[] value = new int[N];

        for (int i = 0; i < N; i++) {
            int W = scan.nextInt();
            int V = scan.nextInt();
            weight[i] = W;
            value[i] = V;
        }

        int[] dp = new int[K + 1];
        for (int i = 0; i < N; i++) {
            int W = weight[i];
            int V = value[i];
            for (int j = K; j >= W; j--) {
                dp[j] = Math.max(dp[j], dp[j - W] + V);
            }
        }

        int result = -1;
        for (int i = 0; i < K + 1; i++) {
            result = Math.max(result, dp[i]);
        }
        System.out.println(result);
    }
}
