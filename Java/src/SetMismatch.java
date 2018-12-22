
public class SetMismatch {
    
    public int[] findErrorNums(int[] nums) {
        int[] res = new int[2];
        int[] set = new int[nums.length];
        int sum = 0;
        for(int i : nums) {
            if(set[i-1] != 0) res[0] = i;
            else set[i-1] = i;
            
            sum += i;
        }
        
        int tar = (1 + nums.length) * nums.length / 2;
        int diff = tar - sum;
        res[1] = res[0] + diff;
        
        return res;
    }
    
}
