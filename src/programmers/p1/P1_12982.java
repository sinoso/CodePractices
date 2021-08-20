package programmers.p1;

import java.util.Arrays;

public class P1_12982 {
    public static void main(String[] args) {
        System.out.println(solution(new int[]{1, 3, 2, 5, 4}, 9));//3
        System.out.println(solution(new int[]{2, 2, 3, 3}, 10));//4
    }

    public static int solution(int[] d, int budget) {
        int used = 0;
        int answer = 0;
        d = Arrays.stream(d).sorted().toArray();
        for (int requested : d) {
            if (requested + used > budget)
                break;
            used += requested;
            answer++;
        }
        return answer;
    }
}
