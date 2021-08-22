package programmers.p5;


import java.util.*;

public class P5_12974B {
    public static void main(String[] args) {
        System.out.println(solution(new int[][]{{0, 1, 4, 4}, {3, 1, 5, 3}}));
        System.out.println(solution(new int[][]{{1, 1, 6, 5}, {2, 0, 4, 2}, {2, 4, 5, 7}, {4, 3, 8, 6}, {7, 5, 9, 7}}));
    }

    public static long solution(int[][] rectangles) {



        return 1;
    }
    public static long solution2(int[][] rectangles) {
        Set<Long> cells = new HashSet<>();
        long answer = 0;
        for (int[] rectangle : rectangles) {
            for (int i = rectangle[0]; i <  rectangle[2]; i++) {
                for (int j = rectangle[1]; j < rectangle[3]; j++) {
                    if (cells.add(i * 1000000000L + j)) {
                        answer++;
                    }
                }
            }
        }
        return answer;
    }
}
