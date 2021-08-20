package programmers.p1;

import java.util.*;

public class P1_77884 {
    public static void main(String[] args) {
        System.out.println(solution(24, 27));
    }

    public static int solution(int left, int right) {
        //약수 홀수면 -= 짝수면 +=
        int result = 0;
        for (int i = left; i < right + 1; i++) {
            //약수 구하기
            Set<Integer> set = new HashSet<>();
            for (int j = 1; j <= i; j++) {
                if (i % j == 0) {
                    if (!(set.add(j) && set.add(i / j))) {
                        break;
                    }
                }
            }
            result += set.size() % 2 == 0 ? i : -i;
        }
        return result;
    }
}
