package programmers.lv1;

public class Programmers_기사단원의무기 {
	
	public int solution(int number, int limit, int power) {
        int answer = 0;
        
        for(int i=1; i<=number; i++) {
            int count = 0;
            for(int j=1; j<=(int)Math.sqrt(i); j++) {
                if (j*j == i) {
                    count++;
                } else if (i%j == 0) {
                    count+=2;
                }
            }
            answer += count > limit ? power : count;
        }
        return answer;
    }
	
	
	public static void main(String[] args) {
		Programmers_기사단원의무기 test = new Programmers_기사단원의무기();
		int number = 5;
		int limit = 3;
		int power = 2;
		int result = test.solution(number, limit, power);
		System.out.println(result);
	}
}
