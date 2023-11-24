package programmers.lv2;

import java.util.Stack;

public class Programmers_택배상자 {

	public static void main(String[] args) {
		Programmers_택배상자 test = new Programmers_택배상자();
		int[] order = {2, 1, 4, 3, 6, 5, 8, 7, 10, 9};
		int result = test.solution(order);
		System.out.println(result);
	}
	
	public int solution(int[] order) {
        int answer = 0;
        
        Stack<Integer> stack = new Stack<Integer>();
        for(int i=1; i<=order.length; i++) {
        	stack.push(i);
        	
        	while(!stack.isEmpty() && stack.peek() == order[answer]) {
        		stack.pop();
        		answer++;
        	}
        }
        return answer;
    }

}
