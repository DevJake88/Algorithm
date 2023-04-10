package programmers.lv1;

import java.util.HashMap;

public class Programmers_성격유형검사하기 {
	public static void main(String[] args) {
		String[] survey = {"AN", "CF", "MJ", "RT", "NA"};
		int[] choices = {5, 3, 2, 7, 5};
		
		String result = solution(survey, choices);
		System.out.println(result);
	}
	
	public static String solution(String[] survey, int[] choices) {
        String answer = "";
        HashMap<Character, Integer> mbti = new HashMap<Character, Integer>();
        
        // 유형별 성격 점수 매기기
        for(int i=0; i<survey.length; i++) {
            char[] perArr = survey[i].toCharArray();
            getScore(perArr[0], perArr[1], choices[i], mbti);
        }
        
        // 매겨진 점수로 성격 판별하기
        char[][] charArr = {{'R','T'},{'C','F'},{'J','M'},{'A','N'}};
        for(int i=0; i<charArr.length; i++) {
            int t1 = mbti.containsKey(charArr[i][0]) ? mbti.get(charArr[i][0]) : 0;
            int t2 = mbti.containsKey(charArr[i][1]) ? mbti.get(charArr[i][1]) : 0;
            answer += compare(charArr[i][0], charArr[i][1], t1, t2);
        }
        return answer;
    }
    
	// 성격 유형별 점수
    public static void getScore(char p1, char p2, int choice, HashMap<Character,Integer> hm) {
        if (choice > 4) {
            // p2
            int score = choice-4;
            if (hm.containsKey(p2)) hm.put(p2, (hm.get(p2) + score));
            else hm.put(p2, score);
        } else if(choice < 4) {
            // p1
            int score = 4 - choice;
            if (hm.containsKey(p1)) hm.put(p1, (hm.get(p1) + score));
            else hm.put(p1, score);
        }
    }
    
    // 점수 비교로 성격 판정
    public static char compare(char p1, char p2, int t1, int t2) {
        if (t1 > t2) {
            return p1; 
        } else if (t1 < t2) {
            return p2;
        } else {
            return p1;
        }
    }
}

//["AN", "CF", "MJ", "RT", "NA"]	[5, 3, 2, 7, 5]	"TCMA"
//["TR", "RT", "TR"]	[7, 1, 3]	"RCJA"
