package Programmers.P1;


public class P1_12947 {
    public static void main(String[] args) {
        System.out.println(solution(18));
    }

    public static boolean solution(int x) {
        int sum = 0;
        int temp = x;
        while (temp != 0) {
            sum += temp % 10;
            temp = temp / 10;
        }
        return x % sum == 0;
    }
}
