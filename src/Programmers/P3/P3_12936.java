package Programmers.P3;


import java.util.*;

public class P3_12936 {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(solution(4, 5)));
        System.out.println(Arrays.toString(solution(4, 6)));
        System.out.println(Arrays.toString(solution(4, 7)));
    }

    public static int[] solution(int n, long k) {
        int[] answer = new int[n];
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0; i < n; i++)
            list.add(i + 1);

        long left = k - 1;

        for (int i = 0; i < n; i++) {
            long range = pac(n - 1 - i);
            answer[i] = list.get((int) (left / range));
            list.remove(Integer.valueOf(answer[i]));
            left %= range;
        }
        return answer;
    }

    public static long pac(long k) {
        if (k <= 1)
            return 1;
        return k * pac(k - 1);
    }
}
