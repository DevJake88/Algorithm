package programmers.lv1;

import java.util.Arrays;

public class Programmers_대충만든자판 {
	public int[] solution(String[] keymap, String[] targets) {
        int[] answer = new int[targets.length];
        
        for(int i=0; i<targets.length; i++) {
            int sum = 0;
            boolean flag = true;	// 문자열을 작성할 수 있는지 없는지
                
            String target = targets[i];
            char[] charArr = target.toCharArray();
            
            // target 문자 하나씩 뽑아서
            // 1. 문자가 자판에 있는 문자인지 검사
            // 2. 자판에 있으면 index 찾고, 그 중 가장 작은 index를 저장
            // 3. 자판에 없으면 -1
            for(int j=0; j<charArr.length; j++) {
                int idx = Integer.MAX_VALUE;
                    
                for(int k=0; k<keymap.length; k++) {
                    if (keymap[k].contains(String.valueOf(charArr[j]))) {
                        idx = Math.min(idx, keymap[k].indexOf(charArr[j]));
                    }
                }
                if (idx == Integer.MAX_VALUE) {
                	flag = false;
                	break;
                } else {
                	sum += (idx+1);
                }
            }
            answer[i] = flag ? sum : -1;
        }
        return answer;
    }
	
	
	public static void main(String[] args) {
		Programmers_대충만든자판 test = new Programmers_대충만든자판();
		String[] keymap = {"AB"};
		String[] targets = {"CCC"};
		int[] result = test.solution(keymap, targets);
		
		System.out.println(Arrays.toString(result));
	}
}
