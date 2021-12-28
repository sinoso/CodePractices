package programmers.p1;

import java.util.Arrays;
import java.util.Comparator;

public class P1_12915 {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(solution(new String[]{"sun", "bed", "car"}, 1)));
        System.out.println(Arrays.toString((solution(new String[]{"abce", "abcd", "cdx"}, 2))));
    }

    static public String[] solution(String[] strings, int n) {
        return Arrays.stream(strings).sorted().sorted(Comparator.comparing(it -> it.charAt(n))).toArray(String[]::new);
    }
}
