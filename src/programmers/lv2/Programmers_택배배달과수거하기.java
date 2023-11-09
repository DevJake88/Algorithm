package programmers.lv2;

public class Programmers_택배배달과수거하기 {

	public static void main(String[] args) {
		Programmers_택배배달과수거하기 test = new Programmers_택배배달과수거하기();
		int cap = 4;
		int n = 5;
		int[] deliveries = {1, 0, 3, 1, 2};
		int[] pickups = {0, 3, 0, 4, 0};
		long result = test.solution(cap, n, deliveries, pickups);
		System.out.println(result);
	}
	
	public long solution(int cap, int n, int[] deliveries, int[] pickups) {
        long answer = 0;
        
        int d = 0;
        int p = 0;
        for(int i=n-1; i>=0; i--) {
        	if(deliveries[i] > 0 || pickups[i] > 0) {
        		d += deliveries[i];
        		p += pickups[i];
        		
        		while(d > 0 || p > 0) {
        			d -= cap;
        			p -= cap;
        			answer += (i+1)*2;
        		}
        		
        	}
        }
        return answer;
    }

}
