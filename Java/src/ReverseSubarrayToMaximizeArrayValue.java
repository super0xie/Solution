
public class ReverseSubarrayToMaximizeArrayValue {
	
	public int maxValueAfterReverseOld(int[] nums) {
        int maxDiff = Integer.MIN_VALUE;
        
        for(int i = 0; i < nums.length-1; i++) {
        	for(int j = 0; j < i-1; j++) {
        		int o = Math.abs(nums[i]-nums[i+1]) + Math.abs(nums[j]-nums[j+1]);
        		int n = Math.abs(nums[i]-nums[j]) + Math.abs(nums[i+1]-nums[j+1]);
        		maxDiff = Math.max(maxDiff, n-o);
        	}
        }
        for(int i = 1; i < nums.length-1; i++) {
        	int o = Math.abs(nums[i]-nums[i+1]);
        	int n = Math.abs(nums[0]-nums[i+1]);
        	maxDiff = Math.max(maxDiff, n-o);
        }
        
        int res = 0;
        for(int i = 0; i < nums.length-1; i++) {
        	res += Math.abs(nums[i]-nums[i+1]);
        }
        res += maxDiff;
        
        return res;
    }
	
	public int maxValueAfterReverse(int[] n) {
        int maxDiff = Integer.MIN_VALUE;
        
        int abs = Math.abs(n[0]-n[1]);
        int m1 = n[0]+n[1] - abs;
        int m2 = n[1]-n[0] - abs;
        int m3 = n[0]-n[1] - abs;
        int m4 = -n[0]-n[1] - abs;
        
        for(int i = 2; i < n.length-1; i++) {
        	int a = Math.abs(n[i]-n[i+1]);
        	int n1 = -n[i] - n[i+1] - a + m1;
        	int n2 = n[i] - n[i+1] - a + m2;
        	int n3 = -n[i] + n[i+1] - a + m3;
        	int n4 = n[i] + n[i+1] - a + m4;
        	
        	maxDiff = Math.max(maxDiff, n1);
        	maxDiff = Math.max(maxDiff, n2);
        	maxDiff = Math.max(maxDiff, n3);
        	maxDiff = Math.max(maxDiff, n4);
        	
        	int p = Math.abs(n[i]-n[i-1]);
        	m1 = Math.max(m1, n[i-1]+n[i] - p);
        	m2 = Math.max(m2, n[i-1]-n[i] - p);
            m3 = Math.max(m3, n[i-1]-n[i] - p);
            m4 = Math.max(m4, -n[i-1]-n[i] - p);
        }
        
        int res = 0;
        for(int i = 0; i < n.length-1; i++) {
        	res += Math.abs(n[i]-n[i+1]);
        }
        
        for(int i = 1; i < n.length-1; i++) {
        	int o = Math.abs(n[i]-n[i+1]);
        	int ne = Math.abs(n[0]-n[i+1]);

        	maxDiff = Math.max(maxDiff, ne-o);
        }
        
        
        res += maxDiff;
        
        return res;
    }
	
	
	
	public static void main(String[] args) {
		ReverseSubarrayToMaximizeArrayValue test = new ReverseSubarrayToMaximizeArrayValue();
		int[] nums = new int[] {2,5,1,3,4};
		System.out.println(test.maxValueAfterReverseOld(nums));
	}
	
}
