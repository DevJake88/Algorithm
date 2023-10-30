package programmers.lv2;

import java.util.LinkedList;
import java.util.Queue;

public class Programmers_미로탈출 {
	public static void main(String[] args) {
		Programmers_미로탈출 test = new Programmers_미로탈출();
		String[] maps = {"SOOOL","XXXXO","OOOOO","OXXXX","OOOOE"};
		int result = test.solution(maps);
		System.out.println(result);
	}
	
	int[][] dir = {{-1,0},{1,0},{0,-1},{0,1}};
	char[][] map;
	boolean[][] visited;
	
	public int solution(String[] maps) {
        int answer = 0;
        
        map = new char[maps.length][maps[0].length()];
        visited = new boolean[maps.length][maps[0].length()];
        int[] start = new int[2];
        int[] lever = new int[2];
        int[] end = new int[2];
        
        for(int i=0; i<map.length; i++) {
        	for(int j=0; j<map[i].length; j++) {
        		map[i][j] = maps[i].charAt(j);
        		if(map[i][j] == 'S') {
        			start[0] = i;
        			start[1] = j;
        		} else if(map[i][j] == 'L') {
        			lever[0] = i;
        			lever[1] = j;
        		} else if(map[i][j] == 'E') {
        			end[0] = i;
        			end[1] = j;
        		}
        	}
        }
        
        int findLever = bfs(start, lever);
        visited = new boolean[maps.length][maps[0].length()];
        int findEnd = bfs(lever, end);
        
        if(findLever == -1 || findEnd == -1) answer = -1;
        else answer = findLever + findEnd;
        
        return answer;
    }
	
	public int bfs(int[] start, int[] end) {
		Queue<int[]> queue = new LinkedList<int[]>();
		queue.add(new int[] {start[0], start[1], 0});
		visited[start[0]][start[1]] = true;
		
		while(!queue.isEmpty()) {
			
			int[] pos = queue.poll();
			if(pos[0] == end[0] && pos[1] == end[1]) return pos[2];
			
			for(int i=0; i<dir.length; i++) {
				int nr = pos[0] + dir[i][0];
				int nc = pos[1] + dir[i][1];
				
				if(nr>=0 && nr<map.length && nc>=0 && nc<map[0].length && !visited[nr][nc] && map[nr][nc] != 'X') {
					queue.add(new int[] {nr, nc, pos[2]+1});
					visited[nr][nc] = true;
				}
			}
		}
		return -1;
	}
}
