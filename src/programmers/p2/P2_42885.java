package programmers.p2;


import java.util.Arrays;

public class P2_42885 {
    public static void main(String[] args) {
        System.out.println(solution(new int[]{70, 50, 80, 50}, 100));
        System.out.println(solution(new int[]{1, 10, 40, 40, 50, 60, 70, 79, 90}, 100));
        System.out.println(solution(new int[]{70, 80, 50}, 100));
    }

    public static int solution(int[] people, int limit) {
        int i = 0;
        Arrays.sort(people);
        for (int lastIdx = people.length - 1; i < lastIdx; )
            if (people[i] + people[lastIdx--] <= limit)
                i++;
        return people.length - i;
    }

    public static int solution2(int[] people, int limit) {
        int answer = 0;
        int lastIdx = people.length - 1;
        Arrays.sort(people);
        for (int i = 0; i <= lastIdx; ) {
            if (people[i] + people[lastIdx] <= limit) {
                i++;
            }
            lastIdx--;
            answer++;
        }
        return answer;
    }
}
