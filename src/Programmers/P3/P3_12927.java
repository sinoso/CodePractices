package Programmers.P3;

import java.util.Arrays;

public class P3_12927 {
    public static void main(String[] args) {
        System.out.println(solution(5, new int[]{4, 3, 3}));
        System.out.println(solution(5, new int[]{4}));
        System.out.println(solution(12, new int[]{4, 5}));
        System.out.println(solution(0, new int[]{4, 5}));
    }

    public static long solution(int n, int[] works) {
        Arrays.sort(works);
        int lastIndex = works.length - 1;
        int index = lastIndex;
        int targetValue = 0;
        int left = n;
        while (left != 0) {
            if (index == lastIndex) {
                targetValue = works[index];
                if (targetValue == 0)
                    break;
                works[index]--;
                if (index > 0)
                    index--;
                left--;
                continue;
            }
            if (works[index] < targetValue) {
                index = lastIndex;
                continue;
            }
            works[index]--;
            if (index == 0)
                index = lastIndex;
            else
                index--;
            left--;
        }
        return Arrays.stream(works).mapToLong(v -> (long)v * v).reduce(Long::sum).getAsLong();
    }

}
