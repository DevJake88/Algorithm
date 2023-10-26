package programmers.lv1;

public class Programmers_내적 {
	public static void main(String[] args) {
		Programmers_내적 test = new Programmers_내적();
		int[] a = {1,2,3,4};
		int[] b = {-3,-1,0,2};
		int result = test.solution(a, b);
		System.out.println(result);
	}
	
	public int solution(int[] a, int[] b) {
		int answer = 0;
		for(int i=0; i<a.length; i++) answer += (a[i]*b[i]);
        return answer;
    }
}
