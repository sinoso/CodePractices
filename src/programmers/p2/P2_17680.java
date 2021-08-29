package programmers.p2;


import java.util.LinkedList;

public class P2_17680 {
    public static void main(String[] args) {
        System.out.println(solution(3, new String[]{"Jeju", "Pangyo", "Seoul", "NewYork", "LA", "Jeju", "Pangyo", "Seoul", "NewYork", "LA"}));
        System.out.println(solution(3, new String[]{"Jeju", "Pangyo", "Seoul", "Jeju", "Pangyo", "Seoul", "Jeju", "Pangyo", "Seoul"}));
        System.out.println(solution(2, new String[]{"Jeju", "Pangyo", "Seoul", "NewYork", "LA", "SanFrancisco", "Seoul", "Rome", "Paris", "Jeju", "NewYork", "Rome"}));
        System.out.println(solution(5, new String[]{"Jeju", "Pangyo", "Seoul", "NewYork", "LA", "SanFrancisco", "Seoul", "Rome", "Paris", "Jeju", "NewYork", "Rome"}));
        System.out.println(solution(2, new String[]{"Jeju", "Pangyo", "NewYork", "newyork"}));
        System.out.println(solution(0, new String[]{"Jeju", "Pangyo", "Seoul", "NewYork", "LA"}));
    }

    public static int solution(int cacheSize, String[] cities) {
        if (cacheSize == 0)
            return cities.length * 5;
        int answer = 0;
        LinkedList<String> lru = new LinkedList<>();
        for (String city : cities) {
            String cityLow = city.toLowerCase();
            if (lru.contains(cityLow)) {
                lru.remove(cityLow);
                lru.add(0, cityLow);
                answer++;
                continue;
            }
            answer += 5;
            if (lru.size() > cacheSize - 1)
                lru.removeLast();
            lru.add(0, cityLow);
        }
        return answer;
    }

}
