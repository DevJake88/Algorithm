package programmers.lv1;

import java.util.HashMap;

public class Programmers_추억점수 {
	public static void main(String[] args) {
		String[] name = {"may", "kein", "kain", "radi"};
		int[] yearning = {5, 10, 1, 3};
		String[][] photo = {{"may", "kein", "kain", "radi"}, {"may", "kein", "brin", "deny"}, {"kon", "kain", "may", "coni"}};
		
		int[] result = solution(name, yearning, photo);
		for (int i : result) {
			System.out.println(i);
		}
	}
	
    public static int[] solution(String[] name, int[] yearning, String[][] photo) {
        int[] answer = new int[photo.length];
        
        // HashMap 에 담기
        HashMap<String, Integer> hm = new HashMap<String, Integer>();
        for(int i=0; i<name.length; i++) {
            hm.put(name[i], yearning[i]);
        }
        
        // photo 순회하면서 점수 체크
        for(int i=0; i<photo.length; i++) {
            int sum = 0;
            for(int j=0; j<photo[i].length; j++) {
                if(hm.containsKey(photo[i][j])) {
                    sum += hm.get(photo[i][j]);
                }
            }
            answer[i] = sum;
        }
        
        return answer;
    }
}
