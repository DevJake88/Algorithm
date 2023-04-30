package programmers.lv1;

public class Programmers_평균구하기 {
	
	public double solution(int[] arr) {
        double answer = 0;
        for(int i=0; i<arr.length; i++) {
            answer += arr[i];
        }
        answer /= arr.length;
        return answer;
    }

	public static void main(String[] args) {
		Programmers_평균구하기 test = new Programmers_평균구하기();
		int[] arr = {1,2,3,4};
		double result = test.solution(arr);
		System.out.println(result);
	}

}
