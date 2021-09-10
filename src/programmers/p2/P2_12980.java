package programmers.p2;

import programmers.PrintArray;

public class P2_12980 {
    public static void main(String[] args) {
        System.out.println(solution(1));
        System.out.println(solution(5));
        System.out.println(solution(6));
        System.out.println(solution(5000));
    }

    public static int solution(int n) {
        return Integer.bitCount(n);
    }

}
