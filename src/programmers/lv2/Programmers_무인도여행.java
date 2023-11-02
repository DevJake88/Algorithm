package programmers.lv2;

import java.util.ArrayList;
import java.util.Arrays;

public class Programmers_무인도여행 {

	public static void main(String[] args) {
		Programmers_무인도여행 test = new Programmers_무인도여행();
		String[] map = {"X591X","X1X5X","X231X", "1XXX1"};
		int[] result = test.solution(map);
		System.out.println(Arrays.toString(result));
	}
	
	char[][] map;
	boolean[][] visited;
	int[][] pos = {{-1,0},{1,0},{0,-1},{0,1}};
	int count = 0;
	
	public int[] solution(String[] maps) {
        int[] answer = {};

        map = new char[maps.length][maps[0].length()];
        visited = new boolean[maps.length][maps[0].length()];
        ArrayList<Integer> list = new ArrayList<Integer>();
        
        // map 초기화
        for(int i=0; i<maps.length; i++)
        	for(int j=0; j<maps[i].length(); j++)
        		map[i][j] = maps[i].charAt(j);
        
        // 순회하면서 섬이 있다면 dfs
        for(int i=0; i<map.length; i++) {
        	for(int j=0; j<map[i].length; j++) {
        		if(map[i][j]-'0' < 10 && !visited[i][j]) {
        			count = 0;
        			dfs(i, j);
        			list.add(count);
        		}
        	}
        }
        
        // answer 정리
        if(list.size() > 0) {
        	answer = new int[list.size()];
            int idx = 0;
            for (Integer item : list) answer[idx++] = item;
            Arrays.sort(answer);
        } else {
        	answer = new int[] {-1};
        }
        
        return answer;
    }
	
	// dfs
	public void dfs(int r, int c) {
		count += map[r][c]-'0';
		visited[r][c] = true;
		
		for(int i=0; i<pos.length; i++) {
			int nr = r + pos[i][0];
			int nc = c + pos[i][1];
			
			if(nr >= 0 && nr < map.length && nc >= 0 && nc < map[0].length && map[nr][nc]-'0' < 10 && !visited[nr][nc]) {
				dfs(nr, nc);
			}
		}
	}

}
