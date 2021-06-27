package Programmers;

public class P1_12919 {
    public static void main(String[] args) {
        System.out.println(solution(new String[]{"Jane", "Kim"}));
    }

    public static String solution(String[] seoul) {
        int index = 0;
        int length = seoul.length;
        for(int i=0;i<length;i++){
            if(seoul[i].equals("Kim")) {
                index = i;
                break;
            }
        }
        return "김서방은 "+index+"에 있다";
    }
}
