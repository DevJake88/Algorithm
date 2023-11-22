package programmers.lv2;

import java.util.ArrayList;
import java.util.Arrays;

public class Programmers_우박수열정적분 {

	public static void main(String[] args) {
		Programmers_우박수열정적분 test = new Programmers_우박수열정적분();
		int k = 5;
		int[][] ranges = {{0,0},{0,-1},{2,-3},{3,-3}};
		double[] result = test.solution(k, ranges);
		System.out.println(Arrays.toString(result));
	}
	
	public double[] solution(int k, int[][] ranges) {
        double[] answer = new double[ranges.length];
        ArrayList<Double> list = new ArrayList<Double>();
        
        // 콜라츠 추측
        while(k > 1) {
        	int num1 = k;
        	if(k%2 == 0) k /= 2;
        	else k = (k*3)+1;
        	int num2 = k;
        	list.add((num1 + num2) / 2.0);
        }
        
        
        // 구간별 정적분 구하기
        for(int i=0; i<ranges.length; i++) {
        	int start = ranges[i][0];
        	int end = list.size() + ranges[i][1];
        	
        	if(start > end) answer[i] = -1.0;
        	else {
        		double sum = 0;
        		for(int j=start; j<end; j++) sum += list.get(j);
        		answer[i] = sum;
        	}
        }
        
        return answer;
    }

}
