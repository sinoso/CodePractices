package programmers.p3;

public class P3_12900 {
    public static void main(String[] args) {
        System.out.println(solution(1));
        System.out.println(solution(2));
        System.out.println(solution(3));
        System.out.println(solution(4));
        System.out.println(solution(5));
        System.out.println(solution(6));
        System.out.println(solution(7));
        System.out.println(solution(8));
    }

    public static int solution(int n) {
        if (n < 4)
            return n;
        int[] answer = new int[n + 1];
        answer[1] = 1;
        answer[2] = 2;
        answer[3] = 3;
        for (int i = 4; i <= n; i++)
            answer[i] = (answer[i - 1] + answer[i - 2]) % 1000000007;
        return answer[n];
    }
}
