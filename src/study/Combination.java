package study;

import java.util.ArrayList;
import java.util.List;

public class Combination {
    static void combitnation(int n, int r, int start, List<Integer> comb) {
        if (comb.size() == r) {
            System.out.println(comb);
            return;
        }

        for (int i = start; i <= n; i++) {
            comb.add(i);
            combitnation(n, r, i + 1, comb);
            comb.remove(comb.size() - 1);
        }
    }

    public static void main(String[] args) {
        System.out.println();
        combitnation(5, 3, 1, new ArrayList<>());
    }

}
