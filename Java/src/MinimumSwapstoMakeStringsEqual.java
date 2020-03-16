
public class MinimumSwapstoMakeStringsEqual {
	
	public int minimumSwap(String s1, String s2) {
		if(s1.length() != s2.length()) return -1;
		int x = 0;
		int y = 0;
		for(int i = 0; i < s1.length(); i++) {
			if(s1.charAt(i) == s2.charAt(i)) continue;
			if(s1.charAt(i) == 'x') x++;
			else y++;
		}
		
		if((x+y) % 2 == 1) return -1;
		
		if(x % 2 == 1) {
			return (x+y-2)/2 + 2;
		}else {
			return (x+y)/2;
		}
    }
	
	public static void main(String[] args) {
		MinimumSwapstoMakeStringsEqual test = new MinimumSwapstoMakeStringsEqual();
		System.out.println(test.minimumSwap("xxyxxyxyxxyxxy", "yyyxyxyxyyyxxx"));
	}
	
}
