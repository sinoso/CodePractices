package Programmers;

public class PrintArray {
    public static void printArray(int[][] array){
        StringBuilder sb = new StringBuilder();
        for(int[] subArray :array){
            for(int value:subArray){
                sb.append(String.format("%3d  ", value));
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }    public static void printArray2(int[][] array){
        StringBuilder sb = new StringBuilder();
        for(int[] subArray :array){
            sb.append("[");
            for(int value:subArray){
                sb.append(String.format("%3d ", value));
            }
            sb.append("]\n");
        }
        System.out.println(sb);
    }
}
