package Programmers;

public class P1_12901 {
    public static void main(String[] args) {
        System.out.println(solution(5,24));
    }

    public static String solution(int a, int b) {
        int dateValue=0;
        String answer;
        switch (a){
            case 12:
                dateValue+=30;
            case 11:
                dateValue+=31;
            case 10:
                dateValue+=30;
            case 9:
                dateValue+=31;
            case 8:
                dateValue+=31;
            case 7:
                dateValue+=30;
            case 6:
                dateValue+=31;
            case 5:
                dateValue+=30;
            case 4:
                dateValue+=31;
            case 3:
                dateValue+=29;
            case 2:
                dateValue+=31;
            default:
                break;
        }
        dateValue+=b;
        answer = switch (dateValue % 7) {
            case 1 -> "FRI";
            case 2 -> "SAT";
            case 3 -> "SUN";
            case 4 -> "MON";
            case 5 -> "TUE";
            case 6 -> "WED";
            default -> "THU";
        };
        return answer;
    }
}
