
public class FindPeakElement {
    
    
    public int findPeakElement(int[] nums) {
        if(nums.length == 1) return 0;
        
        int length = nums.length;
        if(nums[0] > nums[1]) return 0;
        if(nums[length-1] > nums[length-2]) return length-1;
        
        int start = 1;
        int end = length-2;
        
        
        while(start <= end) {
            int mid = start + (end - start) / 2;
            if(nums[mid] > nums[mid-1] && nums[mid] > nums[mid+1]) return mid;
            else if(nums[mid] < nums[mid+1] && nums[mid] > nums[mid-1]) start = mid+1;
            else if(nums[mid] > nums[mid+1] && nums[mid] < nums[mid-1]) end = mid-1;
            else end = mid-1;
        }
        return -1;
    }
    
    
    public static void main(String[] args) {
        FindPeakElement test = new FindPeakElement();
        
        int[] nums = {3,4,3,2,1};
        System.out.println(test.findPeakElement(nums));
        
    }

}
