package programmers.p0;

import java.util.Arrays;

public class P120876 {
    public static void main(String[] args) {

        solution(new int[][]{{0, 5}, {3, 9}, {1, 10}});
    }

    public static int solution(int[][] lines) {
        short[] table = new short[200];
        short max = 2;
        for (int[] array : lines) {
            Arrays.sort(array);
            int start = array[0] + 99;
            int end = array[1] + 99;
            for (int i = start; i < end; i++) {
                if (table[i] != max) table[i]++;
            }
        }
        int answer = 0;
        for (short s : table) {
            if (s == max) {
                answer++;
            }
        }
        return answer;
    }

}

//    val table = ShortArray(200)
//    val max = 2.toShort()
//    lines.map { it.sorted() }.forEach { (a, b) ->
//            val start = a.coerceAtMost(b)
//            val end = a.coerceAtLeast(b)
//            (start + 99 until end + 99).forEach {
//            if (table[it] != max)
//            table[it]++
//            }
//            }
//            return table.count { it == max }
