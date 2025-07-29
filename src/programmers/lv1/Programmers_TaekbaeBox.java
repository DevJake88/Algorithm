package programmers.lv1;

public class Programmers_TaekbaeBox {
    public static void main(String[] args) {
        int n = 13;
        int w = 3;
        int num = 6;
        Programmers_TaekbaeBox test = new Programmers_TaekbaeBox();
        int result = test.solution(n, w, num);
        System.out.println("result: " + result);
    }

    public int solution(int n, int w, int num) {
        int h = (n + w - 1) / w;
        int[][] warehouse = new int[h][w];
        int box = 1;

        // 상자들을 지그재그로 채움
        for (int r = 0; r < h; r++) {
            if (r % 2 == 0) { // 왼->오
                for (int c = 0; c < w; c++) {
                    if (box <= n)
                        warehouse[r][c] = box++;
                }
            } else {
                for (int c = w - 1; c >= 0; c--) {
                    if (box <= n)
                        warehouse[r][c] = box++;
                }
            }
        }

        // num 상자 위치 찾기
        int posNumR = -1;
        int posNumC = -1;
        for (int i = 0; i < h; i++) {
            for (int j = 0; j < w; j++) {
                if (warehouse[i][j] == num) {
                    posNumR = i;
                    posNumC = j;
                    break;
                }
            }
        }

        int count = 0; // 자기 자신
        for (int i = posNumR; i < h; i++) {
            if (warehouse[i][posNumC] != 0)
                count++;
        }

        printMap(warehouse);
        return count;
    }

    public void printMap(int[][] map) {
        System.out.println();
        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map[i].length; j++) {
                System.out.print(map[i][j] + " ");
            }
            System.out.println();
        }
    }
}
