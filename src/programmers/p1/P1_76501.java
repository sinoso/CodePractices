package programmers.p1;


import java.util.stream.Stream;

public class P1_76501 {
    public static void main(String[] args) {
        System.out.println(solution(new int[]{4, 7, 12}, new boolean[]{true, false, true}));
        System.out.println(solution(new int[]{1, 2, 3}, new boolean[]{false, false, true}));
    }

    public static int solution(int[] absolutes, boolean[] signs) {
        return Stream.iterate(0, v -> v + 1).limit(absolutes.length).map(index -> absolutes[index] * (signs[index] ? 1 : -1)).reduce(Integer::sum).get();
    }
}
