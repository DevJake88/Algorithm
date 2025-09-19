package programmers.lv2;

import java.util.*;

public class Programmers_258711 {
    public static void main(String[] args) {
        int[][] edges = { { 4, 11 }, { 1, 12 }, { 8, 3 }, { 12, 7 }, { 4, 2 }, { 7, 11 }, { 4, 8 }, { 9, 6 },
                { 10, 11 }, { 6, 10 }, { 3, 5 }, { 11, 1 }, { 5, 3 }, { 11, 9 }, { 3, 8 } };
        Programmers_258711 test = new Programmers_258711();
        int[] result = test.solution(edges);
        System.out.println(Arrays.toString(result));
    }

    public int[] solution(int[][] edges) {
        HashMap<Integer, Integer> inDegree = new HashMap<>(); // 진입 차수: 외부에서 오는 간선의 수
        HashMap<Integer, Integer> outDegree = new HashMap<>(); // 진출 차수: 외부로 향하는 간선의 수
        HashSet<Integer> vertexSet = new HashSet<>(); // 그래프 내 모든 정점

        for (int[] edge : edges) {
            int from = edge[0];
            int to = edge[1];
            outDegree.put(from, outDegree.getOrDefault(from, 0) + 1);
            inDegree.put(to, inDegree.getOrDefault(to, 0) + 1);
            vertexSet.add(from);
            vertexSet.add(to);
        }

        // System.out.println("inDegree: " + inDegree);
        // System.out.println("outDegree: " + outDegree);

        int startVertex = 0;
        int donutGraph = 0;
        int barGraph = 0;
        int eightGraph = 0;

        for (Integer vertex : vertexSet) {
            int in = inDegree.getOrDefault(vertex, 0);
            int out = outDegree.getOrDefault(vertex, 0);
            if (in == 0 && out >= 2) {
                startVertex = vertex;
            } else if (out == 0) {
                barGraph++;
            } else if (in >= 2 && out >= 2) {
                eightGraph++;
            }
        }
        donutGraph = outDegree.get(startVertex) - (barGraph + eightGraph);
        int[] answer = new int[] { startVertex, donutGraph, barGraph, eightGraph };
        return answer;
    }
}
