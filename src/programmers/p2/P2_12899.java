package programmers.p2;

import java.util.Stack;

public class P2_12899 {
    public static void main(String[] args) {
        for (int i = 1; i < 100; i++)
            System.out.println(solution(i));
    }

    public static String solution(int n) {
        Stack<Integer> stack = new Stack<>();
        StringBuilder sb = new StringBuilder();
        int mod;
        while (n > 0) {
            mod = n % 3;
            if (mod == 0) {
                stack.push(4);
                n = n / 3 - 1;
            } else {
                stack.push(mod);
                n = n / 3;
            }
        }
        while(!stack.isEmpty()){
            sb.append(stack.pop());
        }
        return sb.toString();
    }
}
