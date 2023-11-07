package boj;

import java.util.Arrays;
import java.util.Scanner;

public class BOJ_5073 {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int[] arr = new int[3];
		
		while(true) {
			arr[0] = scan.nextInt();
			arr[1] = scan.nextInt();
			arr[2] = scan.nextInt();

			if(arr[0] == 0 && arr[1] == 0 && arr[2] == 0) break;
			else {
				Arrays.sort(arr);
				
				if(arr[2] >= arr[0] + arr[1]) System.out.println("Invalid");
				else if(arr[0] == arr[1] && arr[1] == arr[2]) System.out.println("Equilateral");
				else if(arr[0] == arr[1] || arr[1] == arr[2] || arr[0] == arr[2]) System.out.println("Isosceles");
				else if(arr[0] != arr[1] && arr[1] != arr[2] && arr[0] != arr[2]) System.out.println("Scalene");
			}
		}
	}

}
