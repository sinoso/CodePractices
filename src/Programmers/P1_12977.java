package Programmers;
public class P1_12977 {
    public static void main(String[] args) {
        System.out.println(solution(new int[]{1,2,7,6,4}));
    }

    public static int solution(int[] nums) {
        int numsLength = nums.length;
        int result = 0;
        for(int i = 0 ;i<numsLength;i++){
            for(int j=i+1;j<numsLength;j++){
                for(int k = j+1;k<numsLength;k++){
                    int base = nums[i]+nums[j]+nums[k];
                    boolean flag = false;
                    if(base%2==0)
                        continue;
                    for(int l=3;l<base;l+=2){
                        if(base%l==0){
                            flag = true;
                            break;
                        }
                    }
                    if(!flag)
                        result++;
                }
            }
        }
        return result;
    }
}
