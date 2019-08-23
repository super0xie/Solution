public class DecreaseElementsToMakeArrayZigzag{

    public int movesToMakeZigzag(int[] nums) {
        int a = 0;
        int b = 0;

        for(int i = 1; i < nums.length; i += 2){
            int min = Integer.MAX_VALUE;
            if(i-1 >= 0) min = Math.min(min, nums[i-1]);
            if(i+1 < nums.length) min = Math.min(min, nums[i+1]);
            if(nums[i] >= min) a += nums[i]-min+1;
        }

        for(int i = 0; i < nums.length; i += 2){
            int min = Integer.MAX_VALUE;
            if(i-1 >= 0) min = Math.min(min, nums[i-1]);
            if(i+1 < nums.length) min = Math.min(min, nums[i+1]);
            if(nums[i] >= min) b += nums[i]-min+1;
        }

        return Math.min(a, b);
    }

    public static void main(String[] args) {
        DecreaseElementsToMakeArrayZigzag test = new DecreaseElementsToMakeArrayZigzag();
        int[] nums = {3,1,7,4,4,1,1,10,10,9};
        System.out.print(test.movesToMakeZigzag(nums));

    }
}