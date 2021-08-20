package programmers.p1;

import java.util.ArrayList;

public class P1_64061 {
    public static void main(String[] args) {
        System.out.println(solution(new int[][]{{0,0,0,0,0},{0,0,1,0,3},{0,2,5,0,1},{4,2,4,4,2}, {3,5,1,3,1}}, new int[]{1,5,3,5,1,2,1,4}));
    }


    public static int columnChecker(int[][] board, int pos){
        int result = -1;
        int size = board.length;
        for(int i=0;i<size;i++){
            if(board[i][pos-1]!=0){
                result = board[i][pos-1];
                board[i][pos-1] = 0;
                return result;
            }
        }
        return result;
    };

    public static int solution(int[][] board, int[] moves) {
        int answer = 0;
        int score=0;
        ArrayList<Integer> basket = new ArrayList<>();
        for(int i =0;i<moves.length;i++){
            int checked = columnChecker(board,moves[i]);
            if(checked>0){
                if(basket.size()>0){
                    if(basket.get(basket.size()-1)==checked){
                        basket.remove(basket.size()-1);
                        score+=2;
                    }else{
                        basket.add(checked);
                    }
                }else if(basket.size()==0){
                    basket.add(checked) ;
                }
            };
        }
        return score;
    }
}
