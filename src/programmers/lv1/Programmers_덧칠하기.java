package programmers.lv1;

public class Programmers_덧칠하기 {
	public static void main(String[] args) {
		int n = 8;
		int m = 4;
		int[] section = {2,3,6};
		
		int result = solution(n, m, section);
		System.out.println(result);
	}
	
	public static int solution(int n, int m, int[] section) {
        int answer = 0;
        int chill = 0;
        for(int i=0; i<section.length; i++) {
            if(section[i] > chill) {
                chill = section[i] + m - 1;
                answer++;
            }
        }
        return answer;
    }
}
