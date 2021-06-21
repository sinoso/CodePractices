package Programmers;

public class P1_17681 {
    public static void main(String[] args) {
        String[] result = solution(5, new int[]{9, 20, 28, 18, 11}, new int[]{30, 1, 21, 17, 28});
        for (String s : result)
            System.out.println(s);
    }

    public static String[] solution(int n, int[] arr1, int[] arr2) {
        String[] answer = new String[n];
        for (int i = 0; i < n; i++) {
            boolean[] line = new boolean[n];
            boolean[] line2 = new boolean[n];
            int v1 = arr1[i];
            int v2 = arr2[i];
            int pos = 0;
            while (v1 > 0) {
                int value = 1;
                for (int j = 0; j < n - pos; j++) {
                    value = value * 2;
                }
                if (v1 >= value) {
                    v1 = v1 - value;
                    line[pos - 1] = true;
                }
                pos++;
            }
            pos = 0;
            while (v2 > 0) {
                int value = 1;
                for (int j = 0; j < n - pos; j++) {
                    value = value * 2;
                }
                if (v2 >= value) {
                    v2 = v2 - value;
                    line[pos - 1] = true;
                }
                pos++;
            }
            StringBuilder sb = new StringBuilder();
            for (int k = 0; k < n; k++) {
                if (line2[k] | line[k])
                    sb.append("#");
                else
                    sb.append(" ");
            }
            answer[i] = sb.toString();
        }
        return answer;
    }
}
