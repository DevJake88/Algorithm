package programmers.lv2;

import java.util.Arrays;
import java.util.Stack;

public class Programmers_뒤에있는큰수찾기 {

	public static void main(String[] args) {
		Programmers_뒤에있는큰수찾기 test = new Programmers_뒤에있는큰수찾기();
		int[] numbers = {9, 1, 5, 3, 6, 2};
		int[] result = test.solution(numbers);
		System.out.println(Arrays.toString(result));
	}
	
	public int[] solution(int[] numbers) {
        int[] answer = new int[numbers.length];
        Stack<Integer> stack = new Stack<Integer>();
        
        for(int i=numbers.length-1; i>=0; i--) {
        	
        	while(!stack.isEmpty()) {
        		if(numbers[i] < stack.peek()) {
        			answer[i] = stack.peek();
        			break;
        		} else {
        			stack.pop();
        		}
        	}
        	
        	if(stack.isEmpty()) answer[i] = -1;
        	stack.push(numbers[i]);
        }
        
        return answer;
    }

}
