package Programmers.P1;

import Programmers.PrintArray;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class P1_12950 {
    public static void main(String[] args) {
        PrintArray.printArray2(solution(new int[][]{{1, 2}, {2, 3}}, new int[][]{{3, 4}, {5, 6}}));
        PrintArray.printArray2(solution(new int[][]{{1}, {2}}, new int[][]{{3}, {4}}));
    }

    public static int[][] solution(int[][] arr1, int[][] arr2) {
        int length = arr1.length;
        int subLength = arr1[0].length;
        int[][] answer = new int[arr1.length][arr1[0].length];
        for (int i = 0; i < length; i++) {
            for (int j = 0; j < subLength; j++) {
                answer[i][j] = arr1[i][j] + arr2[i][j];
            }
        }
        return answer;
    }
}
