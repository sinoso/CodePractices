package programmers.p1;

import java.util.Arrays;

public class P1_12940 {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(solution(6, 8)));
    }

    public static int[] solution(int n, int m) {
        return new int[]{gcd(n, m), lcm(n, m)};
    }

    public static int lcm(int n, int m) {
        int min = Math.min(n, m);
        int max = Math.max(n, m);
        int lcm = 1;
        for (int i = 2; i <= min; ) {
            if (min % i == 0 && max % i == 0) {
                min /= i;
                max /= i;
                lcm *= i;
            } else
                i++;
        }
        lcm = lcm * min * max;
        return lcm;
    }

    public static int gcd(int a, int b) {
        if (b == 0)
            return a;
        else
            return gcd(b, a % b);
    }
}