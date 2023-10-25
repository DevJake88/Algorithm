package programmers.lv2;

import java.util.LinkedList;
import java.util.Queue;

public class Programmers_리코쳇로봇 {
	
	public static void main(String[] args) {
		Programmers_리코쳇로봇 test = new Programmers_리코쳇로봇();
		String[] board = {"...D..R", ".D.G...", "....D.D", "D....D.", "..D...."};
		int result = test.solution(board);
		System.out.println(result);
	}
	

	char[][] map;
	boolean[][] visited;
	int[][] pos = {{-1,0},{1,0},{0,-1},{0,1}};
	
	public int solution(String[] board) {
        int answer = 0;
        
        map = new char[board.length][board[0].length()];
        visited = new boolean[board.length][board[0].length()];
        Robot start = null, end = null;

        for(int i=0; i<board.length; i++) {
        	for(int j=0; j<board[i].length(); j++) {
        		char c = board[i].charAt(j);
        		map[i][j] = c;
        		
        		if(c == 'R') {
        			// 처음위치
        			start = new Robot(i,j,0);
        		} else if(c == 'G') {
        			// 목표위치
        			end = new Robot(i,j,0);
        		}
        	}
        }
        
        answer = bfs(start, end);
        return answer;
    }
	
	public int bfs(Robot start, Robot end) {
		Queue<Robot> queue = new LinkedList<Robot>();
		visited[start.x][start.y] = true;
		queue.add(start);
		
		while(!queue.isEmpty()) {
			Robot now = queue.poll();
			int x = now.x;
			int y = now.y;
			int depth = now.depth;
			if(x == end.x && y == end.y) {
				return depth;
			}
			
			for(int i=0; i<pos.length; i++) {
				int nx = x;
				int ny = y;
				int dx = pos[i][0];
				int dy = pos[i][1];
				while(nx+dx >= 0 && nx+dx < map.length && ny+dy >= 0 && ny+dy < map[0].length && map[nx+dx][ny+dy] != 'D') {
					nx += dx;
					ny += dy;
				}
				
				if(!visited[nx][ny]) {
					visited[nx][ny] = true;
					queue.add(new Robot(nx, ny, depth+1));
				}
			}
		}
		return -1;
	}

}

class Robot {
	int x;
	int y;
	int depth;
	
	public Robot(int x, int y, int depth) {
		this.x = x;
		this.y = y;
		this.depth = depth;
	}
}
