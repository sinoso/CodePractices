package programmers.p2;

public class P2_12913 {
    public static void main(String[] args) {
        System.out.println(solution(new int[][]{{1, 2, 3, 5}, {5, 6, 7, 8}, {4, 3, 2, 1}}));
    }

    public static int solution(int[][] land) {
        int max;
        int length = land.length;
        int innerLength = land[0].length;
        for (int i = 1; i < length; i++) {
            for (int j = 0; j < innerLength; j++) {
                max = -1;
                for (int k = 0; k < innerLength; k++) {
                    if (j == k)
                        continue;
                    max = Math.max(max, land[i - 1][k]);
                }
                land[i][j] += max;
            }
        }
        max = -1;
        for (int value : land[land.length - 1]) {
            max = Math.max(max, value);
        }
        return max;
    }
}
