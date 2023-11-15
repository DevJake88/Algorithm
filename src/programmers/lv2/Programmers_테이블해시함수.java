package programmers.lv2;

import java.util.Arrays;
import java.util.Comparator;

public class Programmers_테이블해시함수 {

	public static void main(String[] args) {
		Programmers_테이블해시함수 test = new Programmers_테이블해시함수();
		int[][] data = {{2,2,6},{1,5,10},{4,2,9},{3,8,3}};
		int col = 2;
		int row_begin = 2;
		int row_end = 3;
		int result = test.solution(data, col, row_begin, row_end);
		System.out.println(result);
	}

	public int solution(int[][] data, int col, int row_begin, int row_end) {
        int answer = 0;
        
        Arrays.sort(data, new Comparator<int[]>() {
			@Override
			public int compare(int[] o1, int[] o2) {
				if(o1[col-1]==o2[col-1]) return o2[0]-o1[0];
				else return o1[col-1]-o2[col-1];
			}
        });
        
        for(int i=row_begin-1; i<=row_end-1; i++) {
        	int num = 0;
        	for(int j=0; j<data[i].length; j++) {
        		num += (data[i][j] % (i+1));
        	}
        	answer ^= num;	// xor 비트연산자
        }
        
        return answer;
    }
}
