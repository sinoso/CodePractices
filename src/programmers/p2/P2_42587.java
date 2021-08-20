package programmers.p2;

import java.util.*;

public class P2_42587 {
    public static void main(String[] args) {
        System.out.println(solution(new int[]{2, 1, 3, 2}, 2));
        System.out.println(solution(new int[]{1, 1, 9, 1, 1, 1}, 0));
    }

    public static int solution(int[] priorities, int location) {
        int answer = 0;
        boolean[] list = new boolean[priorities.length];
        list[location] = true;

        List<Integer> queue = new ArrayList<>();

        int length = priorities.length;
        for (int i = 0; i < length; i++) {
            queue.add(i);
        }

        boolean stopFlag = false;
        while (!stopFlag) {
            int index = queue.get(0);
            int currentPriority = priorities[index];
            boolean remove = true;
            for (int priority : priorities) {
                if (currentPriority < priority) {
                    queue.add(queue.get(0));
                    queue.remove(0);
                    remove = false;
                    break;
                }
            }
            if (remove) {
                answer++;
                queue.remove(0);
                priorities[index] = 0;
                stopFlag = list[index];
            }
        }

        return answer;
    }

}
