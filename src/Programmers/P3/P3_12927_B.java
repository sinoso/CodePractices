package Programmers.P3;

import java.util.Arrays;

public class P3_12927_B {
    public static void main(String[] args) {
        System.out.println(solution(5, new int[]{4, 3, 3}));
        System.out.println(solution(5, new int[]{4}));
        System.out.println(solution(12, new int[]{4, 5}));
    }

    public static long solution(int n, int[] works) {
        Arrays.sort(works);
        int lastIndex = works.length - 1;
        int index = lastIndex;
        int targetValue = 0;
        int left = n;
        while (left != 0) {
            if (index == lastIndex) {
                targetValue = works[index];
                if (targetValue == 0)
                    break;
                works[index]--;
                if (index > 0)
                    index--;
                left--;
                continue;
            }
            if (works[index] < targetValue) {
                index = lastIndex;
                continue;
            }
            works[index]--;
            if (index == 0)
                index = lastIndex;
            else
                index--;
            left--;
        }
        return Arrays.stream(works).map(v -> v * v).reduce(Integer::sum).orElse(0);
    }

    public static long solution2(int n, int[] works) {
        long answer = 0;
        Arrays.sort(works);
        int lastIndex = works.length - 1;
        int index = lastIndex;
        int left = n;
        while (left != 0) {
            if (works[index - 1] < works[index]) {// index직전의 숫자보다 지금이 크다면?
                left -= works[index] - works[index - 1];
                works[index] = works[index - 1];
            } else if (works[index - 1] == works[index]) {
                if (index == lastIndex) {

                }
            }
        }
        //소팅한다
        //뒤에서부터 1씩뺀다 이때 앞의 숫자보다 적어야한다.
        //이때 앞의 숫자랑 현재뺀숫자가 같아지면 ?
        // 맨뒤에서 부터 다시 시작!
        return answer;
    }

}
