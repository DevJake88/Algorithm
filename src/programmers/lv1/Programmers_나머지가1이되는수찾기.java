package programmers.lv1;

public class Programmers_나머지가1이되는수찾기 {
	
	public int solution(int n) {
        int answer = 0;
        for(int i=2; i<1000000; i++) {
            if (n%i == 1) {
                answer = i;
                break;
            }
        }
        return answer;
    }

	public static void main(String[] args) {
		Programmers_나머지가1이되는수찾기 test = new Programmers_나머지가1이되는수찾기();
		int result = test.solution(10);
		System.out.println(result);
	}
	
}
