package Programmers.P1;

public class P1_12948 {
    public static void main(String[] args) {
            System.out.println(solution("01033334444"));
    }

    public static String solution(String phone_number) {
        char[] array = phone_number.toCharArray();
        int length = array.length;
        for(int i = length-5;i>-1;i--){
            array[i]='*';
        }
        return new String(array);
    }
}
