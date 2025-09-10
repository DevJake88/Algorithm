package programmers.lv2;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Programmers_389479 {
    public static void main(String[] args) {
        System.out.println("melong");
        Programmers_389479 test = new Programmers_389479();
        int[] players = { 0, 2, 3, 3, 1, 2, 0, 0, 0, 0, 4, 2, 0, 6, 0, 4, 2, 13, 3, 5, 10, 0, 1, 5 };
        int m = 3;
        int k = 5;
        int result = test.solution(players, m, k);
        System.out.println(result);
    }

    public int solution(int[] players, int m, int k) {
        int answer = 0;
        int serverCnt = 0;
        Queue<int[][]> queue = new LinkedList<>(); // 서버 개수, 서버 끝나는 시간

        for (int i = 0; i < players.length; i++) {
            if (queue.size() > 0) {
                int[][] timeChk = queue.peek();
                // System.out.println(Arrays.toString(timeChk[0]));
                if (timeChk[0][1] == i) {
                    queue.poll();
                    serverCnt -= timeChk[0][0];
                }
            }

            int player = players[i];
            int needServer = player / m;
            // System.out.println("i: " + i + ", needServer: " + needServer);
            if (needServer > serverCnt) {
                queue.add(new int[][] { { needServer - serverCnt, i + k } });
                int expandServer = needServer - serverCnt;
                serverCnt += expandServer;
                answer += expandServer;
                // System.out.println("answer: " + answer);
            }
        }

        return answer;
    }
}