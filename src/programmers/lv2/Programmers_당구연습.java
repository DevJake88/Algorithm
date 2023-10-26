package programmers.lv2;

import java.util.Arrays;

public class Programmers_당구연습 {
	public static void main(String[] args) {
		Programmers_당구연습 test = new Programmers_당구연습();
		int m = 10;
		int n = 10;
		int startX = 3;
		int startY = 7;
		int[][] balls = {{7, 7}, {2, 7}, {7, 3}};
		int[] result = test.solution(m, n, startX, startY, balls);
		System.out.println(Arrays.toString(result));
	}
	
	public int[] solution(int m, int n, int startX, int startY, int[][] balls) {
        int[] answer = new int[balls.length];
        
        for(int i=0; i<balls.length; i++) {
        	int targetX = balls[i][0];
        	int targetY = balls[i][1];
        	int minDistance = Integer.MAX_VALUE;
        	
        	// 상
        	if(!(startX == targetX && startY <= targetY)) {
        		int distance = getDistance(startX, startY, targetX, n+(n-targetY));
        		minDistance = Math.min(minDistance, distance);
        	}
        	
        	// 하
        	if(!(startX == targetX && startY >= targetY)) {
        		int distance = getDistance(startX, startY, targetX, -1*targetY);
        		minDistance = Math.min(minDistance, distance);
        	}
        	
        	// 좌
        	if(!(startY == targetY && startX >= targetX)) {
        		int distance = getDistance(startX, startY, -1*targetX, targetY);
        		minDistance = Math.min(minDistance, distance);
        	}
        	
        	// 우 
        	if(!(startY == targetY && startX <= targetX)) {
        		int distance = getDistance(startX, startY, m+(m-targetX), targetY);
        		minDistance = Math.min(minDistance, distance);
        	}
        	
        	answer[i] = minDistance;
        }
        return answer;
    }
	
	public int getDistance(int startX, int startY, int targetX, int targetY) {
		return (int) (Math.pow(targetX-startX, 2) + Math.pow(targetY-startY, 2));
	}
}
