package programmers.p2;

public class P2_12911 {
    public static void main(String[] args) {
        System.out.println(solution(78));
        System.out.println(solution(15));
        System.out.println(solution(10));
//        System.out.println(solution(1));
//        System.out.println(solution(3));
//        System.out.println(solution(6));
    }

    public static int solution(int n) {
        int i = n + 1;
        while(true)
            if (Integer.bitCount(i++) == Integer.bitCount(n))
                return i-1;
    }
}
