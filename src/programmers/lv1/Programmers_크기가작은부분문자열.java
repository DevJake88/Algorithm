package programmers.lv1;

public class Programmers_크기가작은부분문자열 {
	public static void main(String[] args) {
		String t = "3141592";
		String p = "271";
		int result = solution(t, p);
		System.out.println(result);
	}
	
	public static int solution(String t, String p) {
        int answer = 0;
        
        long pNum = Long.parseLong(p);
        int pLen = p.length();

        for(int i=0; i<=t.length()-pLen; i++) {
            long tNum = Long.parseLong(t.substring(i,i+pLen));
            if (tNum <= pNum) answer++;
        }
        
        return answer;
    }
}
