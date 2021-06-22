package Programmers;

public class P1_12912 {
    public static void main(String[] args) {
        System.out.println(solution(3, 5));
        System.out.println(solution(3, 3));
        System.out.println(solution(5, 3));
        System.out.println(solution(-2, 1));
        System.out.println(solution(1, -2));

    }

    public static long solution(int a, int b) {
        long answer;
        int max = Math.max(a, b);
        int min = Math.min(a, b);
        answer = min;
        for (int i = 1; i < max - min + 1; i++) {
            answer += min + i;
        }
        return answer;
    }

}
