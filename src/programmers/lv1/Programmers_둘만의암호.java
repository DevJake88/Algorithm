package programmers.lv1;

public class Programmers_둘만의암호 {
	public String solution(String s, String skip, int index) {
        String answer = "";
        
        for(int i=0; i<s.length(); i++) {
            char alpha = s.charAt(i);
            int count = 1;

            while(count <= index) {
                alpha++;
                if (alpha > 'z') alpha-=26;
                if (!skip.contains(alpha+"")) count++;
            }
            
            answer += alpha;
        }
        return answer;
    }

	public static void main(String[] args) {
		Programmers_둘만의암호 test = new Programmers_둘만의암호();
		String s = "aukks";	// "z"
		String skip = "wbqd";	// "abcdefghij"
		int index = 5;	// 20
		
		String result = test.solution(s, skip, index);
		System.out.println(result);	// "n"
	}

}
