package programmers.lv1;

import java.util.Arrays;

public class Programmers_바탕화면정리 {
	
	public static void main(String[] args) {
		String[] wallpaper = {".#...", "..#..", "...#."};
		int[] result = solution(wallpaper);
		System.out.println(Arrays.toString(result));
	}
	
	public static int[] solution(String[] wallpaper) {
		char[][] map = new char[wallpaper.length][wallpaper[0].length()];
		for (int i = 0; i < map.length; i++) map[i] = wallpaper[i].toCharArray();
		
		int minX = Integer.MAX_VALUE, minY = Integer.MAX_VALUE;
		int maxX = Integer.MIN_VALUE, maxY = Integer.MIN_VALUE;
		
		for (int i = 0; i < map.length; i++) {
			for (int j = 0; j < map[i].length; j++) {
				if (map[i][j] == '#') {
					minX = Math.min(minX, i);
					minY = Math.min(minY, j);
					maxX = Math.max(maxX, i);
					maxY = Math.max(maxY, j);
				}
			}
		}
		
		
        int[] answer = {minX, minY, maxX+1, maxY+1};
        return answer;
    }
	
}

// {".#...", "..#..", "...#."}	{0, 1, 3, 4}
// {"..........", ".....#....", "......##..", "...##.....", "....#....."}	{1, 3, 5, 8}
// {".##...##.", "#..#.#..#", "#...#...#", ".#.....#.", "..#...#..", "...#.#...", "....#...."}	{0, 0, 7, 9}
// {"..", "#."}	{1, 0, 2, 1}