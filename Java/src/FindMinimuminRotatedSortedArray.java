
public class FindMinimuminRotatedSortedArray {
    
    public int findMin(int[] nums) {
        int start = 0;
        int end = nums.length - 1;
        int mid = 0;
        
        
        while(start <= end) {
            mid = start + (end - start) / 2;
            
            if((mid == 0 && nums[mid] <= nums[nums.length-1]) || (mid != 0 && nums[mid] < nums[mid - 1])) return nums[mid];
            //mid at left of break point
            if(nums[mid] > nums[nums.length-1]) {
                start = mid + 1;
            }else{
                end = mid - 1;
            }
        }
        return -1;

    }
    
    public static void main(String[] args) {
        FindMinimuminRotatedSortedArray test = new FindMinimuminRotatedSortedArray();
        
        int[] nums = {2, 1};
        
        System.out.println(test.findMin(nums));
        
    }

}
