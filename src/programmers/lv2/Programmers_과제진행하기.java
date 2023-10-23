package programmers.lv2;

import java.net.SecureCacheResponse;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Stack;

public class Programmers_과제진행하기 {
	public static void main(String[] args) {
		Programmers_과제진행하기 test = new Programmers_과제진행하기();
		String[][] plans = {{"korean", "11:40", "30"}, {"english", "12:10", "20"}, {"math", "12:30", "40"}};
		// {{"science", "12:40", "50"}, {"music", "12:20", "40"}, {"history", "14:00", "30"}, {"computer", "12:30", "100"}};
		
		String[] result = test.solution(plans);
		System.out.println(Arrays.toString(result));
	}
	
	public String[] solution(String[][] plans) {
        String[] answer = {};
        PriorityQueue<Task> pq = new PriorityQueue<Task>();
        Stack<Task> stack = new Stack<Task>();
        ArrayList<String> endList = new ArrayList<String>();
        
        for(int i=0; i<plans.length; i++) {
        	String[] startTimeArr = plans[i][1].split(":");
        	int start = Integer.parseInt(startTimeArr[0]) * 60 + Integer.parseInt(startTimeArr[1]);
        	pq.add(new Task(plans[i][0], start, Integer.parseInt(plans[i][2])));
        }
        
        while(!pq.isEmpty()) {
        	Task currentTask = pq.poll();
        	
        	if(!pq.isEmpty()) {
        		Task nextTask = pq.peek();
        		if(currentTask.start + currentTask.playTime > nextTask.start) {
        			// 새로운 과제해야 할 시간이라면
        			// 중단시키고 스택에 넣는다
        			int remainTime = currentTask.start + currentTask.playTime - nextTask.start;
        			stack.push(new Task(currentTask.name, remainTime));
        		} else if(currentTask.start + currentTask.playTime == nextTask.start) {
        			// 끝낸 리스트에 저장
        			endList.add(currentTask.name);
        		} else {
        			// 새로운 과제 시작 전에 아직 시간이 남았다면
        			endList.add(currentTask.name);
        			int currentTime = currentTask.start + currentTask.playTime;
        			// 스택에서 남은 일 가져와서 끝낸다.
        			while(!stack.isEmpty()) {
        				Task remainTask = stack.pop();
        				if(currentTime + remainTask.playTime > nextTask.start) {
        					// 중단시키고 스택에 넣는다
        					stack.push(new Task(remainTask.name, currentTime + remainTask.playTime - nextTask.start));
        					break;
        				} else {
        					endList.add(remainTask.name);
        					currentTime += remainTask.playTime;
        				}
        			}
        		}
        	} else {
        		if(stack.isEmpty()) {
        			endList.add(currentTask.name);
        		} else {
        			endList.add(currentTask.name);
        			while(!stack.isEmpty()) {
        				Task remainTask = stack.pop();
        				endList.add(remainTask.name);
        			}
        		}
        	}
        }
        
        answer = new String[endList.size()];
        for(int i=0; i<endList.size(); i++) {
        	answer[i] = endList.get(i);
        }
        		
        return answer;
    }
	
	class Task implements Comparable<Task> {
		String name;
		int start;
		int playTime;
		
		Task(String name, int start, int playTime) {
			this.name = name;
			this.start = start;
			this.playTime = playTime;
		}
		
		Task(String name, int playTime) {
			this.name = name;
			this.playTime = playTime;
		}
		
		@Override
		public int compareTo(Task o) {
			return this.start - o.start;
		}
		
	}
}
