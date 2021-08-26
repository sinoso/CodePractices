package programmers.p2;

public class P2_12909 {
    public static void main(String[] args) {
        System.out.println(solution("()()"));
        System.out.println(solution(")()("));
        System.out.println(solution("(()("));
        System.out.println(solution("(()())"));
    }

    public static boolean solution(String s) {
        char[] array = s.toCharArray();
        char l = '(';
        int ll = 0;
        for (char c : array) {
            if (ll < 0)
                return false;
            if (c == l)
                ll++;
            else
                ll--;
        }
        return ll == 0;
    }
}
