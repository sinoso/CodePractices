package programmers.p1;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class P1_12935 {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(solution(new int[]{4, 3, 2, 1})));
        System.out.println(Arrays.toString(solution(new int[]{10})));
    }

    public static int[] solution(int[] arr) {
        if (arr.length == 1)
            return new int[]{-1};
        int min = Arrays.stream(arr).min().getAsInt();
        return Arrays.stream(arr).filter(v -> v != min).toArray();
    }

    public static int[] solution2(int[] arr) {
        int temp = arr[0];
        int tempIdx = 0;
        int length = arr.length;
        for (int i = 1; i < length; i++) {
            if (arr[i] < temp) {
                temp = arr[i];
                tempIdx = i;
            }
        }
        List<Integer> list = Arrays.stream(arr).boxed().collect(Collectors.toList());
        list.remove(tempIdx);
        if (list.size() == 0) {
            return new int[]{-1};
        } else
            return list.stream().mapToInt(v -> v).toArray();
    }
}
