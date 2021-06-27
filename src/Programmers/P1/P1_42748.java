package Programmers.P1;

import java.util.Arrays;

public class P1_42748 {
    public static void main(String[] args) {
        int[] result = solution(new int[]{1, 5, 2, 6, 3, 7, 4}, new int[][]{{2, 5, 3}, {4, 4, 1}, {1, 7, 3}});
        for(int value:result)
        System.out.println(value);
    }

    public static int[] solution(int[] array, int[][] commands) {
        int[] answer = new int[commands.length];
        for (int comPos = 0;comPos<commands.length;comPos++){
            int[] subArray = Arrays.copyOfRange(array,commands[comPos][0]-1,commands[comPos][1]);
            Arrays.sort(subArray);
            answer[comPos]=subArray[commands[comPos][2]-1];
        }
        return answer;
    }
}
