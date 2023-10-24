package programmers.lv2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class Programmers_광물캐기 {
	public static void main(String[] args) {
		Programmers_광물캐기 test = new Programmers_광물캐기();
		int[] picks = {0, 1, 1};
		String[] minerals = {"diamond", "diamond", "diamond", "diamond", "diamond", "iron", "iron", "iron", "iron", "iron", "diamond"};
		int result = test.solution(picks, minerals);
		System.out.println(result);
	}
	
	public int solution(int[] picks, String[] minerals) {
        int answer = 0;
        
        int[][] fatigue = {{1,1,1},{5,1,1},{25,5,1}};
        int totalPicks = Arrays.stream(picks).sum();
        ArrayList<Mineral> list = new ArrayList<Mineral>();
        
        for(int i=0; i<minerals.length; i+=5) {
        	if(totalPicks <= 0) break;
        	
        	int diamond = 0, iron = 0, stone = 0;
        	for(int j=i; j<i+5; j++) {
        		if(j >= minerals.length) break;
        		
        		String name = minerals[j];
        		int fatigueIdx = name.equals("diamond") ? 0 : name.equals("iron") ? 1 : 2;
        		
        		diamond += fatigue[0][fatigueIdx];
        		iron += fatigue[1][fatigueIdx];
        		stone += fatigue[2][fatigueIdx];
        	}
        	list.add(new Mineral(diamond, iron, stone));
        	totalPicks--;
        }
        
        Collections.sort(list, (o1, o2) -> (o2.stone - o1.stone));
        
        for (Mineral mineral : list) {
			if(picks[0] > 0) {
				answer += mineral.diamond;
				picks[0]--;
				continue;
			}
			if(picks[1] > 0) {
				answer += mineral.iron;
				picks[1]--;
				continue;
			}
			if(picks[2] > 0) {
				answer += mineral.stone;
				picks[2]--;
			}
		}
        return answer;
    }
	
	class Mineral {
		int diamond;
		int iron;
		int stone;
		
		public Mineral(int diamond, int iron, int stone) {
			this.diamond = diamond;
			this.iron = iron;
			this.stone = stone;
		}
	}
}
