package Programmers.P1;

import java.util.*;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class P1_72410 {
    public static void main(String[] args) {
//        System.out.println(solution("...!@BaT#*..y.abcdefghijklm"));
//        System.out.println(solution("z-+.^."));
        System.out.println(solution("-_.~!@#$%^&*()=+[{]}:?,<>/._-"));
//        System.out.println(solution("=.="));
//        System.out.println(solution("123_.def"));
//        System.out.println(solution("abcdefghijklmn.p"));
//        System.out.println(solution("b......@"));
    }

    public static String solution(String new_id) {
        String answer = new_id;
        //step 1
        answer = answer.toLowerCase();
        //step 2
        List<String> list = new ArrayList<>(Arrays.asList(answer.split("")));
        int listSize = list.size();
        for (int idx = 0; idx < listSize; idx++) {
            if (!Pattern.matches("[a-z0-9-_.]", list.get(idx)))
                list.set(idx, "*");
        }
        list = list.stream().filter(s -> !s.equals("*")).collect(Collectors.toList());
        //step 3
        int count = 0;
        listSize = list.size();
        for (int idx = 0; idx < listSize; idx++) {
            if (list.get(idx).equals(".")) {
                if (count > 0)
                    list.set(idx, "*");
                count++;
            } else
                count = 0;

        }
        list = list.stream().filter(s -> !s.equals("*")).collect(Collectors.toList());
        //step 4
        while (list.size()>0&&list.get(0).equals("."))
            list.remove(0);
        while (list.size()>0&&list.get(list.size() - 1).equals("."))
            list.remove(list.size() - 1);
        //step 5
        if (list.size() == 0)
            list.add("a");
        //step 6
        if (list.size() > 15) {
            list = list.subList(0, 15);
            if (list.get(list.size() - 1).equals("."))
                list.remove(list.size() - 1);
        }
        //step 7
        if (list.size() < 3)
            while (list.size() != 3) {
                list.add(list.get(list.size() - 1));
            }
        return String.join("", list);
    }
}
