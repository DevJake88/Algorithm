package programmers.lv2;

import java.util.Arrays;

public class Programmers_연속된부분수열의합 {
	public static void main(String[] args) {
		Programmers_연속된부분수열의합 test = new Programmers_연속된부분수열의합();
		int[] sequence = {1, 2, 3, 4, 5};
		int k = 7;
		
		int[] result = test.solution(sequence, k);
		System.out.println(Arrays.toString(result));
	}
	
	public int[] solution(int[] sequence, int k) {
		int left = 0, right = 0;
		int sum = 0;
		int size = sequence.length;
		int answerLeft = 0, answerRight = 0;
		
		for(right=0; right<sequence.length; right++) {
			sum += sequence[right];
			
			// sum이 K보다 넘어갔을 경우
			// left 포인터를 옮긴다.
			while(sum > k) {
				sum -= sequence[left];
				left++;
			}
			
			// sum이 k랑 같은 경우
			if(sum == k) {
				if(size > right-left) {
					size = right-left;
					answerRight = right;
					answerLeft = left;
				} else if(answerRight-answerLeft == right-left) {
					answerRight = Math.min(right, answerRight);
					answerLeft = Math.min(left, answerLeft);
				}
			}
		}
		
		int[] answer = new int[] {answerLeft, answerRight};
		return answer;
	}
	
	/*
	public int[] solution(int[] sequence, int k) {
        int[] answer = new int[2];
        

        for(int i=sequence.length-1; i>=0; i--) {
        	
        	int startIdx = i;
        	long sum = 0;
        	
        	while(true) {
        		sum += sequence[startIdx];
        		if(sum > k) {
        			break;
        		} else if(sum == k) {
        			saveAnswer(answer, startIdx, i);
        			break;
        		}
        		if(startIdx == 0) break;
        		startIdx--;
        	}
        }
        return answer;
    }
	
	
	public void saveAnswer(int[] arr, int start, int end) {
		if ((arr[0] == 0 && arr[1] == 0) || arr[1]-arr[0] >= end-start) {
			arr[0] = start;
			arr[1] = end;
		}
	}
	*/
	
}
