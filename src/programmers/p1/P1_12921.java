package programmers.p1;

public class P1_12921 {
    public static void main(String[] args) {
//        System.out.println(solution(10));
//        System.out.println(solution(100000));
        System.out.println(solution(2));
    }
    public static int solution(int n) {
        int[] fullSized = new int[n + 1];
        int result = 0;
        for (int i = 2; i <= n; i++) {
            fullSized[i] = i;
        }
        for (int i = 2; i <= n; i++) {
            if (fullSized[i] == 0)
                continue;
            result++;
            for (int j = i + i; j <= n; j += i) {
                fullSized[j] = 0;
            }
        }
        return result;
    }
    public static int noSolution1(int n) {
        int answer = 1;
        if(n==2)
            return answer;
        for (int i = 3; i <= n; i++) {
            boolean flag = true;
            for (int j = 2; j < i; j++) {
                if (i % j == 0) {
                    flag = false;
                    break;
                }
            }
            if(flag)
                answer++;
        }
        return answer;
    }
}
