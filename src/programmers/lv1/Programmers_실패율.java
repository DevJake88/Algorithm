package programmers.lv1;

import java.util.Arrays;
import java.util.Comparator;

public class Programmers_실패율 {

	public static void main(String[] args) {
		Programmers_실패율 test = new Programmers_실패율();
		int N = 4;
		int[] stages = {4,4,4,4,4};
		int[] result = test.solution(N, stages);
		System.out.println(Arrays.toString(result));
	}
	
	public int[] solution(int N, int[] stages) {
        int[] answer = new int[N];

        int[] challegeStageArr = new int[N];
        Arrays.sort(stages);
        for (int stage : stages) {
        	if(stage-1 == N) continue;
        	challegeStageArr[stage-1]++;
		}
        
        int total = stages.length;
        double[][] failRateArr = new double[N][2];
        for(int i=0; i<challegeStageArr.length; i++) {
        	int failNum = challegeStageArr[i];
        	if(failNum > 0) {
        		failRateArr[i][0] = i+1;
        		failRateArr[i][1] = failNum / (float) total;
        		total -= failNum;
        	} else {
        		failRateArr[i][0] = i+1;
        		failRateArr[i][1] = 0;
        	}
        }
        
        Arrays.sort(failRateArr, new Comparator<double[]>() {
			@Override
			public int compare(double[] o1, double[] o2) {
				if(o1[1] == o2[1]) {
					return (int) (o1[0]-o2[0]);
				} else {
					return (int) Math.floor(o2[1]-o1[1]);
				}
			}
        });
        
        for (int i = 0; i < failRateArr.length; i++) {
			answer[i] = (int) failRateArr[i][0];
		}
        
        return answer;
    }

}
