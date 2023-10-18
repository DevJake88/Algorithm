package programmers.lv2;

public class Programmers_두원사이의정수쌍 {
	public static void main(String[] args) {
		Programmers_두원사이의정수쌍 test = new Programmers_두원사이의정수쌍();
		int r1 = 2;
		int r2 = 3;
		long result = test.solution(r1, r2);
		System.out.println(result);
	}
	
	
	public long solution(int r1, int r2) {
        long answer = 0;
        
        for(int i=1; i<=r2; i++) {
        	int l1 = (int) Math.ceil(Math.sqrt((long)r1*r1 - (long)i*i));
        	int l2 = (int) Math.floor(Math.sqrt((long)r2*r2 - (long)i*i));
        	answer += (l2-l1+1);
        }
        
        answer *= 4;
        return answer;
    }
}
