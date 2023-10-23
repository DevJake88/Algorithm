package programmers.lv1;

import java.util.Arrays;

public class Programmers_로또의최고순위와최저순위 {
	public static void main(String[] args) {
		Programmers_로또의최고순위와최저순위 test = new Programmers_로또의최고순위와최저순위();
		int[] lottos = {44, 1, 0, 0, 31, 25};
		int[] win_nums = {31, 10, 45, 1, 6, 19};
		int[] result = test.solution(lottos, win_nums);
		System.out.println(Arrays.toString(result));
	}
	
	public int[] solution(int[] lottos, int[] win_nums) {
		int[] prize = {6,6,5,4,3,2,1};
        int randomLotto = 0;
        int matchLotto = 0;
        
        for(int i=0; i<lottos.length; i++) {
        	int num = lottos[i];
        	if(num == 0) randomLotto++;
        	else {
        		for(int j=0; j<win_nums.length; j++) {
        			if(num == win_nums[j]) matchLotto++;
        		}
        	}
        }

        int[] answer = new int[] {prize[matchLotto+randomLotto], prize[matchLotto]};
        return answer;
    }
}
