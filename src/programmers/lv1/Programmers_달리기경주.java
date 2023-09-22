package programmers.lv1;

import java.util.Arrays;
import java.util.HashMap;

public class Programmers_달리기경주 {
	public String[] solution(String[] players, String[] callings) {
		String[] answer = players.clone();
        HashMap<String, Integer> hm = new HashMap<String, Integer>();
		
		for(int i=0; i<players.length; i++) {
			hm.put(players[i], i);
		}
		
		for(int i=0; i<callings.length; i++) {
			int index = hm.get(callings[i]);
			
			// swap
			String temp = answer[index-1];
			answer[index-1] = callings[i];
			answer[index] = temp;
			
			// hash map update
			hm.put(temp, index);
			hm.put(callings[i], index-1);
		}

		for(int i=0; i<players.length; i++) {
			int idx = hm.get(players[i]);
			answer[idx] = players[i];
		}
		
        return answer;
    }
	
	public static void main(String[] args) {
		Programmers_달리기경주 test = new Programmers_달리기경주();
		
		String[] players = {"mumu", "soe", "poe", "kai", "mine"};
		String[] callings = {"kai", "kai", "mine", "mine"};
		
		String[] result = test.solution(players, callings);
		System.out.println(Arrays.toString(result));
	}

}
