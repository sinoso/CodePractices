package programmers.p3;


import java.util.Arrays;

public class P3_12938 {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(solution(2, 9)));
        System.out.println(Arrays.toString(solution(2, 1)));
        System.out.println(Arrays.toString(solution(2, 8)));
        System.out.println(Arrays.toString(solution(3, 9)));
        System.out.println(Arrays.toString(solution(3, 10)));
        System.out.println(Arrays.toString(solution(5, 9)));
    }

    public static int[] solution(int n, int s) {
        if (s / n == 0)
            return new int[]{-1};
        int[] result = new int[n];
        int element = s / n;
        Arrays.fill(result, element);
        int mod = s % n;
        if (mod != 0) {
            for (int i = 0; i < mod; i++)
                result[result.length - 1 - i]++;
        }
        return result;
    }
}
