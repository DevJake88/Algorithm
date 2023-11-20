package programmers.lv2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;

public class Programmers_귤고르기 {

	public static void main(String[] args) {
		Programmers_귤고르기 test = new Programmers_귤고르기();
		int k = 2;
		int[] tangerine = {1, 1, 1, 1, 2, 2, 2, 3};
		int result = test.solution(k, tangerine);
		System.out.println(result);
	}

	public int solution(int k, int[] tangerine) {
        int answer = 0;
        
        HashMap<Integer, Integer> hm = new HashMap<Integer, Integer>();
        for (int i : tangerine) hm.put(i, hm.getOrDefault(i, 0) + 1);

        ArrayList<Integer> list = new ArrayList<Integer>(hm.keySet());
        Collections.sort(list, new Comparator<Integer>() {
			@Override
			public int compare(Integer o1, Integer o2) {
				return hm.get(o2)-hm.get(o1);
			}
        });
        
        for (Integer integer : list) {
			k -= hm.get(integer);
			answer++;
			if(k <= 0) break;
		}
        
        return answer;
    }
}
