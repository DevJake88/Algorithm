package programmers.lv2;

import java.util.Collections;
import java.util.PriorityQueue;

public class Programmers_디펜스게임 {

	public static void main(String[] args) {
		Programmers_디펜스게임 test = new Programmers_디펜스게임();
		int n = 2;
		int k = 4;
		int[] enemy = {3, 3, 3, 3};
		int result = test.solution(n, k, enemy);
		System.out.println(result);
	}
	
	public int solution(int n, int k, int[] enemy) {
        int answer = 0;
        
        PriorityQueue<Integer> pq = new PriorityQueue<Integer>(Collections.reverseOrder());
        for(int i=0; i<enemy.length; i++) {
        	n -= enemy[i];
        	pq.add(enemy[i]);
        	
        	if(n < 0) {
        		if(k > 0) {
        			n += pq.poll();
        			k--;
        		} else {
        			answer = i;
        			break;
        		}
        	}
        }

        if(n >= 0) answer = enemy.length;
        return answer;
    }

}
