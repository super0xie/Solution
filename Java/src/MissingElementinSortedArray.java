public class MissingElementinSortedArray{

    public int missingElement(int[] nums, int k) {
        for(int i = 1; i < nums.length; i++){
            int diff = nums[i]-nums[i-1]-1;
            if(k <= diff) return nums[i-1] + k;
            else{
                k -= diff;
            }
        }
        return nums[nums.length-1] + k;
    }

    public static void main(String[] args) {
        int[] nums = {1,2,4};
        MissingElementinSortedArray test = new MissingElementinSortedArray();
        System.out.println(test.missingElement(nums, 3));
    }

}