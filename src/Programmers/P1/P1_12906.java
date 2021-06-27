package Programmers.P1;

import java.util.*;

public class P1_12906 {
    public static void main(String[] args) {
        int[] result = solution(new int[]{1, 1, 1, 2, 2, 2, 3, 3, 4, 5, 9, 7,1});
        for (int value : result)
            System.out.println(value);
    }

    public static int[] solution(int[] arr) {
        List<Integer> list = new ArrayList<>();
        int lastValue = -1;
        for (int j : arr) {
            if (lastValue != j) {
                list.add(j);
                lastValue = j;
            }
        }
        return list.stream().mapToInt(v->v).toArray();
    }
}
