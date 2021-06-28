package Programmers.P1;

public class P1_12916 {
    public static void main(String[] args) {
        System.out.println(solution("pPoooyY"));
        System.out.println(solution("Pyy"));
    }

    public static boolean solution(String s) {
        int result = 0;
        for(String str :s.toLowerCase().split("")){
            if(str.equals("p"))
                result++;
            else if (str.equals("y"))
                result--;
        }
        return result == 0;
    }
}
