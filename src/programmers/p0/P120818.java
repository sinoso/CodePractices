package programmers.p0;

public class P120818 {
    public static void main(String[] args) {
        System.out.println(solution(150000));
    }

    public static int solution(int price) {
        if (price < 100_000)
            return price;
        if (price < 300_000)
            return (int) (price * 0.95);
        if (price < 500_000)
            return (int) (price * 0.9);
        return (int) (price * 0.8);
//        return (int) (price * 0.8);
    }

}
