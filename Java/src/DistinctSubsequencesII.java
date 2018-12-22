
public class DistinctSubsequencesII {
	
	public int distinctSubseqII(String S) {
        long[] count = new long[26];
        long res = 1;
        int mod = 1000000007;
        for(int i = 0; i < S.length(); i++) {
        	char c = S.charAt(i);
        	long diff = (res + mod - count[c-'a']) % mod;
        	count[c-'a'] = res;
        	
        	res += diff;
        	res = res % mod;
        	count[c-'a'] = count[c-'a'] % mod;
        }
        return (int)((res-1)%mod);
    }
	
	public static void main(String[] args) {
		DistinctSubsequencesII test = new DistinctSubsequencesII();
		System.out.println(test.distinctSubseqII("blljuffdyfrkqtwfyfztpdiyktrhftgtabxxoibcclbjvirnqyynkyaqlxgyybkgyzvcahmytjdqqtctirnxfjpktxmjkojlvvrr"));
	}
}
