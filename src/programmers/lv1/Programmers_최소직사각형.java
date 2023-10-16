package programmers.lv1;

public class Programmers_최소직사각형 {
	public static void main(String[] args) {
		Programmers_최소직사각형 test = new Programmers_최소직사각형();
		int[][] sizes = {{60, 50},{30, 70},{60, 30},{80, 40}};
		int result = test.solution(sizes);
		System.out.println(result);
	}
	
	public int solution(int[][] sizes) {
        int answer = 0;
        
        int maxX = 0;
        int maxY = 0;
        
        for(int i=0; i<sizes.length; i++) {
        	int num1 = sizes[i][0];
        	int num2 = sizes[i][1];
        	
        	if(num1 >= num2) {
        		maxX = Math.max(maxX, num1);
        		maxY = Math.max(maxY, num2);
        	} else {
        		maxX = Math.max(maxX, num2);
        		maxY = Math.max(maxY, num1);
        	}
        }
        
        answer = maxX * maxY;
        return answer;
    }
}
