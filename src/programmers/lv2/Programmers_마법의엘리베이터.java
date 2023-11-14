package programmers.lv2;

public class Programmers_마법의엘리베이터 {

	public static void main(String[] args) {
		Programmers_마법의엘리베이터 test = new Programmers_마법의엘리베이터();
		int storey = 555;
		int result = test.solution(storey);
		System.out.println(result);
	}
	
	public int solution(int storey) {
        int answer = 0;
        
        String str = Integer.toString(storey);
        int[] arr = new int[str.length()];
        for(int i=0; i<arr.length; i++) arr[i] = str.charAt(i)-'0';

        for(int i=arr.length-1; i>=0; i--) {
        	int num = arr[i];
        	if(num > 5) {
        		answer += 10-num;
        		if(i == 0) answer++;
        		else arr[i-1]++;
        	} else if(num == 5 && i > 0 && arr[i-1] >= 5) {
        		answer += 10-num;
        		arr[i-1]++;
        	} else {
        		answer += num;
        	}
        }
        
        return answer;
    }

}
