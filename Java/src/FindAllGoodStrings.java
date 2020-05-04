
public class FindAllGoodStrings {
	
	
	
//	public int findGoodStringsToPass(int n, String s1, String s2, String evil) {
//        long res = 0;
//        res += numberOfValidGT(s1, evil);
//        if(!s1.contains(evil)) res++;
//        long toRemove = numberOfValidGT(s2, evil);
//        res -= toRemove;
//        if(res < 0) res += mod;
//        return (int)(res%mod);
//    }
	
	private int mod = 1_000_000_000 + 7;
	public int findGoodStrings(int n, String s1, String s2, String evil) {
        long res = 0;
        res += numberOfValidGT(s1, evil);
        if(!s1.contains(evil)) res++;
        long toRemove = numberOfValidGT(s2, evil);
        res -= toRemove;
        if(res < 0) res += mod;
        return (int)(res%mod);
    }
	
	private long numberOfValidGT(String s, String evil) {
		long res = 0;
		StringBuilder sb = new StringBuilder();
		for(int i = 0; i < s.length(); i++) {
			for(char j = (char)(s.charAt(i)+1); j <= 'z'; j++) {
				sb.append(j);
				res += numberOfValidStr(sb.toString(), s.length(), evil);
				res = res % mod;
				sb.deleteCharAt(sb.length()-1);
			}
			sb.append(s.charAt(i));
		}
			
		return res;
	}
	
	private long numberOfValidStr(String prefix, int l, String evil) {
		if(prefix.contains(evil)) return 0;
		long[] dp = new long[l+1];
		for(int i = 0; i <= prefix.length(); i++) dp[i] = 1;
		
		for(int i = prefix.length()+1; i <= l; i++) {
			int s = i-evil.length()+1;
			if(s <= prefix.length() && s >= 1) {
				int len = prefix.length()-s+1;
				String sub1 = prefix.substring(s-1, prefix.length());
				String sub2 = evil.substring(0, 0+len);
				if(sub1.equals(sub2)) {
					dp[i] = dp[i-1] * 26 - dp[i-evil.length()]; 
				}else {
					dp[i] = dp[i-1] * 26;
				}
			} else {
				if(i >= evil.length()) {
					dp[i] = dp[i-1] * 26 - dp[i-evil.length()];
				}else {
					dp[i] = dp[i-1] * 26;
				}
			}
			
			dp[i] = dp[i] % mod;
			
		}
		
		return dp[l];
	}
	
	
	public static void main(String[] args) {
		FindAllGoodStrings test = new FindAllGoodStrings();
		System.out.println(test.findGoodStrings(24, "bqdkyblcurkzakgssmqlilwy", "uaklruspcoqrfleedknktbcu", "ziymrjsz"));
//		long a = 841618817;
//		System.out.println(a * 26);

	}
	
}
