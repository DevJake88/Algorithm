package programmers.lv1;

import java.util.HashMap;

/* LV1 가장 많이 받은 선물 */
public class Programmers_258712 {
    public static void main(String[] args) {
        Programmers_258712 test = new Programmers_258712();
        String[] friends = { "joy", "brad", "alessandro", "conan", "david" };
        String[] gifts = { "alessandro brad", "alessandro joy", "alessandro conan", "david alessandro",
                "alessandro david" };

        int result = test.solution(friends, gifts);
        System.out.println("result: " + result);
    }

    public int solution(String[] friends, String[] gifts) {
        int N = friends.length;
        HashMap<String, Integer> idxMap = new HashMap<>();
        for (int i = 0; i < N; i++) {
            idxMap.put(friends[i], i);
        }

        int[][] giftMatrix = new int[N][N];
        for (int i = 0; i < gifts.length; i++) {
            String gift = gifts[i];
            String[] giftArr = gift.split(" ");
            int giverIdx = idxMap.get(giftArr[0]);
            int receiverIdx = idxMap.get(giftArr[1]);
            giftMatrix[giverIdx][receiverIdx]++;
        }

        // 선물 지수
        int[] giftScore = new int[N];
        for (int i = 0; i < N; i++) {
            int totalGive = 0;
            int totalReceive = 0;
            for (int j = 0; j < N; j++) {
                totalGive += giftMatrix[i][j];
                totalReceive += giftMatrix[j][i];
            }
            giftScore[i] = totalGive - totalReceive;
        }

        int maxCount = 0;
        for (int i = 0; i < N; i++) {
            int count = 0;
            for (int j = 0; j < N; j++) {
                if (i == j)
                    continue;
                if (giftMatrix[i][j] > giftMatrix[j][i]) {
                    count++;
                } else if (giftMatrix[i][j] == giftMatrix[j][i]) {
                    if (giftScore[i] > giftScore[j]) {
                        count++;
                    }
                }
            }
            maxCount = Math.max(maxCount, count);
        }
        return maxCount;
    }
}
