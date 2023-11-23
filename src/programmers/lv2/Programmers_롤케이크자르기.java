package programmers.lv2;

import java.util.HashMap;

public class Programmers_롤케이크자르기 {

	public static void main(String[] args) {
		Programmers_롤케이크자르기 test = new Programmers_롤케이크자르기();
		int[] topping = {1, 2, 1, 3, 1, 4, 1, 2};
		int result = test.solution(topping);
		System.out.println(result);
	}
	
	public int solution(int[] topping) {
        int answer = 0;
        
        HashMap<Integer, Integer> hm1 = new HashMap<Integer, Integer>();
        HashMap<Integer, Integer> hm2 = new HashMap<Integer, Integer>();
        
        for (int i : topping) hm1.put(i, hm1.getOrDefault(i, 0)+1);
        
        for (int i : topping) {
        	hm2.put(i, hm2.getOrDefault(i, 0)+1);
        	
        	if(hm1.get(i)-1 == 0) hm1.remove(i);
        	else hm1.put(i, (hm1.get(i)-1));
        	
        	if(hm1.size() == hm2.size()) answer++;
        }
        
        return answer;
    }

}
