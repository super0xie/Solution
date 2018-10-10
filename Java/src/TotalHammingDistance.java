
public class TotalHammingDistance {
    
    public int totalHammingDistanceTLE(int[] nums) {
        int res = 0;
        for(int i = 0; i < nums.length; i++) {
            for(int j = i+1; j < nums.length; j++) {
                res += hamming(nums[i], nums[j]);
            }
        }
        return res;
    }
    
    public int totalHammingDistance(int[] nums) {
        int res = 0;
        boolean hasNonZero = true;
        
        while(hasNonZero) {
            
            hasNonZero = false;
            int count1 = 0;
            int count0 = 0;
            for(int i = 0; i < nums.length; i++) {
                if(nums[i] % 2 == 1) count1++;
                else count0++;
                nums[i] = nums[i] >> 1;
                if(nums[i] > 0) hasNonZero = true;
            }
            res += count1 * count0;
        }
        
        return res;
    }
    
    private int hamming(int a, int b) {
        int res = 0;
        while(a > 0 || b > 0) {
            res += (a%2 == b%2) ? 0 : 1;
            a = a >> 1;
            b = b >> 1;
        }
        return res;
    }
    
    public static void main(String[] args) {
        TotalHammingDistance test = new TotalHammingDistance();
        int[] nums = {4, 14, 2};
        System.out.println(test.totalHammingDistance(nums));
    }
}
