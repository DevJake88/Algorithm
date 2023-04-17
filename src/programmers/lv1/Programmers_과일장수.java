package programmers.lv1;

import java.util.Arrays;

public class Programmers_과일장수 {
	public static void main(String[] args) {
		int k = 3;
		int m = 4;
		int[] score = {1, 2, 3, 1, 2, 3, 1};
		
		int result = solution(k, m, score);
		System.out.println(result);
	}
	
	public static int solution(int k, int m, int[] score) {
        int answer = 0;
        Arrays.sort(score);
        
        for (int i=score.length-m; i>=0; i-=m) {
            answer += score[i]*m;
        }
        
        return answer;
    }
}
