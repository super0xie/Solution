import java.util.Arrays;

public class CheckIfaStringCanBreakAnotherString {
	public boolean checkIfCanBreak(String s1, String s2) {
        int[] count1 = new int[26];
        int[] count2 = new int[26];
        for(int i = 0; i < s1.length(); i++) 
        	count1[s1.charAt(i)-'a']++;
        for(int i = 0; i < s2.length(); i++) 
        	count2[s2.charAt(i)-'a']++;
        
        if(canBreak(count1, count2) || canBreak(count2, count1)) return true;
        return false;
    }
	
	private boolean canBreak(int[] c1, int[] c2) {
		int p1 = 0;
		int p2 = 0;
		int[] cc1 = Arrays.copyOf(c1, c1.length);
		int[] cc2 = Arrays.copyOf(c2, c2.length);
		
		while(p1 < 26 && p2 < 26) {
			while(p1 < 26 && cc1[p1] == 0) p1++;
			while(p2 < 26 && cc2[p2] == 0) p2++;
			
			if(p1 >= 26 || p2 >= 26) break;
			if(p1 >= p2) {
				cc1[p1]--;
				cc2[p2]--;
			}else {
				return false;
			}
		}
		return true;
	}
	
	public static void main(String[] args) {
		CheckIfaStringCanBreakAnotherString test = new CheckIfaStringCanBreakAnotherString();
		System.out.println(test.checkIfCanBreak("leetcodee", "interview"));
	}
}
