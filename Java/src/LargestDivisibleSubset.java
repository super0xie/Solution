
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class LargestDivisibleSubset {

    public List<Integer> largestDivisibleSubset(int[] nums) {
        if(nums.length == 0) return new LinkedList<>();
        Arrays.sort(nums);
        int[] dp = new int[nums.length];
        int[] pre = new int[nums.length];
        Arrays.fill(dp, 1);
        Arrays.fill(pre, -1);
        int max = 1;
        int maxIdx = 0;

        for(int i = 1; i < nums.length; i++){
            for(int j = i-1; j >= 0; j--){
                if(nums[i] % nums[j] == 0){
                    if(dp[j]+1 > dp[i]) {
                        dp[i] = dp[j]+1;
                        pre[i] = j;
                        if(dp[i] > max){
                            max = dp[i];
                            maxIdx = i;
                        }
                    }
                }
            }
        }

        LinkedList<Integer> res = new LinkedList<>();
        res.addFirst(nums[maxIdx]);
        maxIdx = pre[maxIdx];
        while(maxIdx != -1){
            res.addFirst(nums[maxIdx]);
            maxIdx = pre[maxIdx];
        }
        return res;
    }

    public static void main(String[] args) {
        int[] nums = {1};
        LargestDivisibleSubset test = new LargestDivisibleSubset();
        List<Integer> res = test.largestDivisibleSubset(nums);
        for(int i : res) System.out.print(i + ", ");
    }

}
