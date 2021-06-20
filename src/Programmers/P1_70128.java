package Programmers;

import java.util.HashSet;

public class P1_70128 {
    public static void main(String[] args) {
        System.out.println(solution(new int[]{1,2,3,4},new int[]{-3,-1,0,2}));
        System.out.println(solution(new int[]{-1,0,1},new int[]{1,0,-1}));
    }

    public static int solution(int[] a, int[] b) {
        int pos = 0;
        int answer = 0;
        for(int aValue: a){
            answer += aValue*b[pos++];
        }
        return answer;
    }
}
