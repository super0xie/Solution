import java.util.ArrayList;
import java.util.HashMap;

public class ParseLispExpression {
	
	public int evaluate(String exp) {
        return helper(exp.substring(1, exp.length()-1), new HashMap<>());
    }
	
	private int helper(String exp, HashMap<String, Integer> var) {
		String[] strs = exp.split(" ", 2);
		
		if(strs[0].equals("add") || strs[0].equals("mult")) {
			ArrayList<Integer> nums = new ArrayList<Integer>();
			for(int i = 0; i < strs[1].length(); i++) {
				if(strs[1].charAt(i) == '(') {
					int j = i+1;
					int count = 1;
					
					for(; j < strs[1].length(); j++) {
						if(strs[1].charAt(j) == '(') count++;
						else if(strs[1].charAt(j) == ')') {
							count--;
							if(count == 0) break;
						}
					}
					
					nums.add(helper(strs[1].substring(i+1, j), var));
					
					i = j+1;
				}else if((strs[1].charAt(i) >= '0' && strs[1].charAt(i) <= '9') || strs[1].charAt(i) == '-') {
					int j = i+1;
					while(j < strs[1].length() && strs[1].charAt(j) >= '0' && strs[1].charAt(j) <= '9') j++;
					nums.add(Integer.parseInt(strs[1].substring(i, j)));
					i = j;
				}else {
					int j = i;
					while(j < strs[1].length() && strs[1].charAt(j) != ' ') j++;
					nums.add(var.get(strs[1].substring(i, j)));
					i = j;
				}
			}
			
			if(strs[0].equals("add")) return nums.get(0) + nums.get(1);
			else return nums.get(0) * nums.get(1);
		}else {
			//put
			HashMap<String, Integer> cp = new HashMap<>();
			for(String k : var.keySet()) {
				cp.put(k, var.get(k));
			}
			
			int end = strs[1].length()-1;
			String last = null;
			if(strs[1].charAt(strs[1].length()-1) == ')') {
				int i = end-1;
				int count = -1;
				while(i >= 0) {
					if(strs[1].charAt(i) == ')') count--;
					else if(strs[1].charAt(i) == '(') {
						count++;
						if(count == 0) break;
					}
					i--;
				}
				
				last = strs[1].substring(i+1, strs[1].length()-1);
				end = i-1;
			}else {
				while(strs[1].charAt(end) != ' ') end--;
				last = strs[1].substring(end+1, strs[1].length());
			}
			
			
			for(int i = 0; i < end; i++) {
				int j = i;
				while(j < strs[1].length() && strs[1].charAt(j) != ' ') j++;
				String key = strs[1].substring(i, j);
				
				i = j+1;
				
				if(strs[1].charAt(i) == '(') {
					j = i+1;
					int count = 1;
					
					for(; j < strs[1].length(); j++) {
						if(strs[1].charAt(j) == '(') count++;
						else if(strs[1].charAt(j) == ')') {
							count--;
							if(count == 0) break;
						}
					}
					
					int val = helper(strs[1].substring(i+1, j), cp);
					cp.put(key, val);
					i = j+1;
					
				}else if((strs[1].charAt(i) >= '0' && strs[1].charAt(i) <= '9') || strs[1].charAt(i) == '-') {
					j = i+1;
					while(j < strs[1].length() && strs[1].charAt(j) >= '0' && strs[1].charAt(j) <= '9') j++;
					int val = Integer.parseInt(strs[1].substring(i, j));
					
					cp.put(key, val);
					i = j;
				}else if(strs[1].charAt(i) >= 'a' && strs[1].charAt(i) <= 'z') {
					j = i;
					while(j < strs[1].length() && strs[1].charAt(j) != ' ') j++;
					int val = cp.get(strs[1].substring(i, j));
					
					cp.put(key, val);
					i = j;
				}
				
			}
			
			if(strs[1].charAt(strs[1].length()-1) == ')') {
				return helper(last ,cp);
			}else {
				if((last.charAt(0) >= 0 && last.charAt(0) <= '9') || last.charAt(0) == '-') return Integer.parseInt(last);
				return cp.get(last);
			}
			
		}
		
	}
	
	public static void main(String[] args) {
		ParseLispExpression test = new ParseLispExpression();
		System.out.println(test.evaluate("(let x -2 y x y)"));
	}
	
	
	
	
	
	
}
