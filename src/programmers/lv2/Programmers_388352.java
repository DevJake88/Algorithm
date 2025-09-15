package programmers.lv2;

import java.util.ArrayList;

public class Programmers_388352 {
    int answer = 0;

    public static void main(String[] args) {
        Programmers_388352 test = new Programmers_388352();
        int n = 15;
        int[][] q = { { 2, 3, 9, 12, 13 }, { 1, 4, 6, 7, 9 }, { 1, 2, 8, 10, 12 }, { 6, 7, 11, 13, 15 },
                { 1, 4, 10, 11, 14 } };
        int[] ans = { 2, 1, 3, 0, 1 };
        int result = test.solution(n, q, ans);
        System.out.println("result: " + result);
    }

    public int solution(int n, int[][] q, int[] ans) {
        perm(n, 5, 1, new ArrayList<>(), q, ans);
        return this.answer;
    }

    public void perm(int n, int r, int start, ArrayList<Integer> list, int[][] q, int[] ans) {
        if (list.size() == r) {
            System.out.println(list);
            // 여기서 검사
            for (int i = 0; i < q.length; i++) {
                int count = 0;
                for (int j = 0; j < 5; j++) {
                    for (int k = 0; k < 5; k++) {
                        if (list.get(k).equals(q[i][j])) {
                            count++;
                            break;
                        }
                    }
                }
                if (ans[i] != count)
                    return;
            }
            answer++;
            return;
        }

        for (int i = start; i <= n; i++) {
            list.add(i);
            perm(n, r, i + 1, list, q, ans);
            list.remove(list.size() - 1);
        }
    }
}
