import java.util.ArrayList;
import java.util.List;

public class SummaryRanges {
	
	public List<String> summaryRanges(int[] nums) {
		List<String> result = new ArrayList<String>();
		if(nums.length == 0) return result;
        boolean inRange = false;
        String currentStr = "";
        for(int i = 0; i < nums.length - 1; i++) {
        	if(nums[i] == nums[i+1] - 1) {
        		if(inRange) {
        			continue;
        		}else {
        			inRange = true;
        			currentStr = ""+nums[i];
        		}
        	}else {
        		if(inRange) {
        			currentStr = currentStr + "->" + nums[i];
        		}else {
        			currentStr = "" + nums[i];
        		}
        		result.add(currentStr);
        		inRange = false;
        	}

        }
        
        if(inRange) {
        	currentStr = currentStr + "->" + nums[nums.length-1];
        	result.add(currentStr);
        }else {
        	result.add(""+nums[nums.length-1]);
        }
        	
        
        return result;

    }
	
	public static void main(String[] args) {
		SummaryRanges test = new SummaryRanges();
		int[] nums = {0,1,2,4,5,7};
		
		List<String> result = test.summaryRanges(nums);
		for(String str: result) {
			System.out.println(str);
		}
		
	}
	
}
