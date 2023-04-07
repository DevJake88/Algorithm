package programmers.lv1;

import java.util.Arrays;
import java.util.Iterator;

public class Programmers_공원산책 {
	public static void main(String[] args) {
		String[] park = {"XXX","XSX","XXX"};
		String[] routes = {"E 1"};
		
		int[] result = solution(park, routes);
		for (int i : result) {
			System.out.println(i);
		}
	}
	
	public static int[] solution(String[] park, String[] routes) {
        int[][] map = new int[park.length][park[0].length()];
        int[] position = new int[2];
        
        for(int i=0; i<park.length; i++) {
        	for(int j=0; j<park[i].length(); j++) {
        		if(park[i].charAt(j) == 'S') {
        			position[0] = i;
        			position[1] = j;
        			map[i][j] = 0;
        		} else if(park[i].charAt(j) == 'X') {
        			map[i][j] = 1;
        		} else {
        			map[i][j] = 0;
        		}
        	}
        }

        for(int i=0; i<routes.length; i++) {
        	String[] cmd = routes[i].split(" ");
        	char direction = cmd[0].charAt(0);
        	int distance = Integer.parseInt(cmd[1]);
        	
        	switch (direction) {
        	case 'E':
        		if(position[1]+distance < map[0].length) {
        			boolean flag = true;
        			for(int k=position[1]+1; k<=position[1]+distance; k++) {
        				if (map[position[0]][k] == 1) {
        					flag = false;
        					break;
        				} 
        			}
        			if (flag) position[1] = position[1] + distance;
        		}
        		break;
        	case 'W':
        		if(position[1]-distance >= 0) {
        			boolean flag = true;
        			for(int k=position[1]-1; k>=position[1]-distance; k--) {
        				if (map[position[0]][k] == 1) {
        					flag = false;
        					break;
        				} 
        			}
        			if (flag) position[1] = position[1] - distance;
        		}
        		break;
        	case 'S':
        		if(position[0]+distance < map.length) {
        			boolean flag = true;
        			for(int k=position[0]+1; k<=position[0]+distance; k++) {
        				if (map[k][position[1]] == 1) {
        					flag = false;
        					break;
        				} 
        			}
        			if (flag) position[0] = position[0] + distance;
        		}
        		break;
        	case 'N':
        		if(position[0]-distance >= 0) {
        			boolean flag = true;
        			for(int k=position[0]-1; k>=position[0]-distance; k--) {
        				if (map[k][position[1]] == 1) {
        					flag = false;
        					break;
        				} 
        			}
        			if (flag) position[0] = position[0] - distance;
        		}
        		break;
        	}
        }
        
        System.out.println(Arrays.toString(position));
        
        return position;
    }
	
}

//{"SOO","OOO","OOO"}	{"E 2","S 2","W 1"}	{2,1}
//{"SOO","OXX","OOO"}	{"E 2","S 2","W 1"}	{0,1}
//{"OSO","OOO","OXO","OOO"}	{"E 2","S 3","W 1"}	{0,0}

//console.log(solution(["SOO","OOO","OOO"], ["E 2","S 2","W 1"])); // [2,1]
//console.log(solution(["SOO","OXX","OOO"], ["E 2","S 2","W 1"])); // [0,1]
//console.log(solution(["OSO","OOO","OXO","OOO"], ["E 2","S 3","W 1"])); // [0,0]
//
//console.log(solution(["OSO","OOO","OOO","OOO"], ["W 2"])); // [0,1]
//console.log(solution(["OSO","OOO","OOO","OOO"], ["N 2"])); // [0,1]
//console.log(solution(["OSO","OOO","OOO","OOO"], ["S 5"])); // [0,1]
//console.log(solution(["OSO","OOO","OOO","OOO"], ["E 5"])); // [0,1]
//
//console.log(solution(["XXX","XSX","XXX"], ["E 1"])); // [1,1]
//console.log(solution(["XXX","XSX","XXX"], ["W 1"])); // [1,1]
//console.log(solution(["XXX","XSX","XXX"], ["S 1"])); // [1,1]
//console.log(solution(["XXX","XSX","XXX"], ["N 1"])); // [1,1]
//
//console.log(solution(["SOXOO","OOOOO","OOOOO", "OOOOO", "OOOOO"], ["E 3"])); // [0, 0]
//console.log(solution(["SOOOX","OOOOO","OOOOO", "OOOOO", "OOOOO"], ["E 3"])); // [0, 3]
//console.log(solution(["XOOOS","OOOOO","OOOOO", "OOOOO", "OOOOO"], ["W 3"])); // [0, 1]
//console.log(solution(["OOXOS","OOOOO","OOOOO", "OOOOO", "OOOOO"], ["W 3"])); // [0, 4]
//console.log(solution(["SOOOO","OOOOO","XOOOO", "OOOOO", "OOOOO"], ["S 3"])); // [0, 0]
//console.log(solution(["SOOOO","OOOOO","OOOOO", "OOOOO", "XOOOO"], ["S 3"])); // [3, 0]
//console.log(solution(["OOOOO","OOOOO","XOOOO", "OOOOO", "SOOOO"], ["N 3"])); // [4, 0]
//console.log(solution(["XOOOO","OOOOO","OOOOO", "OOOOO", "SOOOO"], ["N 3"])); // [1, 0]