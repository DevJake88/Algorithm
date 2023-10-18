package programmers.lv1;

public class Programmers_부족한금액계산하기 {

	public static void main(String[] args) {
		Programmers_부족한금액계산하기 test = new Programmers_부족한금액계산하기();
		int price = 3;
		int money = 20;
		int count = 4;
		long result = test.solution(price, money, count);
		System.out.println(result);
	}
																																																														
	public long solution(int price, int money, int count) {
        long answer = -1;
        
        long num = 0;
        for(int i=0; i<count; i++) {
        	num += (price * (i+1));
        }
        answer = num - money; 
        if(answer < 0) answer = 0;
        return answer;
    }
}
