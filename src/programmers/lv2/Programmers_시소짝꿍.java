package programmers.lv2;

import java.util.Arrays;
import java.util.HashMap;

public class Programmers_시소짝꿍 {

	public static void main(String[] args) {
		Programmers_시소짝꿍 test = new Programmers_시소짝꿍();
		int[] weights = {100,180,360,100,270};
		long result = test.solution(weights);
		System.out.println(result);
	}
	
	public long solution(int[] weights) {
        long answer = 0;
        HashMap<Double, Integer> hm = new HashMap<Double, Integer>();
        Arrays.sort(weights);
        
        for (int weight : weights) {
			double weight1 = weight * 1.0;
			double weight2 = (weight * 2.0) / 3.0;
			double weight3 = (weight * 1.0) / 2.0;
			double weight4 = (weight * 3.0) / 4.0;
			
			if(hm.containsKey(weight1)) answer += hm.get(weight1);
			if(hm.containsKey(weight2)) answer += hm.get(weight2);
			if(hm.containsKey(weight3)) answer += hm.get(weight3);
			if(hm.containsKey(weight4)) answer += hm.get(weight4);
        	
			hm.put(weight*1.0, hm.getOrDefault(weight*1.0, 0)+1);
		}
        return answer;
    }

}
