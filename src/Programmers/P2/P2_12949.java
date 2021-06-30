package Programmers.P2;

import Programmers.PrintArray;

public class P2_12949 {
    public static void main(String[] args) {
        System.out.println();
        PrintArray.printArray2(solution(new int[][]{{1, 4}, {3, 2}, {4, 1}}, new int[][]{{3, 3}, {3, 3}}));
        PrintArray.printArray2(solution(new int[][]{{2, 3, 2}, {4, 2, 4}, {3, 1, 4}}, new int[][]{{5, 4, 3}, {2, 4, 1},{3, 1, 1}}));
    }

    public static int[][] solution(int[][] arr1, int[][] arr2) {
        int array1Length = arr1.length;
        int array2Length = arr2[0].length;
        int[][] answer = new int[array1Length][array2Length];

        for (int i =0;i<array1Length;i++){
            for(int j = 0;j<array2Length;j++){
                int elementValue=0;
                int[] subArray = arr1[i];
                int subArrayLength = subArray.length;
                for(int k=0;k<subArrayLength;k++){
                    elementValue += subArray[k]*arr2[k][j];
                }
                answer[i][j] = elementValue;
            }
        }
            return answer;
    }

}
