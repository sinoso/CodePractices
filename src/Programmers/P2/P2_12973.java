package Programmers.P2;

import java.util.Stack;

public class P2_12973 {
    public static void main(String[] args) {
        System.out.println();
        System.out.println(solution("baabaa"));
        System.out.println(solution("cdcd"));
        System.out.println(solution(""));
    }

    public static int solution(String s) {
        if (s.length() == 0)
            return 0;
        Stack<Character> stack = new Stack<>();
        char[] arrays = s.toCharArray();
        for (char array : arrays) {
            if (stack.isEmpty()) {
                stack.push(array);
                continue;
            }
            if (stack.peek().equals(array)) {
                stack.pop();
                continue;
            }
                stack.push(array);
        }
        if (stack.isEmpty())
            return 1;
        return 0;
    }

}
