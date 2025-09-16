package programmers.lv2;

public class Programmers_340212 {
    public static void main(String[] args) {
        Programmers_340212 test = new Programmers_340212();
        int[] diffs = { 1, 328, 467, 209, 54 };
        int[] times = { 2, 7, 1, 4, 3 };
        long limit = 1723;
        int result = test.solution(diffs, times, limit);
        System.out.println("result: " + result);
    }

    public int solution(int[] diffs, int[] times, long limit) {
        long answer = -1;
        long left = 1;
        long right = 100000;
        while (left <= right) {
            long mid = (left + right) / 2;
            if (isSolve(diffs, times, limit, mid)) {
                right = mid - 1;
                answer = mid;
            } else {
                left = mid + 1;
            }
        }
        return (int) answer;
    }

    public boolean isSolve(int[] diffs, int[] times, long limit, long level) {
        long totalTime = 0;
        for (int i = 0; i < diffs.length; i++) {
            int diff = diffs[i];
            if (diff <= level) {
                totalTime += times[i];
            } else {
                long failure = diff - level;
                long prevTime = i == 0 ? 0 : times[i - 1];
                totalTime += (prevTime + times[i]) * failure + times[i];
            }
        }
        if (totalTime > limit)
            return false;
        return true;
    }

}
