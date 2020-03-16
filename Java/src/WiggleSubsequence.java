public class WiggleSubsequence{

    public int wiggleMaxLength(int[] nums) {
        if(nums.length < 2) return nums.length;
        int i = 0;
        while(i < nums.length-1 && nums[i] == nums[i+1]) i++;
        if(i == nums.length-1) return 1;

        boolean inc;
        if(nums[i] < nums[i+1]) inc = true;
        else inc = false;

        int count = 2;
        // int cur = nums[i+1];
        for(int j = i+1; j < nums.length-1; j++){
            if(inc && nums[j] > nums[j+1]){
                inc = false;
                count++;
            }else if(!inc && nums[j] < nums[j+1]){
                inc = true;
                count++;
            }
        }

        return count;
    }
    
    public static void main(String[] args) {
        int[] nums = {3,3,3,2,5};
        int[][] cache = new int [10000][10000];
        WiggleSubsequence test = new WiggleSubsequence();
        System.out.print(test.wiggleMaxLength(nums));
    }
}