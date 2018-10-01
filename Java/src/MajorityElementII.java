import java.util.ArrayList;
import java.util.List;

public class MajorityElementII {
	public List<Integer> majorityElement(int[] nums) {
        List<Integer> res = new ArrayList<Integer>();
        
        int a = Integer.MIN_VALUE, b = Integer.MIN_VALUE, countA = 0, countB = 0;
        
        for(int i : nums) {
        	if(countA != 0 && i == a) {
        		countA++;
        	}else if(countB != 0 && i == b) {
        		countB++;
        	}else {
        		if(countA == 0) {
        			a = i;
        			countA++;
        		}else if(countB == 0) {
        			b = i;
        			countB++;
        		}else {
        			countA--;
        			countB--;
        		}
        	}
        }
        
        int counta = 0;
        int countb = 0;
        
        for(int i : nums) {
        	if(countA > 0 && i == a) counta++;
        	if(countB > 0 && i == b) countb++;
        }
        
        if(counta > nums.length / 3) res.add(a);
        if(countb > nums.length / 3) res.add(b);
        return res;
    }
	
	public static void main(String[] args) {
		MajorityElementII test = new MajorityElementII();
		int[] nums = {3,3,2};
		test.majorityElement(nums);
	}
}
