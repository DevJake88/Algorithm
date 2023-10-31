package programmers.lv1;

public class Programmers_키패드누르기 {
	public static void main(String[] args) {
		Programmers_키패드누르기 test = new Programmers_키패드누르기();
		int[] numbers = {1, 3, 4, 5, 8, 2, 1, 4, 5, 9, 5};
		String hand = "right";
		String result = test.solution(numbers, hand);
		System.out.println(result);
	}
	
	public String solution(int[] numbers, String hand) {
        String answer = "";
        
        int[] leftFinger = {0,3};
        int[] rightFinger = {2,3};
        
        for(int i=0; i<numbers.length; i++) {
        	int key = numbers[i];
        	if(key == 1 || key == 4 || key == 7) {
        		leftFinger[0] = 0;
        		leftFinger[1] = key/3;
        		answer += "L";
        	} else if(key == 3 || key == 6 || key == 9) {
        		rightFinger[0] = 2;
        		rightFinger[1] = key/3-1;
        		answer += "R";
        	} else {
        		int[] middle = {1,0};
        		if(key == 2) {
        			middle[1] = 0; 
        		} else if(key == 5) {
        			middle[1] = 1;
        		} else if(key == 8) {
        			middle[1] = 2;
        		} else if(key == 0) {
        			middle[1] = 3;
        		}
        		
        		// 위치 비교
        		int leftDistance = Math.abs(leftFinger[0] - middle[0]) + Math.abs(leftFinger[1] - middle[1]);
        		int rightDistance = Math.abs(rightFinger[0] - middle[0]) + Math.abs(rightFinger[1] - middle[1]);
        		
        		if(leftDistance > rightDistance) {
        			rightFinger[0] = middle[0];
        			rightFinger[1] = middle[1];
        			answer += "R";
        		} else if(leftDistance < rightDistance) {
        			leftFinger[0] = middle[0];
        			leftFinger[1] = middle[1];
        			answer += "L";
        		} else {
        			if(hand.equals("right")) {
        				rightFinger[0] = middle[0];
            			rightFinger[1] = middle[1];
        				answer += "R";
        			} else {
        				leftFinger[0] = middle[0];
            			leftFinger[1] = middle[1];
        				answer += "L";
        			}
        		}
        	}
        }
        
        return answer;
    }
}
