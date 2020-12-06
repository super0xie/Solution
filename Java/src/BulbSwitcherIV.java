
public class BulbSwitcherIV {
	
	public int minFlipsOld(String target) {
        return helper(target, true, 0);
    }
	
	private int helper(String s, boolean flag, int i) {
		if(i == s.length()) return 0;
		if(flag) {
			if(s.charAt(i) == '0') return helper(s, flag, i+1);
			else return 1+helper(s, !flag, i+1);
		}else {
			if(s.charAt(i) == '1') return helper(s, flag, i+1);
			else return 1+helper(s, !flag, i+1);
		}
	}
	
	public int minFlips(String target) {
        int res = 0;
        boolean flag = true;
        for(int i = 0; i < target.length(); i++) {
        	if((flag && target.charAt(i) == '1') || (!flag && target.charAt(i) == '0')) {
        		res++;
        		flag = !flag;
        	}
        }
        return res;
    }
	
	
	public static void main(String[] args) {
		BulbSwitcherIV test = new BulbSwitcherIV();
		System.out.println(test.minFlips("001011101"));
	}
	
}
