package programmers.lv1;

public class Programmers_키패드누르기_다른풀이 {
	public static void main(String[] args) {
		Programmers_키패드누르기_다른풀이 test = new Programmers_키패드누르기_다른풀이();
		int[] numbers = {1, 3, 4, 5, 8, 2, 1, 4, 5, 9, 5};
		String hand = "right";
		String result = test.solution(numbers, hand);
		System.out.println(result);
	}
	
	int[][] numpadPos = {
			{3,1}, // 0
			{0,0}, // 1
			{0,1}, // 2
			{0,2}, // 3
			{1,0}, // 4
			{1,1}, // 5
			{1,2}, // 6
			{2,0}, // 7
			{2,1}, // 8
			{2,2}, // 9
	};
	int[] leftPos = {3,0};
	int[] rightPos = {3,2};
	
	public String solution(int[] numbers, String hand) {
        String answer = "";
        
        for (int num : numbers) {
			String finger = pushNumber(num, hand);
        	answer += finger;
        	
        	if(finger.equals("L")) {
        		leftPos = numpadPos[num];
        		continue;
        	}
        	if(finger.equals("R")) {
        		rightPos = numpadPos[num];
        		continue;
        	}
		}
        return answer;
    }
	
	private String pushNumber(int num, String hand) {
		if(num == 1 || num == 4 || num == 7) return "L";
		if(num == 3 || num == 6 || num == 9) return "R";
		
		// 2,5,8,0
		if(getDist(leftPos, num) > getDist(rightPos, num)) return "R";
		else if(getDist(leftPos, num) < getDist(rightPos, num)) return "L";
		else return hand.equals("right") ? "R" : "L";
	}
	
	private int getDist(int[] pos, int num) {
		return Math.abs(pos[0]-numpadPos[num][0]) + Math.abs(pos[1]-numpadPos[num][1]);
	}
}
