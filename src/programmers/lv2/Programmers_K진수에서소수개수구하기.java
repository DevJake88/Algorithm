package programmers.lv2;

public class Programmers_K진수에서소수개수구하기 {

	public static void main(String[] args) {
		Programmers_K진수에서소수개수구하기 test = new Programmers_K진수에서소수개수구하기();
		int n = 437674;
		int k = 3;
		int result = test.solution(n, k);
		System.out.println(result);
	}
	
	public int solution(int n, int k) {
        int answer = 0;
        
        String convertNum = "";
        while(n!=0) {
        	int remain = n%k;
        	convertNum = remain + convertNum;
        	n = n/k;
        }
        
        String[] strArr = convertNum.split("0");
        for (String str : strArr) {
			if(!str.equals("") && isPrime(Long.parseLong(str))) answer++;
		}
        return answer;
    }
	
	public boolean isPrime(long num) {
		if(num < 2) return false;
		for(long i=2; i<= Math.sqrt(num); i++) {
			if(num % i == 0) return false;
		}
		return true;
	}

}
