package programmers.p1;
import java.util.Arrays;

public class P1_42576 {
    public static void main(String[] args) {
        System.out.println(solution(new String[]{"leo", "kiki", "eden"},new String[]{"eden", "kiki"}));
    }

    public static String solution(String[] participant, String[] completion) {
        int i;
        Arrays.sort(participant);
        Arrays.sort(completion);
        for(i = 0;i<completion.length;i++){
            if(!participant[i].equals(completion[i]))
                return participant[i];
        }
        return participant[participant.length-1];
    }
}
