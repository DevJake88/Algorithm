package programmers.lv1;

public class Programmers_음양더하기 {
	public static void main(String[] args) {
		Programmers_음양더하기 test = new Programmers_음양더하기();
		int[] absolutes = {4,7,12};
		boolean[] signs = {true,false,true};
		int result = test.solution(absolutes, signs);
		System.out.println(result);
	}
	
	public int solution(int[] absolutes, boolean[] signs) {
        int answer = 0;
        
        for(int i=0; i<absolutes.length; i++) {
        	if (signs[i]) answer += absolutes[i];
        	else answer -= absolutes[i];
        }
        return answer;
    }
}
