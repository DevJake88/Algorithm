package programmers.lv1;

import java.util.ArrayList;
import java.util.Arrays;

public class Programmers_체육복 {

	public static void main(String[] args) {
		Programmers_체육복 test = new Programmers_체육복();
		int n = 5;
		int[] lost = {2,3,5};
		int[] reserve = {2,3,4};
		int result = test.solution(n, lost, reserve);
		System.out.println(result);
	}
	
	public int solution(int n, int[] lost, int[] reserve) {
        int answer = 0;
        ArrayList<Integer> borrowList = new ArrayList<Integer>();
        ArrayList<Integer> resolveList = new ArrayList<Integer>();
        Arrays.sort(lost);
        Arrays.sort(reserve);
        
        for(int i=0; i<lost.length; i++) {
        	for(int j=0; j<reserve.length; j++) {
        		if(lost[i] == reserve[j]) {
        			borrowList.add(reserve[j]);
        			resolveList.add(lost[i]);
        		}
        	}
        }
        
        for(int i=0; i<lost.length; i++) {
        	int lostNum = lost[i];
        	if(resolveList.contains(lostNum)) continue;
        	for(int j=0; j<reserve.length; j++) {
        		if(!borrowList.contains(reserve[j]) && (lostNum-1 == reserve[j] || lostNum+1 == reserve[j])) {
        			borrowList.add(reserve[j]);
        			resolveList.add(lost[i]);
        			break;
        		}
        	}
        }
        
        answer = n-lost.length+resolveList.size();
        return answer;
    }

}
