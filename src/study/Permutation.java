package study;

import java.util.ArrayList;
import java.util.List;

public class Permutation {
    static void permutaion(int n, int r, boolean[] used, List<Integer> perm) {
        if (perm.size() == r) {
            System.out.println(perm);
            return;
        }

        for (int i = 1; i <= n; i++) {
            if (used[i])
                continue;
            used[i] = true;
            perm.add(i);
            permutaion(n, r, used, perm);
            perm.remove(perm.size() - 1);
            used[i] = false;
        }
    }

    public static void main(String[] args) {
        System.out.println();
        permutaion(4, 3, new boolean[5], new ArrayList<>());
    }
}
