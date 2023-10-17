package programmers.lv2;

import java.util.Arrays;
import java.util.Comparator;

public class Programmers_요격시스템 {
	public static void main(String[] args) {
		Programmers_요격시스템 test = new Programmers_요격시스템();
		int[][] targest = {{4,5},{4,8},{10,14},{11,13},{5,12},{3,7},{1,4}};
		int result = test.solution(targest);
		System.out.println(result);
	}
	
	public int solution(int[][] targets) {
        int answer = 0;
        
        Arrays.sort(targets, new Comparator<int[]>() {
        	@Override
        	public int compare(int[] o1, int[] o2) {
        		return o1[1]-o2[1];	// 끝나는 숫자로 오름차순
        	}
        });
        
        int missale = -1;
        for(int i=0; i<targets.length; i++) {
        	if(targets[i][0] >= missale) {
        		missale = targets[i][1];
        		answer++;
        	}
        }
        
        return answer;
    }
}
