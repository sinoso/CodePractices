package Programmers.P1;

public class P1_12922 {
    public static void main(String[] args) {
        System.out.println(solution(0));
    }

    public static String solution(int n) {
        StringBuilder sb = new StringBuilder();
        while (n-->0){
            sb.append("수");
            if(n-->0)
            sb.append("박");
        }
        return sb.toString();
    }
}
