import java.util.ArrayList;
import java.util.List;

public class RestoreIPAddresses {
	public List<String> restoreIpAddresses(String s) {
        List<String> res = new ArrayList<>();
        List<String> aux = new ArrayList<>();
        helper(res, s, 0, aux);
        return res;
    }
	
	private void helper(List<String> res, String s, int idx, List<String> aux) {
		if(idx >= s.length()) return;
		
		if(aux.size() == 3) {
			int len = s.length()-idx;
			if(len > 3) return;
			if(s.charAt(idx) == '0' && len > 1) return;
			String sub = s.substring(idx, s.length());
			int num = Integer.parseInt(sub);
			if(num > 255) return;
			
			aux.add(sub);
			
			String oneRes = aux.get(0) + "." + aux.get(1) + "." + aux.get(2) + "." + aux.get(3);
			res.add(oneRes);
			
			aux.remove(aux.size()-1);
		}else {
			for(int j = idx; j < Math.min(idx+3, s.length()); j++) {
				int len = j-idx+1;
				if(s.charAt(idx) == '0' && len > 1) continue;
				
				String sub = s.substring(idx, j+1);
				int num = Integer.parseInt(sub);
				if(num > 255) continue;
				aux.add(sub);
				
				helper(res, s, j+1, aux);
				aux.remove(aux.size()-1);
			}
		}
	}
	
	public static void main(String[] args) {
		RestoreIPAddresses test = new RestoreIPAddresses();
		test.restoreIpAddresses("25525511135");
		
	}
}
