package thisiscodingtest.ch04;

import java.util.Scanner;

public class 상하좌우 {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int N = Integer.parseInt(scan.nextLine());
		int[][] map = new int[N][N];
		String[] dirInputArr = scan.nextLine().split(" ");

		int[] dx = { 0, 0, -1, 1 };
		int[] dy = { -1, 1, 0, 0 };
		char[] move_type = { 'L', 'R', 'U', 'D' };

		int x = 1, y = 1;

		for (int i = 0; i < dirInputArr.length; i++) {
			for (int j = 0; j < move_type.length; j++) {
				if (dirInputArr[i].charAt(0) == move_type[j]) {
					int nx = x + dx[j];
					int ny = y + dy[j];

					if (nx < 1 || ny < 1 || nx > N || ny > N)
						continue;
					else {
						x = nx;
						y = ny;
						break;
					}
				}
			}
		}
		System.out.println(x + " " + y);
	}

}

//5
//R R R U D D