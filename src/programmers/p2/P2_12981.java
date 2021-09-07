package programmers.p2;

import java.util.*;

public class P2_12981 {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(solution(3, new String[]{"tank", "kick", "know", "wheel", "land", "dream", "mother", "robot", "tank"})));
        System.out.println(Arrays.toString(solution(5, new String[]{"hello", "observe", "effect", "take", "either", "recognize", "encourage", "ensure", "establish", "hang", "gather", "refer", "reference", "estimate", "executive"})));
        System.out.println(Arrays.toString(solution(2, new String[]{"hello", "one", "even", "never", "now", "world", "draw"})));
    }

    public static int[] solution(int n, String[] words) {
        int[] answer = {0, 0};
        HashSet<String> wordSet = new HashSet<>();
        char last = words[0].charAt(0);
        for (int i = 0; i < words.length; i++) {
            if (last != words[i].charAt(0) || !wordSet.add(words[i])) {
                answer[0] = i % n + 1;
                answer[1] = i / n + 1;
                break;
            }
            last = words[i].charAt(words[i].length() - 1);
        }
        return answer;
    }

}
