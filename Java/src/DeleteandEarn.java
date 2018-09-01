import java.util.TreeMap;

public class DeleteandEarn {
	
	public int deleteAndEarn(int[] nums) {
		if(nums.length == 0) return 0;
		TreeMap<Integer, Integer> map = new TreeMap<Integer, Integer>();
        
        for(int num : nums) {
        	map.merge(num, 1, Integer::sum);
        }
        
        int [] keys = new int[map.keySet().size()];
        int i = 0;
        
        for(int key : map.keySet()) {
        	keys[i++] = key;
        }
        
        int [] adp = new int [keys.length];
        int [] bdp = new int [keys.length];
        
        
        adp[0] = keys[0] * map.get(keys[0]);
        
        for(i = 1; i < keys.length; i++) {
        	if(keys[i-1] == keys[i] - 1) {
        		adp[i] = bdp[i-1] + keys[i] * map.get(keys[i]);
        	}else {
        		adp[i] = Math.max(adp[i-1], bdp[i-1]) + keys[i] * map.get(keys[i]);
        	}
        	bdp[i] = Math.max(adp[i-1], bdp[i-1]);
        }
        
        return Math.max(adp[keys.length-1], bdp[keys.length-1]);
    }
	
	public static void main(String[] args) {
		int [] nums = {3,4,2};
		DeleteandEarn test = new DeleteandEarn();
		System.out.println(test.deleteAndEarn(nums));
	}
}
