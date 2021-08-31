package programmers.p2;



import java.io.Serializable;
import java.util.*;

public class P2_49994 {
    public static void main(String[] args) {
        System.out.println(solution("ULURRDLLU"));
        System.out.println(solution("LULLLLLLU"));
    }

    class Pair implements Serializable {
        final int key;
        final int value;

        public Pair(int a, int b) {
            key = a;
            value = b;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Pair pair = (Pair) o;
            return key == pair.key && value == pair.value;
        }

        @Override
        public int hashCode() {
            return Objects.hash(key, value);
        }
    }

    public static int solution(String dirs) {
        int answer = 0;
        char[] dir = dirs.toCharArray();
        HashSet<Set<Pair>> pointSet = new HashSet<>();
        int x = 0;
        int y = 0;
        HashSet<Pair> set;
        for (char direction : dir) {
            switch (direction) {
                case 'L':
                    if (x == -5)
                        continue;
                    set = new HashSet(Arrays.asList(new Pair(x, y), new Pair(--x, y)));
                    if (pointSet.add(set))
                        answer++;
                    break;
                case 'R':
                    if (x == 5)
                        continue;
                    set = new HashSet(Arrays.asList(new Pair(x, y), new Pair(++x, y)));
                    if (pointSet.add(set))
                        answer++;
                    break;
                case 'D':
                    if (y == -5)
                        continue;
                    set = new HashSet(Arrays.asList(new Pair(x, y), new Pair(x, --y)));
                    if (pointSet.add(set))
                        answer++;
                    break;
                case 'U':
                    if (y == 5)
                        continue;
                    set = new HashSet(Arrays.asList(new Pair(x, y), new Pair(x, ++y)));
                    if (pointSet.add(set))
                        answer++;
                    break;
                default:
            }
        }
        return answer;
    }
//    public static int solution2(String dirs) {
//        int answer = 0;
//        char[] dir = dirs.toCharArray();
//        HashSet<Pair<Pair<Integer, Integer>, Pair<Integer, Integer>>> pointSet = new HashSet<>();
//        int x = 0;
//        int y = 0;
//        for (char direction : dir) {
//            switch (direction) {
//                case 'L':
//                    if (x == -5)
//                        continue;
//                    if (pointSet.add(new Pair(new Pair(x, y),new Pair(--x, y))))
//                        answer++;
//                    break;
//                case 'R':
//                    if (x == 5)
//                        continue;
//                    if (pointSet.add(new Pair(new Pair(x, y),new Pair(++x, y))))
//                        answer++;
//                    break;
//                case 'D':
//                    if (y == -5)
//                        continue;
//                    if (pointSet.add(new Pair(new Pair(x, y),new Pair(x, --y))))
//                        answer++;
//                    break;
//                case 'U':
//                    if (y == 5)
//                        continue;
//                    if (pointSet.add(new Pair(new Pair(x, y),new Pair(x, ++y))))
//                        answer++;
//                    break;
//                default:
//            }
//        }
//        return answer;
//    }
}
