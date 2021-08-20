package programmers.p1;

import java.util.stream.Stream;

//프로그래머스 위클리 챌린지
public class P1_82612 {
    public static void main(String[] args) {
        System.out.println(solution(3, 20, 4));
    }

    public static long solution(int price, int money, int count) {
        long answer = Stream.iterate(1, v -> v + 1).limit(count).mapToLong(v -> (long) v * price).sum() - money;
        if (answer > 0)
            return answer;
        return 0;
    }
}
