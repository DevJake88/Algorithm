package programmers.lv1;

public class Programmers_문자열나누기 {
	
	public int solution(String s) {
        int answer = 0;
        char[] arr = s.toCharArray();
        int idx = 0;
        
        while(true) {
            char c = arr[idx];
            int diffCount = 0;
            int sameCount = 1;
            
            for(int i=idx+1; i<arr.length; i++) {
                if (c == arr[i]) {
                    sameCount++;
                } else {
                    diffCount++;
                }
                
                if (sameCount == diffCount) {
                    idx = i+1;
                    answer++;
                    break;
                } else {
                	if (i == arr.length-1) {
                		idx = arr.length-1;
                		break;
                	}
                }
            }
            
            if (idx > arr.length-1) {
                break;                
            } else if (idx == arr.length-1) {
                answer++;
                break;
            }
        }
        
        return answer;
    }
	
	public static void main(String[] args) {
		Programmers_문자열나누기 test = new Programmers_문자열나누기();
		
		String s = "aabbcddd";
		int result = test.solution(s);
		System.out.println(result);
	}
	
}
