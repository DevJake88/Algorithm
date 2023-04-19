package programmers.lv1;

public class Programmers_콜라문제 {

	public static void main(String[] args) {
		int a = 2;
		int b = 1;
		int n = 20;
		
		int result = solution(a,b,n);
		System.out.println(result);
	}
	
	public static int solution(int a, int b, int n) {
        int answer = 0;
        
        while(n>=a) {
            answer += (n / a) * b;
            n = (n / a) * b + (n % a);    
        }
        return answer;
    }

}
