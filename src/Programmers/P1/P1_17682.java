package Programmers.P1;

import java.util.Arrays;
import java.util.regex.Pattern;

public class P1_17682 {
    public static void main(String[] args) {
        System.out.println(solution("1S2D*3T"));
        System.out.println(solution("1D2S#10S"));
    }

    public static int solution(String dartResult) {
        String[] array = dartResult.split("");
        int length = array.length;
        int result[] = new int[3];
        int resultIdx = 0;

        for (int i = 0; i < length;) {
            int value = 0;
            if (Pattern.matches("[1-9]", array[i]))
                if (array[i].equals("1")) {
                    if (array[i + 1].equals("0")) {
                        value = 10;
                        i++;
                    } else {
                        value = 1;
                    }
                } else {
                    value = Integer.parseInt(array[i]);
                }
            i++;
            switch (array[i++]) {
                case "D":
                    value = (int) Math.pow(value,2);
                    break;
                case "T":
                    value = (int) Math.pow(value,3);
                    break;
                default:
            }
            if(i<length)
                switch (array[i++]) {
                    case "*":
                        value *= 2;
                        if (resultIdx > 0) {
                            result[resultIdx - 1] = result[resultIdx - 1] * 2;
                        }
                        break;
                    case "#":
                        value *= -1;
                        break;
                    default:
                        i--;
                }
            result[resultIdx] = value;
            resultIdx++;
        }
        return Arrays.stream(result).sum();
    }
}
