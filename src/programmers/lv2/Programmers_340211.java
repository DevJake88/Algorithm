package programmers.lv2;

import java.util.*;

public class Programmers_340211 {
    public static void main(String[] args) {
        int[][] points = { { 3, 2 }, { 6, 4 }, { 4, 7 }, { 1, 4 } };
        int[][] routes = { { 4, 2 }, { 1, 3 }, { 4, 2 }, { 4, 3 } };
        Programmers_340211 test = new Programmers_340211();
        int result = test.solution(points, routes);
        System.out.println("result: " + result);
    }

    public int solution(int[][] points, int[][] routes) {
        int answer = 0;

        Map<Integer, int[]> pointMap = new HashMap<>();
        for (int i = 0; i < points.length; i++) {
            pointMap.put(i + 1, points[i]);
        }

        Map<Integer, Map<String, Integer>> timeMap = new HashMap<>();
        for (int[] route : routes) {
            int t = 0;
            int[] start = pointMap.get(route[0]);
            int r = start[0];
            int c = start[1];
            recordMap(t, timeMap, r, c);

            for (int i = 1; i < route.length; i++) {
                int[] target = pointMap.get(route[i]);
                int tr = target[0];
                int tc = target[1];

                while (r != tr) {
                    t++;
                    r += (tr > r ? 1 : -1);
                    recordMap(t, timeMap, r, c);
                }

                while (c != tc) {
                    t++;
                    c += (tc > c ? 1 : -1);
                    recordMap(t, timeMap, r, c);
                }
            }
        }

        for (Map<String, Integer> position : timeMap.values()) {
            // System.out.println(position);
            for (Integer count : position.values()) {
                if (count > 1) {
                    answer++;
                }
            }
        }

        return answer;
    }

    // 시간별로 로봇 위치 및 만난 횟수 저장
    public void recordMap(int t, Map<Integer, Map<String, Integer>> timeMap, int r, int c) {
        timeMap.putIfAbsent(t, new HashMap<>());
        Map<String, Integer> positions = timeMap.get(t);
        String key = r + "," + c;
        positions.put(key, positions.getOrDefault(key, 0) + 1);

    }
}
