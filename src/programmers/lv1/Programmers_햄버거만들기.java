package programmers.lv1;

import java.util.Stack;

public class Programmers_햄버거만들기 {
	public static void main(String[] args) {
		Programmers_햄버거만들기 test = new Programmers_햄버거만들기();
		int[] ingredient = {2, 1, 1, 2, 3, 1, 2, 3, 1};
		int result = test.solution(ingredient);
		System.out.println("result: " + result);
	}
	
	public int solution(int[] ingredient) {
        int answer = 0;
        
        Stack<Integer> stack = new Stack<Integer>();
        
        for(int i=0; i<ingredient.length; i++) {
        	stack.push(ingredient[i]);
        	
        	if(stack.size() >= 4) {
    			if(stack.get(stack.size()-1) == 1 && stack.get(stack.size()-2) == 3 && stack.get(stack.size()-3) == 2 && stack.get(stack.size()-4) == 1) {
    				answer++;
    				stack.pop();
    				stack.pop();
    				stack.pop();
    				stack.pop();
    			}
        	}
        }
        
        return answer;
    }
}


