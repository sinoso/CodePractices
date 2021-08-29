package programmers.p3;


import java.util.Arrays;

public class P3_12987 {
    public static void main(String[] args) {
        System.out.println(solution(new int[]{5, 1, 3, 7}, new int[]{2, 2, 6, 8}));
        System.out.println(solution(new int[]{2, 2, 2, 2}, new int[]{1, 1, 1, 1}));
    }

    public static int solution(int[] A, int[] B) {
        Arrays.sort(A);
        Arrays.sort(B);
        int answer = 0;
        int length = A.length;
        int largeIdx = length - 1;
        for (int i = length - 1; i >= 0; i--) {
            if (A[i] < B[largeIdx]) {
                answer++;
                largeIdx--;
            }
        }
        return answer;
    }
}
