package programmers.lv0;

public class Programmers_숫자찾기 {
	public static void main(String args) {
		int num = 29183;
		int k = 1;
		int result = solution(num, k);
		System.out.println(result);
	}
	
	public static int solution(int num, int k) {
        int answer = -1;
        
        String str = Integer.toString(num);
        for(int i=0; i<str.length(); i++) {
            if(str.charAt(i)-'0' == k) {
                answer = i+1;
                break;
            }
        }
        
        return answer;
    }
}
