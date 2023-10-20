package programmers.lv1;

public class Programmers_약수의개수와덧셈 {
	
	public static void main(String[] args) {
		Programmers_약수의개수와덧셈 test = new Programmers_약수의개수와덧셈();
		int left = 13;
		int right = 17;
		int result = test.solution(left, right);
		System.out.println(result);
	}
	
	public int solution(int left, int right) {
        int answer = 0;
        
        for(int i=left; i<=right; i++) {
        	int count = getMeasureCount(i);
        	if(count % 2 == 0) answer += i;
        	else answer -= i;
        }
        
        return answer;
    }
	
	// 64 => 1 2 4 8 
	public int getMeasureCount(int num) {
		int measureCount = 0;
		for(int i=1; i<Math.sqrt(num); i++) {
			if(num % i == 0) measureCount++;
		}
		measureCount *= 2;
		if(num % Math.sqrt(num) == 0) measureCount += 1;
		return measureCount;
	}

}
