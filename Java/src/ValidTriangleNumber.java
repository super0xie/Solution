import java.util.Arrays;

public class ValidTriangleNumber {
    
    
    public int triangleNumber(int[] nums) {
        int res = 0;
        Arrays.sort(nums);
        
        for(int i = 0; i < nums.length-2; i++) {
            for(int j = i+1; j < nums.length-1; j++) {
                int upperBound = nums[i]+nums[j];
                int bs = Arrays.binarySearch(nums, upperBound);
                if(bs >= 0) {
                    while(bs > 0 && nums[bs] == nums[bs-1]) bs--;
                    if(bs-1 >= j+1) res += bs-1-j;
                }else {
                    int ip = -bs-1;
                    if(ip-1 >= j+1) res += ip-1-j;
                }
                
            }
        }
        
        return res;
    }
    

    public static void main(String[] args) {
        int[] nums = {2,2,3,4};
        
        ValidTriangleNumber test = new ValidTriangleNumber();
        System.out.println(test.triangleNumber(nums));
    }
    

}
