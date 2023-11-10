package programmers.lv2;

import java.util.Arrays;

public class Programmers_이모티콘할인행사 {

	public static void main(String[] args) {
		Programmers_이모티콘할인행사 test = new Programmers_이모티콘할인행사();
		int[][] users = {{40, 10000}, {25, 10000}};
		int[] emoticons = {7000, 9000};
		int[] result = test.solution(users, emoticons);
		System.out.println(Arrays.toString(result));
	}
	
	int[] discount_rate = {10,20,30,40};
	int maxSubscribe = 0;
	int maxCost = 0;
	
	public int[] solution(int[][] users, int[] emoticons) {
        int[] discount = new int[emoticons.length];
        searchMax(0, discount, users, emoticons);
     
        int[] answer = new int[] {maxSubscribe, maxCost};
        return answer;
	}
	
	public void searchMax(int idx, int[] discount, int[][] users, int[] emoticons) {
		if(idx == emoticons.length) {
			int subscribe = 0;
			int totalCost = 0;
			
			for (int[] user : users) {
				int cost = 0;
				for(int i=0; i<emoticons.length; i++) {
					if(user[0] <= discount[i]) cost += emoticons[i]*(100-discount[i])/100;
				}
				
				if(cost >= user[1]) subscribe++;
				else totalCost += cost;
			}
			
			
			if(subscribe > maxSubscribe) {
				maxSubscribe = subscribe;
				maxCost = totalCost;
			}
			else if(subscribe == maxSubscribe) maxCost = Math.max(totalCost, maxCost);
			return;
		}
		
		for(int i=0; i<discount_rate.length; i++) {
			discount[idx] = discount_rate[i];
			searchMax(idx+1, discount, users, emoticons);
		}
		
	}

}
