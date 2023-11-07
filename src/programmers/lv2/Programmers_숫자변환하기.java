package programmers.lv2;

public class Programmers_숫자변환하기 {

	public static void main(String[] args) {
		Programmers_숫자변환하기 test = new Programmers_숫자변환하기();
		int x = 10, y = 40, n = 5;
		int result = test.solution(x, y, n);
		System.out.println(result);
	}
	
	public int solution(int x, int y, int n) {
        int[] dp = new int[y+1];
        
        for(int i=x; i<=y; i++) {
        	if(i != x && dp[i] == 0) {
        		dp[i] = -1;
        		continue;
        	}
        	
        	if(i*2 <= y) dp[i*2] = (dp[i*2] == 0) ? dp[i]+1 : Math.min(dp[i*2], dp[i]+1);
        	if(i*3 <= y) dp[i*3] = (dp[i*3] == 0) ? dp[i]+1 : Math.min(dp[i*3], dp[i]+1);
        	if(i+n <= y) dp[i+n] = (dp[i+n] == 0) ? dp[i]+1 : Math.min(dp[i+n], dp[i]+1);
        }
        
        return dp[y];
    }

}
