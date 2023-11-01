package programmers.lv2;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class Programmers_호텔대실_우선순위큐 {

	public static void main(String[] args) {
		Programmers_호텔대실_우선순위큐 test = new Programmers_호텔대실_우선순위큐();
		String[][] book_time = {{"15:00", "17:00"}, {"16:40", "18:20"}, {"14:20", "15:20"}, {"14:10", "19:20"}, {"18:20", "21:20"}};
		int result = test.solution(book_time);
		System.out.println(result);
	}

	public int solution(String[][] book_time) {
        int answer = 0;
        
        Arrays.sort(book_time, new Comparator<String[]>() {
			@Override
			public int compare(String[] o1, String[] o2) {
				int time1 = Integer.parseInt(o1[0].split(":")[0])*60 + Integer.parseInt(o1[0].split(":")[1]);
				int time2 = Integer.parseInt(o2[0].split(":")[0])*60 + Integer.parseInt(o2[0].split(":")[1]);
				return time1-time2;
			}
        });
        
        PriorityQueue<int[]> pq = new PriorityQueue<>(new Comparator<int[]>() {
			@Override
			public int compare(int[] o1, int[] o2) {
				return o1[1]-o2[1];
			}
        });
        
        answer++;
        for (String[] time : book_time) {
			int startTime = Integer.parseInt(time[0].split(":")[0])*60 + Integer.parseInt(time[0].split(":")[1]);
			int endTime = Integer.parseInt(time[1].split(":")[0])*60 + Integer.parseInt(time[1].split(":")[1]) + 10;
			
			if(pq.isEmpty()) {
				pq.add(new int[] {startTime, endTime});
				continue;
			}
			
			int[] prevTime = pq.poll();
        	if(prevTime[1] > startTime) {
        		pq.add(prevTime);
        		pq.add(new int[] {startTime, endTime});
        		answer++;
        	} else {
        		pq.add(new int[] {startTime, endTime});
        	}
		}
        
        return answer;
    }
}
