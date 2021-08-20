package programmers.p2;

import java.util.*;

public class P2_42584 {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(solution(new int[]{1, 2, 3, 2, 3})));
        System.out.println(Arrays.toString(solution(new int[]{9,8,7,6,5,4,3,2,1})));
    }

    public static int[] solution(int[] prices) {
        int[] answer = new int[prices.length];
        LinkedList<Integer> list = new LinkedList<>();
        list.add(0);
        int currentValue;
        for (int i = 1; i < prices.length; i++) {
            currentValue = prices[i];
            list.add(i);
            for (int j = list.size() - 1; j >= 0; j--) {
                answer[list.get(j)] = i - list.get(j);
                if (prices[list.get(j)] > currentValue) {
                    list.remove(j);
                }
            }
        }
        return answer;
    }

}
