package Programmers;

import java.util.HashSet;

public class P1845 {
    public static void main(String[] args) {
        System.out.println(solution(new int[]{3,3,3,2,2,2}));
    }

    public static int solution(int[] nums) {
        HashSet<Integer> hashset = new HashSet<>();
        for (int num : nums) {
            hashset.add(num);
        }
        return Math.min(hashset.size(), nums.length/2);
    }
}
