package programmers.lv1;

public class Programmers_3진법뒤집기 {
	public static void main(String[] args) {
		Programmers_3진법뒤집기 test = new Programmers_3진법뒤집기();
		int n = 45;
		int result = test.solution(n);
		System.out.println(result);
	}
	
	public int solution(int n) {
        int answer = 0;
        String convertNum = "";
        
        while(n > 0) {
        	convertNum += Integer.toString(n%3);
        	n/=3;
        }
        // convertNum += Integer.toString(n);

        for(int i=0; i<convertNum.length(); i++) {
        	int num = (int) ((convertNum.charAt(i)-'0') * Math.pow(3, convertNum.length()-1-i));
        	answer += num;
        }
        
        return answer;
    }
}
