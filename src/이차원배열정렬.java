import java.util.Arrays;
import java.util.Comparator;

public class 이차원배열정렬 {
	public static void main(String[] args) {
		int[][] arr = { { 0, 3 }, { 2, 6 }, { 1, 9 }, { 1, 8 } };
		
		for (int[] is : arr) {
			System.out.println(Arrays.toString(is));
		}
		
		/*
		Arrays.sort(arr, new Comparator<int[]>() {
			@Override
			public int compare(int[] o1, int[] o2) {
				// return o1[0]-o2[0];	// 첫번째 숫자 기준 오름차순
				// return o2[0]-o1[0];	// 첫번째 숫자 기준 내림차순
				// return o1[1]-o2[1]; // 두번째 숫자 기준 오름차순
				// return o2[1]-o1[1];	// 두번째 숫자 기준 내림차순
				return o1[0]==o2[0] ? o1[1]-o2[1] : o1[0]-o2[0];	// 첫번쨰 숫자가 같은 경우 두번째 숫자 오름차순
			}
		});
		*/
		Arrays.sort(arr, (o1, o2) -> {
			return o1[0]-o2[0];
		});
		
		System.out.println("==============================================================");
		for (int[] is : arr) {
			System.out.println(Arrays.toString(is));
		}
		
		
		
	}
}
