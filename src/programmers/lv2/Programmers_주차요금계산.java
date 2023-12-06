package programmers.lv2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;

public class Programmers_주차요금계산 {

	public static void main(String[] args) {
		int[] fees = { 180, 5000, 10, 600 }; // 기본시간 기본요금 단위시간 단위요금
		String[] records = { "05:34 5961 IN", "06:00 0000 IN", "06:34 0000 OUT", "07:59 5961 OUT", "07:59 0148 IN",
				"18:59 0000 IN", "19:09 0148 OUT", "22:59 5961 IN", "23:00 5961 OUT" };
		Programmers_주차요금계산 test = new Programmers_주차요금계산();
		int[] result = test.solution(fees, records);
		System.out.println(Arrays.toString(result));
	}

	public int[] solution(int[] fees, String[] records) {
		HashMap<Integer, Park> hm = new HashMap<Integer, Park>(); // 차번호, 입차시간

		for (int i = 0; i < records.length; i++) {
			String[] record = records[i].split(" ");
			String[] timeArr = record[0].split(":");
			int inoutTime = Integer.parseInt(timeArr[0]) * 60 + Integer.parseInt(timeArr[1]);
			int carNum = Integer.parseInt(record[1]);
			String parkType = record[2];

			if (parkType.equals("IN")) {
				if (hm.containsKey(carNum)) {
					Park park = hm.get(carNum);
					park.parkType = parkType;
					park.inputTime = inoutTime;
				} else {
					hm.put(carNum, new Park(carNum, inoutTime, parkType));
				}
			} else {
				// 출차할 경우
				// 시간 계산해서 다시 넣어준다.
				Park park = hm.get(carNum);
				park.parkType = parkType;
				park.parkTime += inoutTime - park.inputTime;
			}
		}

		ArrayList<Park> list = new ArrayList<Park>();
		for (Integer carNum : hm.keySet()) {
			int endTime = 23 * 60 + 59;
			Park park = hm.get(carNum);

			if (park.parkType.equals("IN")) park.parkTime += endTime - park.inputTime;
			
			if(park.parkTime > fees[0]) park.fee = fees[1] + (int) Math.ceil((park.parkTime - fees[0])/(double)fees[2]) * fees[3];
			else park.fee = fees[1];
		
			list.add(park);
		}
		
		Collections.sort(list);
		int[] answer = new int[list.size()];
		for (int i = 0; i < answer.length; i++) answer[i] = list.get(i).fee;
		
		return answer;
	}


	class Park implements Comparable<Park> {
		int carNum;
		int inputTime;
		int parkTime;
		String parkType;
		int fee;
		
		public Park(int carNum, int inputTime, String parkType) {
			this.carNum = carNum;
			this.inputTime = inputTime;
			this.parkType = parkType;
		}

		@Override
		public int compareTo(Park o) {
			return this.carNum - o.carNum;
		}
	}

}
