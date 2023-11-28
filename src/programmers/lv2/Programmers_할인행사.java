package programmers.lv2;

import java.util.HashMap;

public class Programmers_할인행사 {

	public static void main(String[] args) {
		Programmers_할인행사 test = new Programmers_할인행사();
		String[] want = {"banana", "apple", "rice", "pork", "pot"};
		int[] number = {3, 2, 2, 2, 1};
		String[] discount = {"chicken", "apple", "apple", "banana", "rice", "apple", "pork", "banana", "pork", "rice", "pot", "banana", "apple", "banana"};
		int result = test.solution(want, number, discount);
		System.out.println(result);
	}
	
	public int solution(String[] want, int[] number, String[] discount) {
        int answer = 0;
        
        HashMap<String, Integer> hm = new HashMap<String, Integer>();
        for(int i=0; i<want.length; i++) hm.put(want[i], number[i]);
        
        for(int i=0; i<=discount.length-10; i++) {
        	HashMap<String, Integer> want_hm = (HashMap<String, Integer>) hm.clone();
        	int count = 0;
        	for(int j=i; j<i+10; j++) {
        		if(want_hm.containsKey(discount[j])) {	// 원하는 상품이 할인하지 않는 경우
        			if(want_hm.get(discount[j]) > 0) {	// 할인 상품이 원하는 개수를 넘어간 경우
        				want_hm.put(discount[j], want_hm.get(discount[j])-1);
        				count++;
        			} else break;
        		} else break;
        	}
        	if(count == 10) answer++;
        }
        return answer;
    }

}
