import java.util.Arrays;

public class PathSumIV {
    
    public int pathSum(int[] nums) {
        if(nums.length == 0) return 0;
        if(nums.length == 1) return nums[0]%10;
        int[][] arr = new int[4][8];
        for(int i = 0; i < arr.length; i++) {
            Arrays.fill(arr[i], Integer.MIN_VALUE);
        }
        int maxR = 0;
        for(int i : nums) {
            int v = i%10;
            i = i / 10;
            int c = i % 10 - 1;
            i = i / 10;
            int r = i % 10 - 1;
            arr[r][c] = v;
            
            maxR = Math.max(maxR, r);
        }
        
        int res = 0;
        for(int i = 1; i < 4; i++) {
            for(int j = 0; j < 8; j++) {
                if(arr[i][j] != Integer.MIN_VALUE) {
                    arr[i][j] += arr[i-1][j/2];
                    if(i == maxR 
                            || (arr[i+1][2*j] == Integer.MIN_VALUE 
                            && arr[i+1][2*j+1] == Integer.MIN_VALUE)) 
                        res+=arr[i][j];
                }
                
            }
        }
        return res;
    }
    
    public static void main(String[] args) {
        int[] nums = {111,217,221,315,415};
        PathSumIV test = new PathSumIV();
        test.pathSum(nums);
    }
    
    
}
