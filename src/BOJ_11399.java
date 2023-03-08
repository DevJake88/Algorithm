import java.util.Arrays;
import java.util.Scanner;

public class BOJ_11399 {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int N = scan.nextInt();
		
		int[] processTimeArr = new int[N];
		for(int i=0; i<N; i++) {
			processTimeArr[i] = scan.nextInt();
		}
		Arrays.sort(processTimeArr);
		
		int sum = 0;
		int result = 0;
		for(int i=0; i<N; i++) {
			sum += processTimeArr[i];
			result += sum;
		}
		
		System.out.println(result);
	}
}
