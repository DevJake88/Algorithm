package programmers.lv2;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;

public class Programmers_250136 {
    public static void main(String[] args) {
        Programmers_250136 test = new Programmers_250136();
        int[][] land = {
                { 0, 0, 0, 1, 1, 1, 0, 0 }, { 0, 0, 0, 0, 1, 1, 0, 0 }, { 1, 1, 0, 0, 0, 1, 1, 0 },
                { 1, 1, 1, 0, 0, 0, 0, 0 }, { 1, 1, 1, 0, 0, 0, 1, 1 }
        };
        int result = test.solution(land);
        System.out.println("result: " + result);
    }

    public int solution(int[][] land) {
        int answer = 0;
        int N = land.length; // 세로
        int M = land[0].length; // 가로

        // 1. 덩어리별로 ID를 줘서 맵에 표시하기 & 크기 측정
        boolean[][] visited = new boolean[N][M];
        int id = 1;
        int[][] mapId = new int[N][M];
        ArrayList<Integer> sizeList = new ArrayList<>();
        for (int j = 0; j < M; j++) {
            for (int i = 0; i < N; i++) {
                if (land[i][j] == 1 && !visited[i][j]) {
                    // int size = dfs(i, j, land, visited, mapId, id);
                    int size = bfs(i, j, land, visited, mapId, id);
                    sizeList.add(size);
                    id++;
                }
            }
        }

        // 2. 시추를 뚫는 곳 확인
        for (int j = 0; j < M; j++) {
            HashSet<Integer> hs = new HashSet<>();
            int sizeSum = 0;
            for (int i = 0; i < N; i++) {
                if (land[i][j] == 1 && mapId[i][j] > 0 && !hs.contains(mapId[i][j])) {
                    hs.add(mapId[i][j]);
                    sizeSum += sizeList.get(mapId[i][j] - 1);
                }
            }
            answer = Math.max(answer, sizeSum);
        }

        return answer;
    }

    public int bfs(int r, int c, int[][] land, boolean[][] visited, int[][] mapId, int id) {
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[] { r, c });
        visited[r][c] = true;
        mapId[r][c] = id;
        int size = 1;

        while (!queue.isEmpty()) {
            int[] cur = queue.poll();
            int[][] pos = { { -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 } }; // 상하좌우
            for (int i = 0; i < pos.length; i++) {
                int nr = cur[0] + pos[i][0];
                int nc = cur[1] + pos[i][1];

                if (nr >= 0 && nr < land.length && nc >= 0 && nc < land[0].length && land[nr][nc] == 1
                        && !visited[nr][nc]) {
                    queue.add(new int[] { nr, nc });
                    visited[nr][nc] = true;
                    mapId[nr][nc] = id;
                    size++;
                }
            }

        }
        return size;
    }

    /*
     * 맵이 500*500 이라 재귀로 하면 250,000 번의 재귀가 실행될 수 있으므로 스택오버플로우 발생할 수 있다.
     * public int dfs(int r, int c, int[][] land, boolean[][] visited, int[][]
     * mapId, int id) {
     * int count = 1;
     * visited[r][c] = true;
     * mapId[r][c] = id;
     * int[][] pos = { { -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 } }; // 상하좌우
     * for (int i = 0; i < pos.length; i++) {
     * int nr = r + pos[i][0];
     * int nc = c + pos[i][1];
     * 
     * if (nr >= 0 && nr < land.length && nc >= 0 && nc < land[0].length &&
     * land[nr][nc] == 1
     * && !visited[nr][nc]) {
     * count += dfs(nr, nc, land, visited, mapId, id);
     * }
     * }
     * return count;
     * }
     */
}
