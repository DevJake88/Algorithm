package programmers.lv2;

public class Programmers_호텔대실 {
	public static void main(String[] args) {
		Programmers_호텔대실 test = new Programmers_호텔대실();
		String[][] book_time = {{"15:00", "17:00"}, {"16:40", "18:20"}, {"14:20", "15:20"}, {"14:10", "19:20"}, {"18:20", "21:20"}};
		int result = test.solution(book_time);
		System.out.println(result);
	}
	
	public int solution(String[][] book_time) {
        int answer = 0;
        
        int[] timeArr = new int[24*60+10];
        
        for(int i=0; i<book_time.length; i++) {
        	String start = book_time[i][0];
        	String end = book_time[i][1];
        	
        	String[] startTimeArr = start.split(":");
        	String[] endTimeArr = end.split(":");
        	
        	int startTime = Integer.parseInt(startTimeArr[0])*60 + Integer.parseInt(startTimeArr[1]);
        	int endTime = Integer.parseInt(endTimeArr[0])*60 + Integer.parseInt(endTimeArr[1]) + 10;
        	
        	timeArr[startTime] += 1;
        	timeArr[endTime] -= 1;
        }
        
        for(int i=1; i<timeArr.length; i++) {
        	timeArr[i] += timeArr[i-1];
        	answer = Math.max(answer, timeArr[i]);
        }
        
        return answer;
    }

}