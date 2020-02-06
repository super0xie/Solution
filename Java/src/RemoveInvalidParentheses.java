import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class RemoveInvalidParentheses {
	
	public List<String> removeInvalidParentheses(String s) {
        int l = 0;
        int r = 0;
        ArrayList<Integer> li = new ArrayList<>();
        ArrayList<Integer> ri = new ArrayList<>();
        
        for(int i = 0; i < s.length(); i++) {
        	if(s.charAt(i) == '(') {
        		l++;
        		li.add(i);
        	} else if(s.charAt(i) == ')') {
        		ri.add(i);
        		if(l > 0) l--;
        		else r++;
        	}
        }
        HashSet<String> ret = new HashSet<>();
        dfs(l, r, 0, 0, li, ri, new boolean[s.length()], ret, s);
        List<String> res = new ArrayList<>();
        for(String str : ret) res.add(str);
        
        
        return res;
    }
	
	private void dfs(int l, int r, int ls, int rs, ArrayList<Integer> li, ArrayList<Integer> ri,
			boolean[] remove, HashSet<String> res, String s) {
		if(l > 0) {
			for(int i = ls; i < li.size()-l+1; i++) {
				int idx = li.get(i);
				remove[idx] = true;
				dfs(l-1, r, i+1, rs, li, ri, remove, res, s);
				remove[idx] = false;
			}
		}else if(r > 0) {
			for(int i = rs; i < ri.size()-r+1; i++) {
				int idx = ri.get(i);
				remove[idx] = true;
				dfs(l, r-1, ls, i+1, li, ri, remove, res, s);
				remove[idx] = false;
			}
		}else {
			int count = 0;
			StringBuilder sb = new StringBuilder();
			for(int i = 0; i < s.length(); i++) {
				if(!remove[i]) {
					if(s.charAt(i) == '(') count++;
					else if(s.charAt(i) == ')') count--;
					sb.append(s.charAt(i));
					if(count < 0) return;
				}
			}
			if(count != 0) return;
			res.add(sb.toString());
		}
	}
	
	public static void main(String[] args) {
		RemoveInvalidParentheses test = new RemoveInvalidParentheses();
		List<String> res = test.removeInvalidParentheses(")(");
		for(String str : res) System.out.println(str);
	}
	
}
