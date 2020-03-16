import java.util.Arrays;

public class NumberofLongestIncreasingSubsequence{

    public int findNumberOfLIS(int[] nums) {
        int[] len = new int[nums.length];
        int[] count = new int[nums.length];

        int max = 1;
        Arrays.fill(len, 1);
        Arrays.fill(count, 1);

        for(int i = 1; i < nums.length; i++){
            int maxLen = 1;
            int c = 1;
            for(int j = i-1; j >= 0; j--){
                if(nums[j] < nums[i]){
                    if(len[j]+1 > maxLen){
                        maxLen = len[j]+1;
                        c = count[j];
                    }else if(len[j]+1 == maxLen){
                        c += count[j];
                    }
                }
            }
            max = Math.max(max, maxLen);
            len[i] = maxLen;
            count[i] = c;
        }
        int res = 0;
        for(int i = 0; i < nums.length; i++){
            if(len[i] == max){
                res += count[i];
            }
        }
        return res;
    }

    public static void main(String[] args) {
        NumberofLongestIncreasingSubsequence test = new NumberofLongestIncreasingSubsequence();
        int[] nums = {2,2,2,2,2};
        System.out.print(test.findNumberOfLIS(nums));
    }

}