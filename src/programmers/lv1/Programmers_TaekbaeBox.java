package programmers.lv1;

public class Programmers_TaekbaeBox {
    public static void main(String[] args) {
        int n = 22;
        int w = 6;
        int num = 8;
        Programmers_TaekbaeBox test = new Programmers_TaekbaeBox();
        int result = test.solution(n, w, num);
        System.out.println("result: " + result);
    }

    public int solution(int n, int w, int num) {
        System.out.println();
        int height = (n / w) + 1;
        boolean dir = height % 2 == 0 ? true : false; // 정방향:왼오(짝수) / 역방향:오왼(홀수)
        int[][] map = new int[height][w];

        int totalN = height * w;
        int copyN = n;
        for (int i = 0; i < map.length; i++) {
            if (dir) {

            }
            for (int j = 0; j < map[i].length; j++) {
                if (n >= totalN--) {
                    map[i][j] = copyN--;
                } else {
                    map[i][j] = 0;
                }
            }
        }

        printMap(map);
        int count = 888;
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
