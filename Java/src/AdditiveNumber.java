import java.util.ArrayList;
import java.util.List;

public class AdditiveNumber {
	
	public String addStrings(String num1, String num2) {
        int i = num1.length()-1;
        int j = num2.length()-1;
        int carry = 0;
        StringBuilder sb = new StringBuilder();
        
        while(i >= 0 || j >= 0) {
        	int sum = 0;
        	if(i >= 0 && j >= 0) {
        		sum = (int)(num1.charAt(i--) - '0') + (int)(num2.charAt(j--) - '0') + carry;
        	}else {
        		if(i >= 0) sum = (int)(num1.charAt(i--) - '0') + carry;
        		else sum = (int)(num2.charAt(j--) - '0') + carry;
        	}
        	
        	if(sum > 9) {
    			carry = 1;
    			sum = sum % 10;
    		}else {
    			carry = 0;
    		}
    		sb.append("" + sum);
        }
        
        if(carry > 0) sb.append("" + 1);
        return sb.reverse().toString();
        
    }
	
	public boolean isAdditiveNumber(String num) {
        return dfs(num, new ArrayList<String>(), 0);
    }
	
	private boolean dfs(String num, List<String> strs, int idx) {
		
		if(strs.size() >= 2) {
			String last = strs.get(strs.size()-1);
			String secLast = strs.get(strs.size()-2);
			int maxLen = Math.max(last.length(), secLast.length());
			if(maxLen > num.length()-idx) return false;
			String sum = addStrings(last, secLast);
			if(sum.length() > num.length() - idx) return false;
			
			for(int i = 0; i < sum.length(); i++) {
				if(sum.charAt(i) != num.charAt(idx + i)) return false;
			}
			
			if(idx + sum.length() >= num.length()) return true;
			strs.add(sum);
			boolean res = dfs(num, strs, idx+sum.length());
			strs.remove(strs.size()-1);
			return res;
		}else {
			int end = num.length();
			if(num.charAt(idx) == '0') 
				end = Math.min(num.length(), idx+2);
			for(int i = idx+1; i < end; i++) {
				String sub = num.substring(idx, i);
				strs.add(sub);
				boolean res = dfs(num, strs, i);
				strs.remove(strs.size()-1);
				if(res) return true;
			}
			
			return false;
		}
	}
	
	public static void main(String[] args) {
		AdditiveNumber test = new AdditiveNumber();
		System.out.println(test.isAdditiveNumber("101"));
	}
	
}
