package programmers.p1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class P1_12910 {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(solution(new int[]{5, 9, 7, 10}, 5)));
        System.out.println(Arrays.toString(solution(new int[]{2, 36, 1, 3}, 1)));
        System.out.println(Arrays.toString(solution(new int[]{3, 2, 6}, 10)));
    }

    public static int[] solution(int[] arr, int divisor) {
        List<Integer> list = new ArrayList<>();
        Arrays.sort(arr);
        for (int i : arr) {
            if (i % divisor == 0 && i != 0)
                list.add(i);
        }
        return list.size() > 0 ? list.stream().mapToInt(v->v).toArray() : new int[]{-1};
    }

    public static int[] solution2(int[] arr, int divisor) {
        int[] result = Arrays.stream(arr).sorted().filter(v -> v != 0).filter(v -> v % divisor == 0).toArray();
        return result.length > 0 ? result : new int[]{-1};
    }
}
