package programmers.lv1;

public class Programmers_숫자짝꿍_다시 {
	public static void main(String[] args) {
		Programmers_숫자짝꿍 test = new Programmers_숫자짝꿍();
		String x = "100";
		String y = "203045";
		String result = test.solution(x, y);
		System.out.println(result);
	}
	
	public String solution(String X, String Y) {
		StringBuilder answer = new StringBuilder();
		
		int[] xArr = new int[10];
		int[] yArr = new int[10];
		
		countArrFunc(X, xArr);
		countArrFunc(Y, yArr);

		for(int i=9; i>=0; i--) {
			while(xArr[i]>0 && yArr[i]>0) {
				xArr[i]--;
				yArr[i]--;
				answer.append(i);
			}
		}
		
		if (answer.toString().equals("")) return "-1";
		else if(answer.toString().startsWith("0")) return "0";
		else return answer.toString();
	}
	
	private void countArrFunc(String str, int[] arr) {
		for(int i=0; i<str.length(); i++) {
			int index = str.charAt(i) - '0';
			arr[index]++;
		}
	}
	
}
