package programmers.lv1;

import java.util.Arrays;
import java.util.PriorityQueue;

public class Programmers_명예의전당1 {
	
	public int[] solution(int k, int[] score) {
        int[] answer = new int[score.length];
        PriorityQueue<Integer> pq = new PriorityQueue<Integer>();
        
        for(int i=0; i<score.length; i++) {
            pq.add(score[i]);
            if (i>=k) pq.poll();
            answer[i] = pq.peek();
        }
        return answer;
    }
	
	
	public static void main(String[] args) {
		Programmers_명예의전당1 test = new Programmers_명예의전당1();
		int k = 3;
		int[] score = {10, 100, 20, 150, 1, 100, 200};
		
		int[] result = test.solution(k, score);
		System.out.println(Arrays.toString(result));
	}

}
