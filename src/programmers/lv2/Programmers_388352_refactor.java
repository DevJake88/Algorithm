package programmers.lv2;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Programmers_388352_refactor {
    public static void main(String[] args) {
        Programmers_388352 test = new Programmers_388352();
        int n = 15;
        int[][] q = { { 2, 3, 9, 12, 13 }, { 1, 4, 6, 7, 9 }, { 1, 2, 8, 10, 12 }, { 6, 7, 11, 13, 15 },
                { 1, 4, 10, 11, 14 } };
        int[] ans = { 2, 1, 3, 0, 1 };
        int result = test.solution(n, q, ans);
        System.out.println("result : " + result);
    }

    public int solution(int n, int[][] q, int[] ans) {
        List<int[]> combinations = generateCombinations(n, 5);
        int count = 0;

        for (int[] code : combinations) {
            if (isValid(code, q, ans)) {
                count++;
            }
        }
        return count;
    }

    private List<int[]> generateCombinations(int n, int r) {
        List<int[]> result = new ArrayList<>();
        backtrack(result, new int[r], 0, 1, n, r);
        return result;
    }

    private void backtrack(List<int[]> result, int[] comb, int idx, int start, int n, int r) {
        if (idx == r) {
            result.add(comb.clone());
            return;
        }
        for (int i = start; i <= n; i++) {
            comb[idx] = i;
            backtrack(result, comb, idx + 1, i + 1, n, r);
        }
    }

    private boolean isValid(int[] code, int[][] q, int[] ans) {
        Set<Integer> codeSet = new HashSet<>();
        for (int c : code)
            codeSet.add(c);

        for (int i = 0; i < q.length; i++) {
            int match = 0;
            for (int num : q[i]) {
                if (codeSet.contains(num))
                    match++;
            }
            if (match != ans[i])
                return false;
        }
        return true;
    }
}
