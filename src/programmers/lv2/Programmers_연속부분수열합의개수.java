package programmers.lv2;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Programmers_연속부분수열합의개수 {

	public static void main(String[] args) {
		Programmers_연속부분수열합의개수 test = new Programmers_연속부분수열합의개수();
		int[] elements = {7,9,1,1,4};
		int result = test.solution(elements);
		System.out.println(result);
	}

	public int solution(int[] elements) {
        Set<Integer> set = new HashSet<Integer>();
        
        int start = 1;
        while(start <= elements.length) {
        	for(int i=0; i<elements.length; i++) {
        		int sum = 0;
        		for(int j=i; j<i+start; j++) {
        			sum += elements[j % elements.length];
        		}
        		set.add(sum);
        	}
        	start++;
        }
        
        System.out.println(Arrays.toString(set.toArray()));
        int answer = set.size();
        return answer;
    }
}
