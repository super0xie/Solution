import java.util.HashMap;
import java.util.Stack;

public class TernaryExpressionParser {
	
	
	
	private String helperOld(String s, int l, int r, HashMap<Integer, Integer> map) {
		if(r == l) return s.substring(l, l+1);
		
		int idx = 0;
		for(int i = l; i <= r; i++) {
			if(s.charAt(i) == '?') {
				idx = i;
				break;
			}
		}
		
		String cond = s.substring(l, idx);
		String r1 = helperOld(s, idx+1, map.get(idx)-1, map);
		String r2 = helperOld(s, map.get(idx)+1, r, map);
		
		if(cond.equals("T")) return r1;
		else return r2;
	}
	
	public String parseTernary(String e) {
		Stack<Integer> s = new Stack<>();
		HashMap<Integer, Integer> map = new HashMap<>();
		for(int i = 0; i < e.length(); i++) {
			if(e.charAt(i) == '?') s.push(i);
			else if(e.charAt(i) == ':') map.put(s.pop(), i);
		}
		
		int[] res = helper(e, 0, e.length()-1, map);
		return e.substring(res[0], res[1]);
    }
	
	private int[] helper(String s, int l, int r, HashMap<Integer, Integer> map) {
		if(r == l) return new int[] {l, l+1};
		
		int idx = 0;
		for(int i = l; i <= r; i++) {
			if(s.charAt(i) == '?') {
				idx = i;
				break;
			}
		}
		
		char cond = s.charAt(l);
		int[] r1 = helper(s, idx+1, map.get(idx)-1, map);
		int[] r2 = helper(s, map.get(idx)+1, r, map);
		
		if(cond == 'T') return r1;
		else return r2;
	}
	
	public static void main(String[] args) {
		TernaryExpressionParser test = new TernaryExpressionParser();
		System.out.println(test.parseTernary("T?T?F:5:3"));
	}
	
}
