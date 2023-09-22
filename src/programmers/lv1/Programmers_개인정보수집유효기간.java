package programmers.lv1;

import java.util.*;

public class Programmers_개인정보수집유효기간 {

	public static void main(String[] args) {
		String today = "2022.05.19";
		String[] terms = {"A 6", "B 12", "C 3"};
		String[] privacies = {"2021.05.02 A", "2021.07.01 B", "2022.02.19 C", "2022.02.20 C"};
		
		Programmers_개인정보수집유효기간 test = new Programmers_개인정보수집유효기간();
		int[] result = test.solution(today, terms, privacies);
		System.out.println(Arrays.toString(result));
	}
	
	public int[] solution(String today, String[] terms, String[] privacies) {
        int[] answer;
        ArrayList<Integer> resultList = new ArrayList<Integer>();
        
        String[] todayArr = today.split("\\.");
        HashMap<String, Integer> hm = new HashMap<String, Integer>();
        
        // 약관기간 정보 저장
        for(int i=0; i<terms.length; i++) {
        	String[] termsArr = terms[i].split(" ");
        	hm.put(termsArr[0], Integer.parseInt(termsArr[1]));
        }
        
        // 약관기간만큼 늘려준다.
        for(int i=0; i<privacies.length; i++) {
        	String[] privacyArr = privacies[i].split(" ");	// ["2021.05.02", "A"]
        	String[] dateArr = privacyArr[0].split("\\.");	// ["2021", "05", "02"]
        	
        	int month = Integer.parseInt(dateArr[1]) + hm.get(privacyArr[1]);
        	// month가 12를 넘어가는 경우 체크
        	if(month > 12) {
        		int num = month/12;
        		int remain = month%12;
        		dateArr[0] = Integer.toString(Integer.parseInt(dateArr[0]) + num); // year 갱신
        		dateArr[1] = remain == 0 ? "12" : Integer.toString(remain);	// month 갱신
        	} else {
        		dateArr[1] = Integer.toString(month);	// month 갱신
        	}
        	
        	if(Integer.parseInt(dateArr[2]) == 1) {
        		dateArr[1] = Integer.toString(Integer.parseInt(dateArr[1]) - 1);
        		dateArr[2] = "28";
        	} else {
        		dateArr[2] = Integer.toString(Integer.parseInt(dateArr[2]) - 1);
        	}
        	
        	// 오늘날짜랑 바뀐약관날짜 비교
        	for(int j=0; j<todayArr.length; j++) {
        		if(Integer.parseInt(todayArr[j]) > Integer.parseInt(dateArr[j])) {
        			resultList.add(i+1);
        			break;
        		}
        	}
        }
        
        answer = new int[resultList.size()];
        for(int i=0; i<answer.length; i++) {
        	answer[i] = resultList.get(i);
        }
        
        return answer;
    }

}
