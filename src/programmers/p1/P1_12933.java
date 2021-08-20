package programmers.p1;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class P1_12933 {
    public static void main(String[] args) {
        System.out.println(solution(118372));
    }

    public static long solution(long n) {
        List<Long> list = new ArrayList<>();
        long temp;
        while(n>0){
            temp = n%10;
            list.add(temp);
            n = n/10;
        }
        Collections.sort(list);
        int size = list.size();
        temp = 0L;
        for(int i = size-1;i>=0;i--){
            temp*=10;
            temp+=list.get(i);
        }
        return temp;
    }
}
