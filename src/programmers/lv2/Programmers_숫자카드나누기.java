package programmers.lv2;

public class Programmers_숫자카드나누기 {

	public static void main(String[] args) {
		Programmers_숫자카드나누기 test = new Programmers_숫자카드나누기();
		int[] arrayA = {14, 35, 119};
		int[] arrayB = {18, 30, 102};
		int result = test.solution(arrayA, arrayB);
		System.out.println(result);
	}
	
	public int solution(int[] arrayA, int[] arrayB) {
        int answer = 0;
        
        int gcdA = arrayA[0];
        int gcdB = arrayB[0];
        
        for(int i=1; i<arrayA.length; i++) gcdA = getGCD(gcdA, arrayA[i]);
        for(int i=1; i<arrayB.length; i++) gcdB = getGCD(gcdB, arrayB[i]);
        
        if(!isDivisible(arrayA, gcdB)) answer = Math.max(answer, gcdB);
        if(!isDivisible(arrayB, gcdA)) answer = Math.max(answer, gcdA);
        
        return answer;
    }
	
	public int getGCD(int a, int b) {
		if(b == 0) return a;
		return getGCD(b, a%b);
	}
	
	public boolean isDivisible(int[] array, int num) {
		for(int i=0; i<array.length; i++) if(array[i] % num == 0) return true;
		return false;
	}

}
