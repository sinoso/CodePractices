package Programmers.P1;

public class P1_12943 {
    public static void main(String[] args) {
        System.out.println(solution(6));
        System.out.println(solution(16));
        System.out.println(solution(626331));
    }

    public static int solution(int num) {
        int tries = 0;
        long numL = num;
        while (numL != 1 && tries < 500) {
            tries++;
            if (numL % 2 == 0)
                numL /= 2;
            else {
                numL *= 3;
                numL++;
            }
        }
        return tries == 500 ? -1 : tries;
    }
}
