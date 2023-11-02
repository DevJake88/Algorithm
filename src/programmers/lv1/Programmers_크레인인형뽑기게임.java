package programmers.lv1;

import java.util.Stack;

public class Programmers_크레인인형뽑기게임 {

	public static void main(String[] args) {
		int[][] board = {{0,0,0,0,0},{0,0,1,0,3},{0,2,5,0,1},{4,2,4,4,2},{3,5,1,3,1}};
		int[] moves = {1,5,3,5,1,2,1,4};
		Programmers_크레인인형뽑기게임 test = new Programmers_크레인인형뽑기게임();
		int result = test.solution(board, moves);
		System.out.println(result);
	}
	
	public int solution(int[][] board, int[] moves) {
        int answer = 0;
        Stack<Integer> stack = new Stack<Integer>();
        
        for(int i=0; i<moves.length; i++) {
        	int move = moves[i]-1;
        	
        	for(int j=0; j<board.length; j++) {
        		int doll = board[j][move];
        		if(doll != 0) {	// 인형을 뽑았으면
        			if(stack.isEmpty()) { 
        				stack.push(doll);
        			} else {
        				// 바구니 꼭대기 인형이랑 비교해서 겹치면 팡!
        				// 안겹치면 바구니에 넣는다.
        				int stackTop = stack.pop();
        				if(stackTop == doll) {
        					answer+=2;
        				} else {
        					stack.push(stackTop);
        					stack.push(doll);
        				}
        			}
        			board[j][move] = 0;
        			break;
        		}
        	}
        }
        return answer;
    }

}
