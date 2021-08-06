package Programmers.P2;


public class P2_12924 {
    public static void main(String[] args) {
        System.out.println(solution(5));
        System.out.println(solution(15));
        System.out.println(solution(1));
    }

    public static int solution(int n) {
        int answer = 1;
        int startValue = 1;
        while (startValue <= n / 2) {
            int temp = 0;
            for (int i = startValue; i < n; i++) {
                temp += i;
                if (temp >= n) {
                    if (temp == n)
                        answer++;
                    break;
                }
            }
            startValue++;
        }
        return answer;
    }

}
