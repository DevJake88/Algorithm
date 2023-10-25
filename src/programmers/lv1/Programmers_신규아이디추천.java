package programmers.lv1;

public class Programmers_신규아이디추천 {
	public static void main(String[] args) {
		Programmers_신규아이디추천 test = new Programmers_신규아이디추천();
		String new_id = "=.=";
		String result = test.solution(new_id);
		System.out.println(result);
	}
	
	public String solution(String new_id) {
        String answer = "";
        
        // step 1
        new_id = new_id.toLowerCase();
        
        // step 2
        String step2 = "";
        for(int i=0; i<new_id.length(); i++) {
        	char c = new_id.charAt(i);
        	if((c >= '0' && c <= '9') || (c >= 'a' && c <= 'z') || c == '-' || c == '_' || c == '.') {
        		step2 += c;
        	}
        }
        
        // step3
        String step3 = step2;
        while(step3.contains("..")) {
        	step3 = step3.replace("..", ".");
        }

        // step4
        String step4 = step3;
        if(step4.length() > 0) {
        	if(step4.charAt(0) == '.') {
        		step4 = step4.substring(1, step4.length());
        	}
        }
        
        if(step4.length() > 0) {
        	if(step4.charAt(step4.length()-1) == '.') {
        		step4 = step4.substring(0, step4.length()-1);
        	}
        }
        
        // step5
        String step5 = step4;
        if (step5.length() == 0) {
        	step5 = "a";
        }
        
        // step6
        String step6 = step5;
        if (step6.length() >= 16) {
        	step6 = step6.substring(0, 15);
        }
        if(step6.charAt(step6.length()-1) == '.') {
        	step6 = step6.substring(0, step6.length()-1);
        }
        
        // step7
        String step7 = step6;
        if(step7.length() <= 2) {
        	char c =step7.charAt(step7.length()-1);
        	while(step7.length() <= 2) {
        		step7 += c;
        	}
        }

        answer = step7;
        return answer;
    }
}
