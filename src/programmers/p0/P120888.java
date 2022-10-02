package programmers.p0;

import java.util.Arrays;
import java.util.stream.Collectors;

public class P120888 {
    public static void main(String[] args) {
    }

    public static String solution(String my_string) {
        return Arrays.stream(my_string.split("")).distinct().collect(Collectors.joining());
    }

}
