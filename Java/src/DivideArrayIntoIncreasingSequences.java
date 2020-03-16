public class DivideArrayIntoIncreasingSequences{

    public boolean canDivideIntoSubsequences(int[] nums, int K) {
        int maxCount = 0;
        for(int i = 0; i < nums.length; i++){
            int j = i;
            while(j < nums.length && nums[j] == nums[i]) j++;
            maxCount = Math.max(maxCount, j-i);
            i = j-1;
        }
        if(nums.length >= maxCount * K) return true;
        return false;
    }

    public static void main(String[] args) {
        DivideArrayIntoIncreasingSequences test = new DivideArrayIntoIncreasingSequences();
        int[] nums = {5,6,6,7,8};
        System.out.println(test.canDivideIntoSubsequences(nums, 3));
    }

}