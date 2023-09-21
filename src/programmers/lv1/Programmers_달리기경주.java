package programmers.lv1;

import java.util.Arrays;

public class Programmers_달리기경주 {
	public String[] solution(String[] players, String[] callings) {
		String[] answer = players.clone();
        
        for(int i=0; i<callings.length; i++) {
        	for(int j=0; j<answer.length; j++) {
        		if(callings[i].equals(answer[j])) {
        			// swap
        			String temp = answer[j-1];
        			answer[j-1] = answer[j];
        			answer[j] = temp;
        		}
        	}
        }
        System.out.println(Arrays.toString(answer));
        return answer;
    }
	
	public static void main(String[] args) {
		Programmers_달리기경주 test = new Programmers_달리기경주();
		
		String[] players = {"mumu", "soe", "poe", "kai", "mine"};
		String[] callings = {"kai", "kai", "mine", "mine"};
		test.solution(players, callings);
	}

}
