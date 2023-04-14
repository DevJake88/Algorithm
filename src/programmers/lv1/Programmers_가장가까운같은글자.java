package programmers.lv1;

import java.util.Arrays;
import java.util.HashMap;

public class Programmers_가장가까운같은글자 {
	public static void main(String[] args) {
		String s = "banana";
		int[] result = solution(s);
		System.out.println(Arrays.toString(result));
	}
	
	public static int[] solution(String s) {
        int[] answer = new int[s.length()];
        
        char[] charArr = s.toCharArray();
        HashMap<Character, Integer> hm = new HashMap<Character, Integer>();
        
        for(int i=0; i<charArr.length; i++) {
            if (hm.containsKey(charArr[i])) {
                answer[i] = i-hm.get(charArr[i]);
                hm.put(charArr[i], i);
            } else {
                answer[i] = -1;
                hm.put(charArr[i], i);
            }
        }
        
        return answer;
    }
}
