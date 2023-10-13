package programmers.lv1;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

public class Programmers_신고결과받기 {

	public static void main(String[] args) {
		Programmers_신고결과받기 test = new Programmers_신고결과받기();
		String[] id_list = {"muzi", "frodo", "apeach", "neo"};
		String[] report = {"muzi frodo","apeach frodo","frodo neo","muzi neo","apeach muzi"};
		int k = 2;
		
		int[] result = test.solution(id_list, report, k);
		System.out.println(Arrays.toString(result));
	}
	
	public int[] solution(String[] id_list, String[] report, int k) {
        int[] answer = new int[id_list.length];
        Map<String, HashSet<String>> map = new HashMap<>();
        Map<String, Integer> idxMap = new HashMap<>();
        
        for(int i=0; i<id_list.length; i++) {
        	String name = id_list[i];
        	map.put(name, new HashSet<>());
        	idxMap.put(name, i);
        }
        
        for(String s : report) {
        	String[] str = s.split(" ");
        	String from = str[0];
        	String to = str[1];
        	map.get(to).add(from); // 신고당한 유저에 신고한 유저set 추가
        }
        
        for(int i=0; i<id_list.length; i++) {
        	HashSet<String> send = map.get(id_list[i]);
        	if(send.size() >= k) {
        		for(String name : send) {
        			answer[idxMap.get(name)]++;
        		}
        	}
        }
        return answer;
    }
	
	
	

}
