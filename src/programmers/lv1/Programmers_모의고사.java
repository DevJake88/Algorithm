package programmers.lv1;

import java.util.ArrayList;
import java.util.Arrays;

public class Programmers_모의고사 {

	public static void main(String[] args) {
		Programmers_모의고사 test = new Programmers_모의고사();
		int[] answer = {1,3,2,4,2};
		int[] result = test.solution(answer);
		System.out.println(Arrays.toString(result));
	}
	
	public int[] solution(int[] answers) {
        int[] answer = {};
        
        int[] student1 = {1,2,3,4,5};
        int[] student2 = {2,1,2,3,2,4,2,5};
        int[] student3 = {3,3,1,1,2,2,4,4,5,5};
        
        int sum1 = 0, sum2 = 0, sum3 = 0, max = 0;
        
        for(int i=0; i<answers.length; i++) {
        	if(answers[i] == student1[i%student1.length]) sum1++;
        	if(answers[i] == student2[i%student2.length]) sum2++;
        	if(answers[i] == student3[i%student3.length]) sum3++;
        }
        
        max = Math.max(sum1, Math.max(sum2, sum3));
        ArrayList<Integer> list = new ArrayList<Integer>();
        if(max == sum1) list.add(1);
        if(max == sum2) list.add(2);
        if(max == sum3) list.add(3);
        
        answer = new int[list.size()];
        int idx = 0;
        for (Integer integer : list) answer[idx++] = integer;
        
        return answer;
    }

}
