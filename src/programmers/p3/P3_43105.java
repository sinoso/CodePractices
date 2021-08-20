package programmers.p3;


public class P3_43105 {
    public static void main(String[] args) {
        System.out.println(solution(new int[][]{{7}, {3, 8}}));
        System.out.println(solution(new int[][]{{7}, {3, 8}, {8, 1, 0}}));
        System.out.println(solution(new int[][]{{7}, {3, 8}, {8, 1, 0}, {2, 7, 4, 4}}));
        System.out.println(solution(new int[][]{{7}, {3, 8}, {8, 1, 0}, {2, 7, 4, 4}, {4, 5, 2, 6, 5}}));
    }

    public static int solution(int[][] triangle) {
        int height = triangle.length;
        for (int h = height - 1; h > 0; h--) {
            int width = triangle[h].length - 1;
            for (int w = 0; w < width; w++) {
                triangle[h - 1][w] += Math.max(triangle[h][w], triangle[h][w + 1]);
            }
        }
        return triangle[0][0];
    }
}
