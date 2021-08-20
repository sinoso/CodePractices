package programmers.p1;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.stream.Stream;

//프로그래머스 위클리 챌린지
public class P1_83201 {
    public static void main(String[] args) {
        System.out.println(solution(
                new int[][]{{100, 90, 98, 88, 65}, {50, 45, 99, 85, 77}, {47, 88, 95, 80, 67}, {61, 57, 100, 80, 65}, {24, 90, 94, 75, 65}}));
    }

    public static String solution(int[][] scores) {
        return Stream.iterate(0, v -> v + 1).limit(scores.length).map(index -> {
            int[] ints = scores[index];
            int flag = 0;
            int min = Integer.MAX_VALUE;
            int max = 0;
            double sum = 0.0;
            for (int[] score : scores) {
                min = Math.min(min, score[index]);
                max = Math.max(max, score[index]);
                if (ints[index] == score[index])
                    flag++;
                sum += score[index];
            }
            int divider = scores.length;
            if ((max == ints[index] || min == ints[index]) && flag == 1) {
                sum -= ints[index];
                divider--;
            }
            sum = sum / divider;
            return sum >= 90 ? "A" : sum >= 80 ? "B" : sum >= 70 ? "C" : sum >= 50 ? "D" : "F";
        }).reduce((a, b) -> a + b).get();
    }

    public static String solution2(int[][] scores) {
        String[] answer = new String[scores.length];
        for (int index = 0; index < scores.length; index++) {
            int[] ints = scores[index];
            int flag = 0;
            double sum = 0.0;
            ArrayList<Integer> list = new ArrayList<>();
            for (int[] score : scores) {
                list.add(score[index]);
                if (ints[index] == score[index])
                    flag++;
                sum += score[index];
            }
            int divider = scores.length;
            if ((Collections.max(list) == ints[index] || Collections.min(list) == ints[index]) && flag == 1) {
                sum -= ints[index];
                divider--;
            }
            sum = sum / divider;
            if (sum >= 90)
                answer[index] = "A";
            else if (sum >= 80)
                answer[index] = "B";
            else if (sum >= 70)
                answer[index] = "C";
            else if (sum >= 50)
                answer[index] = "D";
            else
                answer[index] = "F";
        }
        return Arrays.stream(answer).reduce((a, b) -> a + b).get();
    }
    public static String solution3(int[][] scores) {
        StringBuilder answer = new StringBuilder();
        for (int index = 0; index < scores.length; index++) {
            int[] ints = scores[index];
            int flag = 0;
            int min = Integer.MAX_VALUE;
            int max = 0;
            double sum = 0.0;
            for (int[] score : scores) {
                min = Math.min(min, score[index]);
                max = Math.max(max, score[index]);
                if (ints[index] == score[index])
                    flag++;
                sum += score[index];
            }
            int divider = scores.length;
            if ((max == ints[index] || min == ints[index]) && flag == 1) {
                sum -= ints[index];
                divider--;
            }
            sum = sum / divider;
            answer.append(sum >= 90 ? "A" : sum >= 80 ? "B" : sum >= 70 ? "C" : sum >= 50 ? "D" : "F");
        }
        return answer.toString();
    }
}
