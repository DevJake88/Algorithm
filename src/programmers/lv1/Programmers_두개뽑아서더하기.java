package programmers.lv1;

import java.util.Arrays;
import java.util.Set;
import java.util.TreeSet;

public class Programmers_두개뽑아서더하기 {
	public static void main(String[] args) {
		Programmers_두개뽑아서더하기 test = new Programmers_두개뽑아서더하기();
		int[] numbers = {2,1,3,4,1};
		int[] result = test.solution(numbers);
		System.out.println(Arrays.toString(result));
	}
	
	public int[] solution(int[] numbers) {
        int[] answer = {};
        
        Set<Integer> set = new TreeSet<Integer>();
        for(int i=0; i<numbers.length-1; i++) {
        	for(int j=i+1; j<numbers.length; j++) {
        		set.add(numbers[i] + numbers[j]);
        	}
        }
        
        answer = Arrays.stream(set.toArray(new Integer[0])).mapToInt(Integer::intValue).toArray();
        return answer;
    }
}
