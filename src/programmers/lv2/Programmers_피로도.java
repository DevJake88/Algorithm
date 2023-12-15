package programmers.lv2;

import java.util.Arrays;

public class Programmers_피로도 {

	public static void main(String[] args) {
		Programmers_피로도 test = new Programmers_피로도();
		int k = 80;
		int[][] dungeons = {{80,20},{50,40},{30,10}};
		int result = test.solution(k, dungeons);
		System.out.println(result);
	}
	
	int answer = 0;
	public int solution(int k, int[][] dungeons) {
        int[] arr = new int[dungeons.length];
        boolean[] visited = new boolean[dungeons.length];
        
        perm(arr, visited, 0, arr.length, arr.length, dungeons, k);
        
        return answer;
    }
	
	public void perm(int[] arr, boolean[] visited, int depth, int n, int r, int[][] dungeons, int k) {
		if(depth == r) {
			System.out.println(Arrays.toString(arr));
			int fatigue = k;
			int count = 0;
			for (Integer order : arr) {
				if(fatigue >= dungeons[order][0]) {
					// 탐험 가능
					count++;
					fatigue -= dungeons[order][1];
				} else {
					break;
				}
			}
			answer = Math.max(answer, count);
			return;
		}
		
		for(int i=0; i<n; i++) {
			if(!visited[i]) {
				arr[depth] = i;
				visited[i] = true;
				perm(arr, visited, depth+1, n, r, dungeons, k);
				visited[i] = false;
			}
		}
	}

}
