package Programmers.P1;

import java.util.stream.Stream;

public class P1_12928 {
    public static void main(String[] args) {
        System.out.println(solution(10));
    }

    public static int solution(int n) {
        return Stream.iterate(1, v -> v + 1).limit(n).filter(v -> n % v == 0).reduce(Integer::sum).orElseGet(() -> 0);
    }
}
