import java.util.HashMap;

public class CanIWin {
	
	public boolean canIWin(int maxChoosableInteger, int desiredTotal) {
		int sum = (1+maxChoosableInteger)*maxChoosableInteger/2;
		if(sum < desiredTotal) return false;
		
        boolean[] chosen = new boolean[maxChoosableInteger+1];
        HashMap<String, Boolean> mem = new HashMap<String, Boolean>();
        return dfs(chosen, desiredTotal, mem);
    }
	
	private String encode(boolean[] chosen) {
		StringBuilder sb = new StringBuilder();
		for(int i = 1; i < chosen.length; i++) {
			if(chosen[i]) sb.append(1);
			else sb.append(0);
		}
		return sb.toString();
	}
	
	private boolean dfs(boolean[] chosen, int left, HashMap<String, Boolean> mem) {
		String encode = encode(chosen);
		if(mem.containsKey(encode)) return mem.get(encode);
		
		for(int i = chosen.length-1; i > 0; i--) {
			if(!chosen[i] && i >= left) return true;
		}
		boolean ret = false;
		for(int i = 1; i < chosen.length; i++) {
			if(!chosen[i]) {
				chosen[i] = true;
				boolean res = dfs(chosen, left - i, mem);
				chosen[i] = false;
				if(!res) {
					ret = true;
					break;
				}
			}
		}
		mem.put(encode, ret);
		return ret;
	}
	
	public static void main(String[] args) {
		CanIWin test = new CanIWin();
		System.out.println(test.canIWin(5, 50));
	}
	
}
