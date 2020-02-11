
public class MinimumNumberofStepstoMakeTwoStringsAnagram {
	
	public int minSteps(String s, String t) {
		int n = s.length();
        int[] c1 = new int[26];
        int[] c2 = new int[26];
        
        for(int i = 0; i < n; i++) {
        	c1[s.charAt(i)-'a']++;
        	c2[t.charAt(i)-'a']++;
        }
        
        int max = Integer.MIN_VALUE;
        int sum = 0;
        int res = 0;
        for(int i = 0; i < 26; i++) {
        	sum += Math.abs(c1[i]-c2[i]);
        	max = Math.max(max, Math.abs(c1[i]-c2[i]));
        }
        
        if(sum % 2 == 1) {
        	sum--;
        	res++;
        	max--;
        }
        
        if(max > sum/2) {
        	res += max;
        }else {
        	res += sum / 2;
        }
        
        return res;
    }
	
	public static void main(String[] args) {
		MinimumNumberofStepstoMakeTwoStringsAnagram test = new MinimumNumberofStepstoMakeTwoStringsAnagram();
		System.out.println(test.minSteps("friend", "family"));
	}
	
}
