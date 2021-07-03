package Programmers.P2;

import java.util.Arrays;

public class P2_43165_AC {
    public static void main(String[] args) {
        System.out.println(solution(new int[]{1, 1, 1, 1, 1},3));
    }
    static int answer = 0;
    public static int solution(int[] numbers, int target) {
        search(numbers.clone(),0,-1,target);
        search(numbers.clone(),0,1,target);
        return answer/2;
    }
    public static void search(int[] numbers,int depth, int multi, int target) {
        if(depth==numbers.length){
            Arrays.stream(numbers).reduce((a,b)->a+b).ifPresent(v-> {
                if (v == target){
                    answer++;
                }
            });
        }else{
            numbers[depth] = numbers[depth]*multi;
            depth++;
            search(numbers.clone(),depth,-1,target);
            search(numbers.clone(),depth,1,target);
        }
    }

}
