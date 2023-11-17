package programmers.lv2;

public class Programmers_점찍기 {
	public static void main(String[] args) {
		Programmers_점찍기 test = new Programmers_점찍기();
		int k = 2;
		int d = 4;
		long result = test.solution(k, d);
		System.out.println(result);
	}
	
	public long solution(int k, int d) {
        long answer = 0;

        for (int i = 0; i <= d; i+=k) {
        	// x^2 + y^2 = r^2
        	long y = (long) Math.sqrt(Math.pow(d, 2) - Math.pow(i, 2)) / k;
        	answer += (y+1);
		}
        
        return answer;
    }
}
