package programmers.p2;

import java.util.*;

public class P2_12973_B {
    public static void main(String[] args) {
        System.out.println(solution("baabaacddcbaabaacddcbaabaacddcbaabaacddcbaabaacddcbaabaacddcbaabaacddcbaabaacddcbaabaacddcbaabaacddcbaabaacddcbaabaacddcbaabaacddcbaabaacddcbaabaacddcbaabaacddcbaabaacddcbaabaacddcbaabaacddcbaabaacddc"));
        System.out.println(solution("cdcd"));
    }
    public static int solution(String s) {
        int count;
        LinkedList<String> list =new LinkedList<String>(Arrays.asList(s.split("")));

        int lastPos = 0;
        String lastS = list.get(0);
        if (s.length() < 2 || s.length() % 2 == 1)
            return 0;

        do {
            count = 0;

            for (int index = 1; index < list.size(); index++) {
                if (lastS.equals(list.get(index))) {
                    count++;
                    list.remove(lastPos);
                    list.remove(index - 1);
                    break;
                } else {
                    lastS = list.get(index);
                    lastPos = index;
                }
            }
            if (list.size() > 0) {
                lastPos = 0;
                lastS = list.get(0);
            }
        } while (count != 0);

        if (list.size() == 0)
            return 1;
        else
            return 0;
    }

}
