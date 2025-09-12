package programmers.lv2;

import java.util.LinkedList;
import java.util.Queue;

public class Programmers_388353 {
    int N;
    int M;
    char[][] map;
    int[][] pos = { { -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 } }; // 상하좌우

    public static void main(String[] args) {
        Programmers_388353 test = new Programmers_388353();
        String[] storage = { "HAH", "HBH", "HHH", "HAH", "HBH" };
        String[] requests = { "C", "B", "B", "B", "B", "H" };
        int result = test.solution(storage, requests);
        System.out.println("result: " + result);
    }

    public int solution(String[] storage, String[] requests) {
        int answer = 0;
        N = storage.length;
        M = storage[0].length();
        map = new char[N][M];
        for (int i = 0; i < N; i++) {
            map[i] = storage[i].toCharArray();
        }

        for (int i = 0; i < requests.length; i++) {
            String request = requests[i];
            if (request.length() > 1) {
                // crane
                crane(request.charAt(0));
            } else {
                // lift
                lift(request.charAt(0));
            }
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (map[i][j] >= 'A' && map[i][j] <= 'Z') {
                    answer++;
                }
            }
        }

        return answer;
    }

    public void crane(char container) {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (map[i][j] == container) {
                    map[i][j] = '0';
                }
            }
        }
    }

    public void lift(char container) {
        Queue<int[]> queue = new LinkedList<>();
        boolean[][] visited = new boolean[N][M];
        for (int i = 0; i < N; i++) {
            queue.add(new int[] { i, -1 });
            queue.add(new int[] { i, M });
        }
        for (int j = 0; j < M; j++) {
            queue.add(new int[] { -1, j });
            queue.add(new int[] { N, j });
        }

        while (!queue.isEmpty()) {
            int[] arr = queue.poll();
            for (int i = 0; i < pos.length; i++) {
                int nr = arr[0] + pos[i][0];
                int nc = arr[1] + pos[i][1];

                if (nr < 0 || nc < 0 || nr >= N || nc >= M) {
                    continue;
                } else {
                    if (!visited[nr][nc]) {
                        visited[nr][nc] = true;
                        if (map[nr][nc] == container) {
                            map[nr][nc] = '0';
                        } else if (map[nr][nc] == '0') {
                            queue.add(new int[] { nr, nc });
                        }

                    }
                }
            }
        }
    }
}
