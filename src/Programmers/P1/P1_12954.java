package Programmers.P1;

import java.util.Arrays;
import java.util.stream.Collectors;

public class P1_12954 {
    public static void main(String[] args) {
        long[] solution = solution(1, 1);
        for (long l : solution)
            System.out.println(l);
    }

    public static long[] solution(int x, int n) {
        long[] answer = new long[n];
        int i = 0;
        while(i<n){
            answer[i] = x*(1+i++);
        }
        return answer;
    }
}
