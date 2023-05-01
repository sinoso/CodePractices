package leetcode.easy;

import java.util.*;
import java.util.stream.Collectors;

public class L58 {
    public static void main(String... args) {
        System.out.println(lengthOfLastWord("   fly me   to   the moon  "));
    }

    private static int lengthOfLastWord(String s) {
        return Arrays.stream(
                new StringBuffer(s)
                        .reverse()
                        .toString()
                        .split(" "))
                .filter(it-> !it.equals(""))
                .findFirst()
                .get()
                .length();
    }
}
