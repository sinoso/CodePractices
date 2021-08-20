package programmers.p1;
import java.util.Arrays;

public class P1_12944 {
    public static void main(String[] args) {
        System.out.println(solution(new int[]{1,2,3,4}));
    }

    public static double solution(int[] arr) {
        return Arrays.stream(arr).reduce((a,b)->a+b).getAsInt()/(double)arr.length;
    }
}
