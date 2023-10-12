package programmers.lv1;

public class Programmers_숫자짝꿍 {

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

		for(int i=0; i<X.length(); i++) {
			int index = X.charAt(i) - '0';
			xArr[index]++;
		}
		
		for(int i=0; i<Y.length(); i++) {
			int index = Y.charAt(i) - '0';
			yArr[index]++;
		}
		
		for(int i=9; i>=0; i--) {
			int xNum = xArr[i];
			int yNum = yArr[i];
			StringBuilder addStr = new StringBuilder();
			
			if(xNum > 0 && yNum > 0) {
				if(xNum >= yNum) {
					for(int j=0; j<yNum; j++) {
						addStr.append(i);
					}
				} else if(xNum < yNum) {
					for(int j=0; j<xNum; j++) {
						addStr.append(i);
					}
				}
			}
			answer.append(addStr);
		}
		
		if (answer.toString().equals("")) return "-1";
		else if(answer.charAt(0) == '0') return "0";
		
		return answer.toString();
	}
}
