package programmers.p2;

public class P2_17687 {
    public static void main(String[] args) {
        System.out.println(solution(2, 4, 2, 1));
        System.out.println(solution(16, 16, 2, 1));
        System.out.println(solution(16, 16, 2, 2));

        //time Test
        long startTime = System.currentTimeMillis();
        System.out.println(solution(2, 1000000, 10, 1));
        long endTime = System.currentTimeMillis();
        long startTime2 = System.currentTimeMillis();
        System.out.println(solution2(2, 1000000, 10, 1));
        long endTime2 = System.currentTimeMillis();
        System.out.println(endTime - startTime);
        System.out.println(endTime2 - startTime2);

    }
    public static String solution(int n, int t, int m, int p) {
        StringBuffer sb = new StringBuffer();
        int value = 0;
        int personIdx = p - 1;
        for (int count = 0; count < t; ) {
            String s = Integer.toString(value++, n);
            int length = s.length();
            for (int i = personIdx; i < length && count < t; i += m) {
                sb.append(s.charAt(i));
                count++;
            }
            personIdx = (m + personIdx - (length % m)) % m;
        }
        return sb.toString().toUpperCase();
    }
    public static String solution2(int n, int t, int m, int p) {//maybe slow
        StringBuilder sb = new StringBuilder();
        int value = 0;
        int personIdx = 0;
        for (int count = 0; count < t; ) {
            String s = Integer.toString(value++, n);
            int length = s.length();
            for (int i = 0; i < length && count < t; i++) {
                if (personIdx++ % m == p - 1) {
                    sb.append(s.charAt(i));
                    count++;
                }
            }
        }
        return sb.toString().toUpperCase();
    }

}
