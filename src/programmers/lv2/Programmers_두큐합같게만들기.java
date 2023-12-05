package programmers.lv2;

import java.util.LinkedList;
import java.util.Queue;

public class Programmers_두큐합같게만들기 {

	public static void main(String[] args) {
		Programmers_두큐합같게만들기 test = new Programmers_두큐합같게만들기();
		int[] queue1 = {3, 2, 7, 2};
		int[] queue2 = {4, 6, 5, 1};
		int result = test.solution(queue1, queue2);
		System.out.println(result);
	}
	
	public int solution(int[] queue1, int[] queue2) {
        Queue<Integer> q1 = new LinkedList<Integer>();
        Queue<Integer> q2 = new LinkedList<Integer>();
        long sum1 = getSum(queue1);
        long sum2 = getSum(queue2);
        
        for(int i=0; i<queue1.length; i++) {
        	q1.add(queue1[i]);
        	q2.add(queue2[i]);
        }

        int answer = 0;
        while(sum1 != sum2) {
        	if(answer > (queue1.length + queue2.length)*2) {
        		answer = -1;
        		break;
        	}
        	
        	int num = 0;
        	if(sum1 > sum2) {
        		num = q1.poll();
        		q2.add(num);
        		sum1 -= num;
        		sum2 += num;
        	} else if(sum1 < sum2) {
        		num = q2.poll();
        		q1.add(num);
        		sum2 -= num;
        		sum1 += num;
        	} else {
        		break;
        	}
        	answer++;
        }
        return answer;
    }
	
	public long getSum(int[] queue) {
		long sum = 0;
		for (Integer integer : queue) sum += integer;
		return sum;
	}

}
