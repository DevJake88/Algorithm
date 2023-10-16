package programmers.lv1;

public class Programmers_없는숫자더하기 {
	public static void main(String[] args) {
		Programmers_없는숫자더하기 test = new Programmers_없는숫자더하기();
		int[] numbers = {1,2,3,4,6,7,8,0};
		int result = test.solution(numbers);
		System.out.println(result);
	}
	
	public int solution(int[] numbers) {
		int answer = 0;
        for (int i = 0; i < 10; i++) answer += i;
        for (int i : numbers) answer -= i;
        return answer;
    }
}
