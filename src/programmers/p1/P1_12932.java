package programmers.p1;

import java.util.*;

public class P1_12932 {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(solution(12345)));
    }

    public static int[] solution(long n) {
        List<Integer> list = new ArrayList<>();
        while (n > 0) {
            list.add((int) (n % 10));
            n = n / 10;
        }
        return list.stream().mapToInt(v -> v).toArray();
    }
}
