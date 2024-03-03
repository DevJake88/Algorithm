package programmers.lv1;

import java.util.Arrays;

public class Programmers_K번째수 {

	public static void main(String[] args) {
		Programmers_K번째수 test = new Programmers_K번째수();
		int[] array = {1, 5, 2, 6, 3, 7, 4};
		int[][] commands = {{2, 5, 3},{4, 4, 1},{1, 7, 3}};
		int[] result = test.solution(array, commands);
		System.out.println(Arrays.toString(result));
	}
	
	public int[] solution(int[] array, int[][] commands) {
        int[] answer = new int[commands.length];
        
        for(int i=0; i<commands.length; i++) {
        	int[] command = commands[i];
        	int[] new_arr = new int[command[1]-command[0]+1];
        	int idx = 0;
        	for(int j=command[0]-1; j<command[1]; j++) {
        		new_arr[idx++] = array[j];
        	}
        	Arrays.sort(new_arr);
        	// System.out.println(Arrays.toString(new_arr));
        	
        	answer[i] = new_arr[command[2]-1];
        }
        
        return answer;
    }

}
