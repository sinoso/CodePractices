package Programmers.P2;

import java.util.Arrays;

public class P2_12941 {
    public static void main(String[] args) {
        System.out.println(solution(new int[]{1, 4, 2}, new int[]{5, 4, 4}));
        System.out.println(solution(new int[]{1, 2}, new int[]{3, 4}));
    }

    public static int solution(int[] A, int[] B) {
        Arrays.sort(A);
        Arrays.sort(B);
        int sum = 0;
        int lastIndex = A.length - 1;
        for (int i = 0; i <= lastIndex; i++)
            sum += A[i] * B[lastIndex - i];
        return sum;
    }

}
