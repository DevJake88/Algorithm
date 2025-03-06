package programmers.lv1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

public class Programmers_데이터분석 {
    public static void main(String[] args) {
        int[][] data = {{1, 20300104, 100, 80}, {2, 20300804, 847, 37}, {3, 20300401, 10, 8}};
        String ext = "date";
        int val_ext = 20300501;
        String sort_by = "remain";
        
        Programmers_데이터분석 test = new Programmers_데이터분석();
        int[][] result = test.solution(data, ext, val_ext, sort_by);
        for (int i = 0; i < result.length; i++) {
            System.out.println(Arrays.toString(result[i]));
        }
    }

    public int[][] solution(int[][] data, String ext, int val_ext, String sort_by) {
        int[][] answer = {};

        Arrays.sort(data, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                int arrIdx = 0;
                switch (sort_by) {
                    case "code":
                        arrIdx = 0;
                        break;
                    case "date":
                        arrIdx = 1;
                        break;
                    case "maximum":
                        arrIdx = 2;
                        break;
                    case "remain":
                        arrIdx = 3;
                        break;
                }
                return o1[arrIdx] - o2[arrIdx];
            }
        });

        int arrIdx = 0;
        switch (ext) {
            case "code":
                arrIdx = 0;
                break;
            case "date":
                arrIdx = 1;
                break;
            case "maximum":
                arrIdx = 2;
                break;
            case "remain":
                arrIdx = 3;
                break;
        }

        ArrayList<int[]> list = new ArrayList<int[]>();
        for (int i = 0; i < data.length; i++) {
            if(data[i][arrIdx] < val_ext) {
                list.add(data[i]);
            }
        }

        answer = new int[list.size()][4];
        for (int i = 0; i < answer.length; i++) {
            answer[i] = list.get(i);
        }
        return answer;
    }
}
