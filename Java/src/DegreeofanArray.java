
public class DegreeofanArray {
    
    public int findShortestSubArray(int[] nums) {
        int[] indice = new int[50000];
        int[] count = new int[50000];
        
        int max = Integer.MIN_VALUE;
        int res = Integer.MAX_VALUE;
        for(int i = 0; i < nums.length; i++) {
            if(count[nums[i]] == 0) {
                indice[nums[i]] = i;
            }
            count[nums[i]]++;
            if(count[nums[i]] > max) {
                max = count[nums[i]];
                res = i - indice[nums[i]] + 1;
            }else if(count[nums[i]] == max) {
                res = Math.min(res, i - indice[nums[i]] + 1);
            }
        }
        
        return res;
        
    }
}
