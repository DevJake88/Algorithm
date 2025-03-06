package programmers.lv1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map;

public class Programmers_데이터분석_refactor {
    public static void main(String[] args) {
        int[][] data = {{1, 20300104, 100, 80}, {2, 20300804, 847, 37}, {3, 20300401, 10, 8}};
        String ext = "date";
        int val_ext = 20300501;
        String sort_by = "remain";
        
        Programmers_데이터분석_refactor test = new Programmers_데이터분석_refactor();
        int[][] result = test.solution(data, ext, val_ext, sort_by);
        for (int i = 0; i < result.length; i++) {
            System.out.println(Arrays.toString(result[i]));
        }
    }

    public int[][] solution(int[][] data, String ext, int val_ext, String sort_by) {
        // 컬럼 인덱스 매핑
        Map<String, Integer> colIndex = Map.of(
            "code", 0, "date", 1, "maximum", 2, "remain", 3
        );

        // 필터링 먼저 수행
        List<int[]> filteredList = new ArrayList<>();
        for (int[] row : data) {
            if(row[colIndex.get(ext)] < val_ext) {
                filteredList.add(row);
            }
        }

        // 정렬 수행
        filteredList.sort(Comparator.comparingInt(row -> row[colIndex.get(sort_by)]));

        return filteredList.toArray(new int[0][]);
    }
}