package programmers.lv1;

public class Programmers_푸드파이트대회 {
	public static void main(String[] args) { 
		int[] food = {1, 3, 4, 6};
		String result = solution(food);
		System.out.println(result);
	}
	
	public static String solution(int[] food) {
        String answer = "";

        String halfFood = "";
        for(int i=0; i<food.length; i++) {
            if (i == 0) continue;
            for(int j=(food[i] / 2); j>0; j--) {
                halfFood += i;
            }
        }
        StringBuilder sb = new StringBuilder(halfFood);
        answer = (halfFood + 0 + sb.reverse().toString());
        return answer;
    }
}
