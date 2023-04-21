package programmers.lv1;

public class Programmers_삼총사 {

	public static void main(String[] args) {
		int[] number = {-2, 3, 0, 2, -5};
		int result = solution(number);
		System.out.println(result);
	}
	
	public static int solution(int[] number) {
        int answer = 0;
        
        for(int i=0; i<number.length; i++) {
            for(int j=i+1; j<number.length; j++) {
                for(int k=j+1; k<number.length; k++) {
                    if (number[i] + number[j] + number[k] == 0) {
                        answer++;
                    }
                }
            }
        }
        
        return answer;
    }

}
