package programmers.lv1;

public class Programmers_숫자문자열과영단어 {
	public static void main(String[] args) {
		Programmers_숫자문자열과영단어 test = new Programmers_숫자문자열과영단어();
		String s = "one4seveneight";
		int result = test.solution(s);
		System.out.println(result);
	}
	
	public int solution(String s) {
        int answer = 0;
        
        String[] arr = {"zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine"};
        
        for(int i=0; i<arr.length; i++) {
        	s = s.replace(arr[i], Integer.toString(i));
        }

        answer = Integer.parseInt(s);
        return answer;
    }
}
