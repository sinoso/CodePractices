package programmers.p3;

import java.util.Arrays;

public class P3_12927 {
    public static void main(String[] args) {
        System.out.println(solution(5, new int[]{4, 3, 3}));
        System.out.println(solution(5, new int[]{4}));
        System.out.println(solution(12, new int[]{4, 5}));
        System.out.println(solution(0, new int[]{4, 5}));
    }

    public static long solution(int n, int[] works) { // works를 정렬해서 뒷 인덱스부터 1씩 빼서 내려감.
        Arrays.sort(works); // works를 정렬-> [3,4,1,2,4]->[1,2,3,4,4]
        int lastIndex = works.length - 1;
        int index = lastIndex; //가장 큰 수 부터 시작
        int targetValue = 0;
        int left = n;//남은 시간
        while (left != 0) { //시간이 남은동안은 반복
            if (index == lastIndex) {// 현재 인덱스가 마지막인덱스인가? == 남은 works중 가장 큰수
                targetValue = works[index];// 줄어들 숫자
                if (targetValue == 0)// 만약 0이면 종료
                    break;
                works[index]--;
                if (index > 0) //인덱스가 0보다 크다면 -> lastIndex>0 -> works의 원소 갯수 1개 이상
                    index--;
                left--;
                continue;
            }
            if (works[index] < targetValue) { // ex works[3,3,3], index 1, target 4
                index = lastIndex;// 현재 인덱스를 마지막인덱스로 교체
                continue;
            }
            works[index]--;
            if (index == 0)// 현재 인덱스가 0 이라면 마지막 인덱스로 교체
                index = lastIndex;
            else
                index--;
            left--;
        }
        return Arrays.stream(works).mapToLong(v -> (long)v * v).reduce(Long::sum).getAsLong();
    }

}
