package programmers.lv1;

import java.util.Arrays;

public class Programmers_체육복_내꺼말고 {

	public static void main(String[] args) {
		Programmers_체육복_내꺼말고 test = new Programmers_체육복_내꺼말고();
		int n = 5;
		int[] lost = {2,3,5};
		int[] reserve = {2,3,4};
		int result = test.solution(n, lost, reserve);
		System.out.println(result);
	}
	
	public int solution(int n, int[] lost, int[] reserve) {
        int answer = n-lost.length;
        Arrays.sort(lost);
        Arrays.sort(reserve);
        
        for(int i=0; i<lost.length; i++) {
        	for(int j=0; j<reserve.length; j++) {
        		if(lost[i] == reserve[j]) {
        			answer++;
        			lost[i] = -1;
        			reserve[j] = -1;
        			break;
        		}
        	}
        }
        
        for(int i=0; i<lost.length; i++) {
        	for(int j=0; j<reserve.length; j++) {
        		if((lost[i]-1 == reserve[j]) || (lost[i]+1 == reserve[j])) {
        			answer++;
        			reserve[j] = -1;
        			break;
        		}
        	}
        }
        
        return answer;
    }
}
